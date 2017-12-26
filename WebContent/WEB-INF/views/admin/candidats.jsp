<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="row">
		<h4 class="header">Nouveau Candidat</h4>
		<form:form class="col s12" action="admin/candidat" method="post"
			modelAttribute="newCandidat">
			<div class="row">
				<div class="input-field">
					<form:input id="nom" path="nom" type="text" class="validate" />
					<form:label path="nom">Nom</form:label>
				</div>
			</div>
			<div class="row">
				<div class="input-field">
					<form:input id="prenom" path="prenom" type="text" class="validate" />
					<form:label path="prenom">Prenom</form:label>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary right">Ajouter</button>
			</div>
		</form:form>
	</div>

	<div class="row">
		<ul class="collection">
			<c:forEach items="${candidats}" var="candidat">
				<p>Nom : ${candidat.nom }</p>
				<p>Prenom : ${candidat.prenom }</p>
				<p>Clé : ${candidat.cle }</p>
			</c:forEach>
		</ul>
	</div>
</div>