var xhr = getXMLHttpRequest();
var competitions = document.querySelector('#listeCompetitions');
var tours = document.querySelector("#listeTours");
var epreuves = document.querySelector("#listeEpreuves");
var ballets = document.querySelector("#listeBallets");
var equipes = document.querySelector("#listeEquipes");
var titulaire = document.querySelector("#titulaire");
var remplacant = document.querySelector("#remplacant");

competitions.addEventListener('change', competitionChange);
tours.addEventListener('change', tourChange);
epreuves.addEventListener('change', epreuveChange);
ballets.addEventListener('change', balletChange);
equipes.addEventListener('change', equipeChange);

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
	var htmlTitulaire = '<h3>Titulaire</h3><table ><tr><th></th><th>Nageuse</th><th>Figure</th><th>Note</th>'; // class="table table-striped"
	if(juge == "Element")
		htmlTitulaire += "<th>Note</th><th>Note</th><th>Note</th>";
	htmlTitulaire += "</tr>"
	for(var key in data["nageusesT"]) {
		htmlTitulaire += "<tr>";
		
		htmlTitulaire += '<td><input type="checkbox" value="' + key + '"></td>';
		htmlTitulaire += "<td>" + data["nageusesT"][key] + "</td>";
		
		htmlTitulaire += '<table><tr>';
		htmlTitulaire += '<td><select class="form-control" id="listeFigure">';
		for(var key in data["figures"]) {
			htmlTitulaire += '<option value="' + key + '">' + data["figures"][key] + '</option>';
		}
		
		htmlTitulaire += "<td></td>";
		if(juge == "Element") {
			htmlTitulaire += "<td></td>";
			htmlTitulaire += "<td></td>";
			htmlTitulaire += "<td></td>";
		}
		
		htmlTitulaire += "</table></tr>";
		
		htmlTitulaire += "</tr>";
	}
	htmlTitulaire += "</table>";
	titulaire.innerHTML = htmlTitulaire;
	
	
}

//---------

//---- Event change

function competitionChange() {
	// Clear options
	clearTours();
	clearEpreuves();
	clearBallets();
	clearEquipes();
    
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
	
	// On envoit la requete
	var value =  escape(epreuves.options[epreuves.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=epreuve&valeur=" + value;
	request(readDataBallet, url);
}

function balletChange() {
	clearEquipes();
	// On envoit la requete
	var value =  escape(ballets.options[ballets.selectedIndex].value);
    if(value == "0")
    	return;
    var valueCompet = escape(competitions.options[competitions.selectedIndex].value);
    var url = "competition?selection=ballet&valeur=" + value + "&compvaleur=" + valueCompet;
	request(readDataEquipe, url);
}

function equipeChange() {
	// TODO Nettoyez les divs qui contiennent les tableaux de nageuses
	
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

//---------


