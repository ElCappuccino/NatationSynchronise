var xhr = getXMLHttpRequest();
var competitions = document.querySelector('#listeCompetitions');

competitions.addEventListener('change', competitionChange);

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

function competitionChange() {
	var url = "competition?selection=competition&valeur=" + escape(competitions.options[competitions.selectedIndex].value);
	xhr.open("GET", url, true);
	xhr.send(null);
}