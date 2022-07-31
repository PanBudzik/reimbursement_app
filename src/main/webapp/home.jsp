<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Claims</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("userId") == null)
		response.sendRedirect("index.jsp");
	%>
	<div>
	<h2>Hi, how can I help you?</h2>
	
	<form action="iniciateTrip" method="post">
		<input type="submit" value="Add new reimbursement claim" />
	</form>

	<form action="Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	</div>

</body>
</html>