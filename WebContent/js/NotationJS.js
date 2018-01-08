var xhr = getXMLHttpRequest();
var competitions = document.querySelector('#listeCompetitions');
var tours = document.querySelector("#listeTours");
var epreuves = document.querySelector("#listeEpreuves");
var ballets = document.querySelector("#listeBallets");

competitions.addEventListener('change', competitionChange);
tours.addEventListener('change', tourChange);
epreuves.addEventListener('change', epreuveChange);
ballets.addEventListener('change', balletChange);

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

function readDataNageuse(data) {

}

//---------

//---- Event change

function competitionChange() {
	// Clear options
	clearTours();
	clearEpreuves();
	clearBallets();
    
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
	
	// On envoit la requete
	var value =  escape(epreuves.options[epreuves.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=epreuve&valeur=" + value;
	request(readDataBallet, url);
}

function balletChange() {
	// On envoit la requete
	var value =  escape(ballets.options[ballets.selectedIndex].value);
    if(value == "0")
    	return;
    var url = "competition?selection=ballet&valeur=" + value;
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

//---------


