<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<ul id="nav-mobile" class="right hide-on-med-and-down">

	<sec:authorize access="hasRole('ADMIN')">

		<li><a href="/Gestest/logout" 
			class="waves-effect waves-light btn">D�connexion</a></li>
		<li><a class='waves-effect waves-light dropdown-button btn'
			href='#' data-activates='dropdownAdmin'>Administration</a></li>

	</sec:authorize>

	<c:choose>
		<c:when test="${user != null }">
			<li><a href="/Gestest/logout"
			class="waves-effect waves-light btn">D�connexion</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/Gestest/loginAdmin"
				class="waves-effect waves-light btn">Acc�s Administrateur</a></li>
		</c:otherwise>
	</c:choose>
</ul>

<ul id='dropdownAdmin' class='dropdown-content'>
	<li><a href="/Gestest/admin/candidats">Candidats</a></li>
	<li><a href="/Gestest/admin/tests">Tests</a></li>
	<li><a href="/Gestest/admin/questionnaires">Questionnaires</a></li>
</ul>
