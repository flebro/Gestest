<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<h4 class="header">Nom : ${questionnaire.nom}</h4>
	</div>

	<div class="row">
		<h5>Questions</h5>
	</div>
	<div class="row">
		<ul class="collection">
			<c:forEach items="${questionnaire.questions }" var="question">
				<li class="collection-item">
					<div><h5>${question.intitule}</h5></div>
					<div>
						<ul class="collection">
							<c:forEach items="${question.propositions }" var="proposition">
								<li class="collection-item">
									<div>
										<input type="checkbox" id="${proposition.id }" /> 
										<label for="${proposition.id }">${proposition.intitule }</label>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
			</c:forEach>
		</ul>
	</div>
</div>