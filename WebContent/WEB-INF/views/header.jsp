<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul id="nav-mobile" class="right hide-on-med-and-down">
	<c:choose>
		<c:when test="${user != null }">
			<c:if test="${user.admin}">
				<li><a class='waves-effect waves-light dropdown-button btn'
					href='#' data-activates='dropdownAdmin'>Administration</a></li>
			</c:if>

			<li><a href="/Gestest/logout"
				class="waves-effect waves-light btn">Déconnexion</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/Gestest/loginAdmin"
				class="waves-effect waves-light btn">Accès Administrateur</a></li>
		</c:otherwise>
	</c:choose>
</ul>

<ul id='dropdownAdmin' class='dropdown-content'>
	<li><a href="/Gestest/admin/candidats">Candidats</a></li>
	<li><a href="/Gestest/admin/tests">Tests</a></li>
	<li><a href="/Gestest/admin/questionnaires">Questionnaires</a></li>
</ul>
