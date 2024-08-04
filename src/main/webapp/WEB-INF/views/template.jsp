<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:insertAttribute name="title"  ignore="true"/></title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header"  ignore="true" />
	</header>
	<!-- 
	<nav>
		<tiles:insertAttribute name="navigation" ignore="true" />
	</nav>
	 -->
	 
	<main>
		<tiles:insertAttribute name="content"  ignore="true"/>
	</main>
	
	<footer>
		<tiles:insertAttribute name="footer"  ignore="true" />
	</footer>
</body>
</html>