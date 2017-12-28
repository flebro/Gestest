<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<form class="col s12" action="test" method="post">
			<div class="row">
				<div class="input-field">
					<input id="nom" name="nom" type="text" class="validate" /> <label
						for="nom">Nouveau Test</label>
					<button type="submit" class="btn btn-primary right">Ajouter</button>
				</div>
			</div>
		</form>
	</div>

	<div class="row">
		<ul class="collection">
			<c:forEach items="${tests }" var="test">
				<li class="collection-item"><span class="title">${test.nom }</span><a
					href="test/${test.id}" class="secondary-content"><i
						class="material-icons">edit</i></a></li>
			</c:forEach>
		</ul>
	</div>
</div>