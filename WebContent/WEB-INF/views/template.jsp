<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="/Gestest/css/materialize.min.css" media="screen,projection" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="pageTitle" /></title>
</head>
<body>
<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/Gestest/js/materialize.min.js"></script>

	<header> <nav>
	<div class="nav-wrapper">
		<a href="/Gestest/home" class="brand-logo">Gestest - <tiles:insertAttribute
				name="pageTitle" /></a>
		<tiles:insertAttribute name="navContent" />
	</div>
	</nav> </header>

	<tiles:insertAttribute name="content" />

	
</body>
</html>