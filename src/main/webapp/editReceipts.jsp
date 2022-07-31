<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Receipts</title>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("adminMode") == null)
		response.sendRedirect("index.jsp");
	%>
<div>
<h2>Edit Receipts</h2>
	<table>
		<tr>
			<th>Type</th>
			<th>Action</th>
		</tr>

		
		<c:forEach items="${sessionScope.receiptTypes}" var="s">
			<tr>
				<td>${s}</td>
				<td>
				<form action="DeleteType" method="post">
					<input type="hidden" value="${s}" name="type"/> 
					<input type="submit" value="Delete" />
				</form>
			</td>
			</tr>
		</c:forEach>
	</table><br>
	<form action="AddType" method="post">
		<input type="text" name ="type"/> 
		<input type="submit" value="Add new type" />
	</form><br>
	<a href="config.jsp"><button>Back</button></a>
	<form action="Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	</div>
</body>
</html>