<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="parts/head.jsp" />

<body>
	<jsp:include page="parts/logo.jsp" />
	<jsp:include page="parts/menu.jsp" />
	<div class="container">
		<div class="justify-content-center blocFondBlanc">
			<h1>Panneau d'administration</h1>
			<div class="row">
				<%-- 
				Affichage des messages d'erreur
		 		--%>
		 		<div class="col-sm-12">
					<c:if test="${not empty erreurs['errImport']}">
						<div class="alert alert-danger">${ erreurs['errImport'] }</div>
					</c:if>
				</div>
				<%-- 
				Affichage des messages de succès
		 		--%>
		 		<div class="col-sm-12">
					<c:if test="${not empty erreurs['errImport']}">
						<div class="alert alert-danger">${ erreurs['errImport'] }</div>
					</c:if>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Importer des nageuses</h3>
							<p class="card-text">Ajouter un fichier CSV puis cliquer sur
								Importer</p>
							<form action="admin" method="post" enctype="multipart/form-data">
								<%-- Hack pour pouvoir appliquer le style bootstrap aux boutons type "file" --%>
								<label class="btn btn-primary"
									style="margin-bottom: 0px; !important"> Parcourir...
									<input type="file" name="csvNageuses" id="csvNageuses" hidden>
								</label> 
								<input type="submit" class="btn btn-success" value="Importer!"
									name="subCsvNageuses" id="subCsvNageuses">
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Exporter les nageuses</h3>
							<p class="card-text">Génération d'un fichier CSV contenant
								les nageuses enregistrées.</p>
							<a href="#" class="btn btn-success">Exporter!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="parts/footer.jsp" />
</body>
</html>