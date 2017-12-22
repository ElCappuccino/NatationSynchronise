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
		<h1>Competition</h1>
		<c:if test="${not empty erreurs['getCompetitionsByUser']}">
			<div class="alert alert-danger">${ erreurs['getCompetitionsByUser'] }</div>
		</c:if>
		<form>
			<div class="form-group">
				<label for="listeCompetitions">Compétitions </label> 
				<select
					class="form-control" id="listeCompetitions">
					<c:forEach items="${listeCompetitions}" var="competition">
						<option>test</option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/NotationJS.js"></script>
	<jsp:include page="parts/footer.jsp" />
</body>
</html>