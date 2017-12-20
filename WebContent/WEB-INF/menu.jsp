<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="head.jsp" />

<div class="container">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<c:choose>
					<c:when
						test="${pageContext.request.requestURI == '/NatationSynchronise/WEB-INF/accueil.jsp' }">
						<li class="active"><a href="/NatationSynchronise/accueil">Accueil</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/NatationSynchronise/accueil">Accueil</a></li>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when
						test="${pageContext.request.requestURI == '/NatationSynchronise/WEB-INF/competition.jsp' }">
						<li class="active"><a href="/NatationSynchronise/competition">Compétition</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/NatationSynchronise/competition">Compétition</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${sessionScope.userBean.admin}">
					<li><a href="">Administration</a></li>
				</c:if>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/NatationSynchronise/logout">Déconnexion</a></li>
			</ul>
		</div>
	</nav>
</div>

