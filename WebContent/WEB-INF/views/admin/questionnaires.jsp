<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<h4 class="header">Nouveau questionnaire</h4>
		<form class="col s12" action="questionnaire" method="post">
			<div class="row">
				<div class="input-field">
					<input id="nom" name="nom" type="text" class="validate" /> <label
						for="nom">Nom</label>
					<button type="submit" class="btn btn-primary right">Ajouter</button>
				</div>
			</div>
		</form>
	</div>

	<div class="row">
		<ul class="collection">
			<c:forEach items="${questionnaires }" var="questionnaire">
				<li class="collection-item"><span class="title">${questionnaire.nom }</span><a
					href="questionnaire/${questionnaire.id}" class="secondary-content"><i
						class="material-icons">edit</i></a></li>
			</c:forEach>
		</ul>
	</div>
</div>