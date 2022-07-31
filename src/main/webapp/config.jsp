<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin config</title>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("adminMode") == null)
		response.sendRedirect("index.jsp");
	%>
	<div>
	<h2>Configuration</h2>
	<form action="Reconfigure">
		Mileage change rate (per km):<input type="number" name="rateMilage" value="${sessionScope.rateMilage}" required><br>
		Daily allowance:<input type="number" name="rateAllowance" step="0.01" value="${sessionScope.rateAllowance}" required><br>
		Total reimbursement limit:<input type="number" name="limitTotal" step="0.01" value="${sessionScope.limitTotal}" required><br><br>
		<input type="submit" value="Reconfigure">
	</form>
	
	<form action="IniciateEditReceipts" method="get">
		<input type="submit" value="Edit receipt types" />
	</form>

	<form action="Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	</div>
</body>
</html>