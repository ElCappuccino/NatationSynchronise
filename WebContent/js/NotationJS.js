var xhr = getXMLHttpRequest();
var competitions = document.querySelector('#listeCompetitions');
var tours = document.querySelector("#listeTours");

competitions.addEventListener('change', competitionChange);

function request(callback) {
	xhr.onreadystatechange = function() {
	    if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	    	callback(xhr.response);
	    }
	};
	
	var url = "competition?selection=competition&valeur=" + escape(competitions.options[competitions.selectedIndex].value);
	xhr.open("GET", url, true);
	xhr.responseType = 'json';
	xhr.send(null);
	console.log("Content-Type: %s", xhr.getResponseHeader("Content-Type"));
}

function readData(data) {
	for(var key in data) {
	   var option = document.createElement("option");
	   option.value = key;
	   option.text = data[key];
	   tours.add(option);
	}
}

function competitionChange() {
	// Clear options
	var i;
    for(i = tours.options.length - 1 ; i >= 0 ; i--)
    {
    	tours.remove(i);
    }
    // On envoit la requete
	request(readData)
}

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