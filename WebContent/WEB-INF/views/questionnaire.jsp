<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<h4 class="header">Nom : ${questionnaire.nom}</h4>
	</div>

	<div class="row">
		<h5>Questions</h5>
	</div>
	<div class="row">
		<a href="/Gestest/questionnaire/${questionnaire.id}/question/"
			class="waves-effect waves-light btn">Nouvelle question</a>

		<ul class="collection">
			<c:forEach items="${questionnaire.questions }" var="question">
				<li class="collection-item">
					<div>${question.intitule}
						<a href="#!" title="Supprimer" class="secondary-content"
							onclick="$.ajax({
								    type: 'DELETE',
								    url: 'http://localhost:8080/Gestest/questionnaire/${questionnaire.id}/question/${question.id}',
								    complete:
							            function () {
							                    window.location = 'http://localhost:8080/Gestest/questionnaire/${questionnaire.id}';                
							            }
								});">
							<i class="material-icons">delete</i>
						</a> <a class="secondary-content"
							href="/Gestest/questionnaire/${questionnaire.id}/question/${question.id}"
							title="Editer"> <i class="material-icons">edit</i>
						</a> <a class="secondary-content"
							href="/Gestest/questionnaire/${questionnaire.id}/question/${question.id}/proposition"
							title="Ajouter une proposition"> <i class="material-icons">add</i>
						</a>
					</div>
					<div>
						<ul class="collection">
							<c:forEach items="${question.propositions }" var="proposition">
								<li class="collection-item">
									<div>${proposition.intitule}</div>
								</li>
							</c:forEach>
						</ul>
					</div>
			</c:forEach>
		</ul>
	</div>
</div>