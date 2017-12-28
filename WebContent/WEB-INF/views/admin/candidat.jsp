<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).ready(function() {
		$('#testAjoutId').material_select();
	});
</script>

<div class="container">
	<div class="row">
		<h4 class="header">${test.nom}</h4>
	</div>

	<div class="row">
		<h5>Associer un test</h5>

		<form class="col s12" action="${candidat.id}/test"
			method="post">

			<select id="testAjoutId" name="testAjoutId">
				<c:forEach items="${testsDisponibles }" var="testDispo">
					<option value="${testDispo.id }">${testDispo.nom }</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary right">Ajouter</button>
		</form>
	</div>

	<div class="row">
		<h5>Tests associés</h5>

		<ul class="collection">
			<c:forEach items="${candidat.tests }" var="test">
				<li class="collection-item">
					<div>${test.nom}<a href="#!" class="secondary-content" title="Désassocier"
							onclick="$.ajax({
						    type: 'DELETE',
						    url: '/Gestest/admin/candidat/${candidat.id}/test/${test.id}',
						    complete:
					            function () {
					                    window.location = '/Gestest/admin/candidat/${candidat.id}';                
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