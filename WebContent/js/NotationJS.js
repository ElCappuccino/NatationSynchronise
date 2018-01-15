var xhr = getXMLHttpRequest();
var competitions = document.querySelector('#listeCompetitions');
var tours = document.querySelector("#listeTours");
var epreuves = document.querySelector("#listeEpreuves");
var ballets = document.querySelector("#listeBallets");
var equipes = document.querySelector("#listeEquipes");
var titulaire = document.querySelector("#titulaire");
var remplacant = document.querySelector("#remplacant");
var valider = document.querySelector("#valider");

competitions.addEventListener('change', competitionChange);
tours.addEventListener('change', tourChange);
epreuves.addEventListener('change', epreuveChange);
ballets.addEventListener('change', balletChange);
equipes.addEventListener('change', equipeChange);
valider.addEventListener('click', envoyerDonnees);

$("#valider").hide();

// ---- AJAX

function getXMLHttpRequest() {
	var xhr = null;
	if (window.XMLHttpRequest || window.ActiveXObject) {
		if (window.ActiveXObject) {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else {
			xhr = new XMLHttpRequest();
		}
	} else {
		alert("Votre navigateur ne supporte pas l'objet XMLHTTPRequest...");
		return null;
	}
	return xhr;
}

function request(callback, url) {
	xhr.onreadystatechange = function() {
	    if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	    	callback(xhr.response);
	    }
	};
	
	
	xhr.open("GET", url, true);
	xhr.responseType = 'json';
	xhr.send(null);
	console.log("Content-Type: %s", xhr.getResponseHeader("Content-Type"));
}

function readDataTours(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir le tour";
	tours.add(option);
		
	for(var key in data) {
		var option = document.createElement("option");
		option.value = key;
		option.text = data[key];
		tours.add(option);
	}
}

function readDataEpreuve(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir l'épreuve";
	epreuves.add(option);
	
	for(var key in data) {
	   var option = document.createElement("option");
	   option.value = key;
	   option.text = data[key];
	   epreuves.add(option);
	}
}

function readDataBallet(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir le ballet";
	ballets.add(option);
	
	for(var key in data) {
	   var option = document.createElement("option");
	   option.value = key;
	   option.text = data[key];
	   ballets.add(option);
	}
}

function readDataEquipe(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir une équipe";
	equipes.add(option);
	
	for(var key in data) {
	   var option = document.createElement("option");
	   option.value = key;
	   option.text = data[key];
	   equipes.add(option);
	}
}

function readDataNageuse(data) {
	var juge = data["infoUser"]["0"];
	var htmlTitulaire = '<h3>Titulaire</h3><table class="table table-striped"><tr><th></th><th>Nageuse</th><th>Figure</th><th>Note</th>';
	if(juge == "Element")
		htmlTitulaire += "<th>Note</th><th>Note</th><th>Note</th>";
	htmlTitulaire += "</tr>"
	for(var keyNT in data["nageusesT"]) {
		htmlTitulaire += "<tr>";
		
		htmlTitulaire += '<td><input type="checkbox" name="nageuse[]" idNageuse="' + keyNT + '"></td>';
		htmlTitulaire += "<td>" + data["nageusesT"][keyNT] + "</td>";
		
		htmlTitulaire += '<td><select class="form-control" name="listeFigure[]' + keyNT + '">';
		for(var keyF in data["figures"]) {
			htmlTitulaire += '<option value="' + keyF + '">' + data["figures"][keyF] + '</option>';
		}
		
		htmlTitulaire += '<td><input type="number" class="form-control" name="note[]" min="0" max="100"></td>';
		if(juge == "Element") {
			htmlTitulaire += '<td><input type="number" class="form-control" name="note[]" min="0" max="100"></td>';
			htmlTitulaire += '<td><input type="number" class="form-control" name="note[]" min="0" max="100"></td>';
			htmlTitulaire += '<td><input type="number" class="form-control" name="note[]" min="0" max="100"></td>';
		}
		
		htmlTitulaire += "</tr>";
	}
	htmlTitulaire += "</table>";
	titulaire.innerHTML = htmlTitulaire;
	
	
	var htmlRemplacant = '<h3>Remplaçante</h3><table class="table table-striped"><tr><th></th><th>Nageuse</th><th>Figure</th><th>Note</th>';
	if(juge == "Element")
		htmlRemplacant += "<th>Note</th><th>Note</th><th>Note</th>";
	htmlRemplacant += "</tr>"
	for(var keyNR in data["nageusesR"]) {
		htmlRemplacant += "<tr>";
		
		htmlRemplacant += '<td><input type="checkbox" value="' + keyNR + '"></td>';
		htmlRemplacant += "<td>" + data["nageusesR"][keyNR] + "</td>";
		
		htmlRemplacant += '<td><select class="form-control" id="listeFigure_' + keyNR + '">';
		for(var keyF in data["figures"]) {
			htmlRemplacant += '<option value="' + keyF + '">' + data["figures"][keyF] + '</option>';
		}
		
		htmlRemplacant += '<td><input type="number" class="form-control" name="note1_' + keyNR + '" min="0" max="10"></td>';
		if(juge == "Element") {
			htmlRemplacant += '<td><input type="number" class="form-control" name="note1_' + keyNR + '" min="0" max="10"></td>';
			htmlRemplacant += '<td><input type="number" class="form-control" name="note2_' + keyNR + '" min="0" max="10"></td>';
			htmlRemplacant += '<td><input type="number" class="form-control" name="note3_' + keyNR + '" min="0" max="10"></td>';
		}
		
		htmlRemplacant += "</tr>";
	}
	htmlRemplacant += "</table>";
	remplacant.innerHTML = htmlRemplacant;
	
	$("#valider").show();
}

