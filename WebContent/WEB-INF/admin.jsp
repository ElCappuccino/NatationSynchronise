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
			<div class="row margin-bottom-30">
				<div class="col-md-12">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Inscrire une équipe à une compétition</h3>
							<p class="card-text"></p>
							<form>
								<div class="form-group row">
									<div class="col-2">
										<label for="listeClubs" class="col-form-label">Clubs
										</label>
									</div>
									<div class="col-10">
										<select class="form-control" id="listeClubs">
											<option value="0">Choisir le club</option>
											<c:forEach items="${listeClubs}" var="club">
												<option value="${club.id}">${club.nom}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-2">
										<label for="listeEquipes" class="col-form-label">Equipe
										</label>
									</div>
									<div class="col-10">
										<select class="form-control" id="listeEquipes">
											<option value="0">Choisir l'équipe</option>
											<c:forEach items="${listeEquipes}" var="equipe">
												<option value="${equipe.id}">${equipe.libelle}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-2">
										<label for="listeCompetitions" class="col-form-label">Compétitions
										</label>
									</div>
									<div class="col-10">
										<select class="form-control" id="listeCompetitions">
											<option value="0">Choisir la compétition</option>
											<c:forEach items="${listeCompetitions}" var="competition">
												<option value="${competition.id}">${competition.libelle} - du ${competition.dateDebut} au ${competition.dateFin}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div id="titulaire"></div>
								<div id="remplacant"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<h1>Données de l'application</h1>
			<div class="row">
				<%-- 
				Affichage des messages d'erreur
		 		--%>
				<div class="col-sm-12">
					<c:if test="${not empty messages['errImport']}">
						<div class="alert alert-danger">${ messages['errImport'] }</div>
					</c:if>
				</div>
				<%-- 
				Affichage des messages de succès
		 		--%>
				<div class="col-sm-12">
					<c:if test="${not empty messages['succesImport']}">
						<div class="alert alert-success">${ messages['succesImport'] }</div>
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
									style="margin-bottom: 0px; !important"> Parcourir... <input
									type="file" name="csvNageuses" id="csvNageuses" hidden>
								</label> <input type="submit" class="btn btn-success" value="Importer!"
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

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/AdminJS.js"></script>
	<jsp:include page="parts/footer.jsp" />
</body>
</html>