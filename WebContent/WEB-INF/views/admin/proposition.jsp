<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	$(document).ready(function() {
		$('input[type=checkbox]').each(function() {

	        var name = $(this).attr('name');
	        $('[name="' + '_' + name + '"]').remove();

	});
	});
</script>

<div class="container">
	<div class="row">
		<form:form class="col s12"
			action="/Gestest/admin/questionnaire/${questionnaireId }/question/${questionId }/proposition/${proposition.id }"
			method="post" modelAttribute="proposition">
			<div class="row">
				<div class="input-field">
					<form:input id="intitule" path="intitule" type="text"
						class="validate" />
					<form:label path="intitule">Intitulé</form:label>
				</div>
			</div>
			<div class="row">
				<div>
					<form:checkbox id="bonneReponse" path="bonneReponse" />
					<form:label path="bonneReponse">Bonne réponse</form:label>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary right">Enregistrer</button>
			</div>
		</form:form>
	</div>
</div>