//---------

//---- Event change

function competitionChange() {
	// Clear options
	clearTours();
	clearEpreuves();
	clearBallets();
	clearEquipes();
	clearNageuseArray();
    
    // On envoit la requete
    var value =  escape(competitions.options[competitions.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=competition&valeur=" + value;
	request(readDataTours, url);
}

function tourChange() {
	// Clear options
	clearEpreuves();
	clearBallets();
	clearEquipes();
	clearNageuseArray();
    
    // On envoit la requete
    var value =  escape(tours.options[tours.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=tour&valeur=" + value;
	request(readDataEpreuve, url);
}

function epreuveChange() {
	// Clear options
	clearBallets();
	clearEquipes();
	clearNageuseArray();
	
	// On envoit la requete
	var value =  escape(epreuves.options[epreuves.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=epreuve&valeur=" + value;
	request(readDataBallet, url);
}

function balletChange() {
	clearEquipes();
	clearNageuseArray();
	
	// On envoit la requete
	var value =  escape(ballets.options[ballets.selectedIndex].value);
    if(value == "0")
    	return;
    var valueCompet = escape(competitions.options[competitions.selectedIndex].value);
    var url = "competition?selection=ballet&valeur=" + value + "&compvaleur=" + valueCompet;
	request(readDataEquipe, url);
}

function equipeChange() {
	clearNageuseArray();
	
	// On envoit la requete
	var value =  escape(equipes.options[equipes.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=equipe&valeur=" + value;
	request(readDataNageuse, url);
}

//---------

//---- Nettoyage des listes

function clearTours() {
	var i;
    for(i = tours.options.length - 1 ; i >= 0 ; i--)
    {
    	tours.remove(i);
    }
}
function clearEpreuves() {
	var i;
    for(i = epreuves.options.length - 1 ; i >= 0 ; i--)
    {
    	epreuves.remove(i);
    }
}

function clearBallets() {
	var i;
    for(i = ballets.options.length - 1 ; i >= 0 ; i--)
    {
    	ballets.remove(i);
    }
}

function clearEquipes() {
	var i;
    for(i = equipes.options.length - 1 ; i >= 0 ; i--)
    {
    	equipes.remove(i);
    }
}

function clearNageuseArray() {
	titulaire.innerHTML = "";
	remplacant.innerHTML = "";
}

//---------

function envoyerDonnees() {
	var note = document.forms[0].elements["note[]"];
	console.log(note);
}

$('#form_Compet').submit(function(ev) {
    //ev.preventDefault(); // to stop the form from submitting
    /* Validations go here */
    this.submit(); // If all the validations succeeded
});


