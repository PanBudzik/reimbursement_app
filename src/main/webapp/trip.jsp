<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Adding claim - Stage 1</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("userId") == null)
		response.sendRedirect("index.jsp");
	%>
	<div>
	<h2>Stage 1</h2>
	<hr>
	<h3>Add receipts:</h3>
	<form action="addReceipt" method="post">
	
		
		Type: <select name="receiptChosen">
			<c:forEach items="${sessionScope.receiptTypes}" var="s">
				<option value="${s}">${s}</option>
			</c:forEach>

		</select> 
		<br>
		
		Amount spend: <input type="number" name="receiptAmount" step="0.01" min="0">
		
		<br>
		<!--  Document: <input type="file" name="receipt">-->
		<input type="submit" value="Add receipt">
	</form>
	<hr>
	<table>
		<tr>
			<th>Number</th>
			<th>Type</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${sessionScope.allReceipts}" var="s">
			<tr>
				<td>${s.receiptId}</td>
				<td>${s.receiptChosen}</td>
				<td>${s.receiptAmount}</td>
			</tr>
		</c:forEach>

	</table>
	<hr>
	<a href="trip2.jsp"><button>Stage 2</button></a>
	<a href="home.jsp"><button>Back</button></a>
	</div>
</body>
</html>