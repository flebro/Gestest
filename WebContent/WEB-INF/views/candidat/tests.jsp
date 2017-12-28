<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<ul class="collection">
			<c:forEach items="${tests }" var="test">
				<li class="collection-item">
					<h5 class="title">${test.nom }</h5>
					<div>
						<ul class="collection">
							<c:forEach items="${test.questionnaires }" var="questionnaire">
								<li class="collection-item">
									<div>
										 ${questionnaire.nom}
										 <a class="secondary-content"
											href="questionnaire/${questionnaire.id}"
											title="Commencer"> <i class="material-icons">play_arrow</i>
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