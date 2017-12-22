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
		<div class="container">
			<div class="justify-content-center blocFondBlanc">
				<div class="row">
					<h1>Competition</h1>
					<c:if test="${not empty erreurs['getCompetitionsByUser']}">
						<div class="alert alert-danger">${ erreurs['getCompetitionsByUser'] }</div>
					</c:if>
				</div>
				<form>
					<div class="form-group row">
						<div class="col-2">
							<label for="listeCompetitions" class="col-form-label">Compétitions
							</label>
						</div>
						<div class="col-10">
							<select class="form-control" id="listeCompetitions">
								<c:forEach items="${listeCompetitions}" var="competition">
									<option>${competition.libelle}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/NotationJS.js"></script>
	<jsp:include page="parts/footer.jsp" />
</body>
</html>