<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="head.jsp" />
<body>
	<header>
		Header
		<c:out value="SEKS"/>
	</header>
	<div class="container">
		<nav class="navbar navbar-default">
		  	<div class="container-fluid">
			    <ul class="nav navbar-nav">
			    	<c:choose>
			    		<c:when test="${request.requestURI == '/NatationSynchro/accueil' }"><li class="active"><a href="/NatationSynchro/accueil">Accueil</a></li></c:when>
			    		<c:otherwise><li><a href="/NatationSynchro/accueil">Accueil</a></li></c:otherwise>
			    	</c:choose>
			    	
				    <li><a href="/NatationSynchro/competition">Compétition</a></li>
				    <li><a href="">Administration</a></li>
			    </ul>
			    <ul class="nav navbar-nav navbar-right">
					<li><a href="">Déconnexion</a></li>
	    		</ul>
			</div>
		</nav>
	</div>
</body>