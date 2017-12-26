<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).ready(function() {
		$('#questionnaireAjoutId').material_select();
	});
</script>

<div class="container">
	<div class="row">
		<h4 class="header">${test.nom}</h4>
	</div>

	<div class="row">
		<h5>Associer un questionnaire</h5>

		<form class="col s12" action="/Gestest/test/${test.id}/questionnaire"
			method="post">

			<select id="questionnaireAjoutId" name="questionnaireAjoutId">
				<c:forEach items="${questionnairesDisponibles }" var="questDispo">
					<option value="${questDispo.id }">${questDispo.nom }</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary right">Ajouter</button>
		</form>
	</div>

	<div class="row">
		<h5>Questionnaires associés</h5>

		<ul class="collection">
			<c:forEach items="${test.questionnaires }" var="questionnaire">
				<li class="collection-item">
					<div>${questionnaire.nom}<a href="#!" title="Désassocier"
							class="secondary-content"
							onclick="$.ajax({
						    type: 'DELETE',
						    url: 'http://localhost:8080/Gestest/test/${test.id}/questionnaire/${questionnaire.id}',
						    complete:
					            function () {
					                    window.location = 'http://localhost:8080/Gestest/test/${test.id}';                
					            }
						});">
							<i class="material-icons">close</i>
						</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>