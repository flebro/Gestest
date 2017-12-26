<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="row">
		<form:form class="col s12" action="/Gestest/questionnaire/${questionnaireId }/question/${questionId }/proposition/${proposition.id }" method="post"
			modelAttribute="proposition">
			<div class="row">
				<div class="input-field">
					<form:input id="intitule" path="intitule" type="text" class="validate" />
					<form:label path="intitule">Intitul�</form:label>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary right">Enregistrer</button>
			</div>
		</form:form>
	</div>
</div>