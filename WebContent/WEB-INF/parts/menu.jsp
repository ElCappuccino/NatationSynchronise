<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<nav class="menu navbar navbar-toggleable-sm navbar-light bg-faded">
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<a class="navbar-brand" href="/NatationSynchronise/accueil">
		<img src="${pageContext.request.contextPath}/img/logo_ffn_light.png" width="21" height="30" class="d-inline-block align-top" alt="">
		FFC
	</a>
	
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<ul class="navbar-nav mr-auto">
	    	<c:choose>
				<c:when
					test="${pageContext.request.requestURI == '/NatationSynchronise/WEB-INF/accueil.jsp' }">
					<li class="nav-item active">
						<a class="nav-link" href="/NatationSynchronise/accueil">Accueil</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="/NatationSynchronise/accueil">Accueil</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${pageContext.request.requestURI == '/NatationSynchronise/WEB-INF/competition.jsp' }">
					<li class="nav-item active">
						<a class="nav-link" href="/NatationSynchronise/competition">Compétition</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="/NatationSynchronise/competition">Compétition</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="/NatationSynchronise/logout">Déconnexion</a>
			</li>
		</ul>
	</div>
</nav>
