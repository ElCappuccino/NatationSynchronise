<jsp:include page="head.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-offset-5.col-3 h1">Connexion</div>
		</div>

		<div class="row">
			<form method="post" action="connect">
				<div class="form-group">
					<label for="identifiant">Identifiant</label> <input type="text"
						class="form-control" id="identifiant" name="identifiant"
						placeholder="Identifiant" />
				</div>

				<div class="form-group">
					<label for="password">Mot de passe</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Mot de passe" />
				</div>

				<%-- 
					Affichage des messages d'erreur
				 --%>
				<c:if test="${not empty erreurs['errChamps']}">
					<div class="alert alert-danger">${ erreurs['errChamps'] }</div>
				</c:if>

				<button type="submit" class="btn btn-primary">Se connecter</button>
			</form>
		</div>

	</div>
</body>