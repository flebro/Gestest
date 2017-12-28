<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<h4 class="header">Nom : ${questionnaire.nom}</h4>
	</div>

	<div class="row">
		<h5>Questions</h5>
	</div>
	<div class="row">
		<a href="${questionnaire.id}/question/"
			class="waves-effect waves-light btn">Nouvelle question</a>

		<ul class="collection">
			<c:forEach items="${questionnaire.questions }" var="question">
				<li class="collection-item">
					<div>${question.intitule}
						<a href="#!" title="Supprimer" class="secondary-content"
							onclick="$.ajax({
								    type: 'DELETE',
								    url: '/Gestest/admin/questionnaire/${questionnaire.id}/question/${question.id}',
								    complete:
							            function () {
							                    window.location = '/Gestest/admin/questionnaire/${questionnaire.id}';                
							            }
								});">
							<i class="material-icons">delete</i>
						</a> <a class="secondary-content"
							href="${questionnaire.id}/question/${question.id}"
							title="Editer"> <i class="material-icons">edit</i>
						</a> <a class="secondary-content"
							href="${questionnaire.id}/question/${question.id}/proposition"
							title="Ajouter une proposition"> <i class="material-icons">add</i>
						</a>
					</div>
					<div>
						<ul class="collection">
							<c:forEach items="${question.propositions }" var="proposition">
								<li class="collection-item">
									<div>
										<c:choose>
											<c:when test="${proposition.bonneReponse }"><i class="material-icons">check_box</i></c:when>
											<c:otherwise><i class="material-icons">check_box_outline_blank</i></c:otherwise>
										</c:choose>
										 ${proposition.intitule} <a
											href="#!" title="Supprimer" class="secondary-content"
											onclick="$.ajax({
											    type: 'DELETE',
											    url: '/Gestest/admin/questionnaire/${questionnaire.id}/question/${question.id}/proposition/${proposition.id }',
											    complete:
										            function () {
										                    window.location = '/Gestest/admin/questionnaire/${questionnaire.id}';                
										            }
											});">	
											<i class="material-icons">delete</i>
										</a> <a class="secondary-content"
											href="${questionnaire.id}/question/${question.id}/proposition/${proposition.id }"
											title="Editer"> <i class="material-icons">edit</i>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
			</c:forEach>
		</ul>
	</div>
</div>