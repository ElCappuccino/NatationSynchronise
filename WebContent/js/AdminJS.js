var xhr = getXMLHttpRequest();
var clubs = document.querySelector('#listeClubs');
var equipes = document.querySelector("#listeEquipes");
var competitions = document.querySelector('#listeCompetitions');

// --- Binding des listeners aux listes
clubs.addEventListener('change', clubsChange);
equipes.addEventListener('change', equipeChange);
//competitions.addEventListener('change', competitionChange);

/**
 * Instanciation d'un objet XMLHttpRequest
 */
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

/**
 * Vérifie que l'objet XMLHttpRequest est instancié correctement, puis execute
 * une fonction passée en paramètre
 * 
 * @param callback
 *            la fonction a executer
 * @param url
 */
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

//------
//--- Helpers
//------

/**
 * Valorise la liste des equipes
 * 
 * @param data
 */
function readEquipes(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir l'équipe";
	equipes.add(option);

	for ( var key in data) {
		var option = document.createElement("option");
		option.value = key;
		option.text = data[key];
		equipes.add(option);
	}
}

/**
 * Valorise la liste des compétitions
 * 
 * @param data
 */
function readCompetitions(data) {
	var option = document.createElement("option");
	option.value = "0";
	option.text = "Choisir la compétition";
	competitions.add(option);

	for ( var key in data) {
		var option = document.createElement("option");
		option.value = key;
		option.text = data[key];
		competitions.add(option);
	}
}

/**
 * Nettoie la liste des équipes
 */
function clearEquipes() {
	var i;
	for (i = equipes.options.length - 1; i >= 0; i--) {
		equipes.remove(i);
	}
}

/**
 * Nettoie la liste des compétitions
 */
function clearCompetitions() {
	var i;
	for (i = competitions.options.length - 1; i >= 0; i--) {
		competitions.remove(i);
	}
}

// ------
// --- Methodes listeners
// ------

/**
 * Changement de club : On nettoie les listes equipe et competition puis on
 * refresh la listes des equipes selon la nouvelle valeur de la liste clubs
 */
function clubChange() {
	// Clear options
	clearCompetitions();
	clearEquipes();

	// On envoit la requete
	var value = escape(clubs.options[clubs.selectedIndex].value);
	if (value == "0")
		return;
	var url = "admin?selection=club&valeur=" + value;
	request(readCompetitions, url);
}

/**
 * Changement d'équipe : On nettoie la liste des competitions puis on
 * refresh la listes des equipes selon la nouvelle valeur de la liste clubs
 */
function equipeChange() {
	// Clear options
	clearCompetitions();

	// On envoit la requete
	var value = escape(equipes.options[equipes.selectedIndex].value);
	if (value == "0")
		return;
	var url = "admin?selection=equipe&valeur=" + value;
	request(readEquipes, url);
}

