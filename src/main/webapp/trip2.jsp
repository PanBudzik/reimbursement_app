<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action="SummarizeTrip" method="get">
		<hr>
		<h3>Allowance calculation</h3>
		<p>
			First day of trip <input type="date" name="startDate"><br> 
			Last day of trip <input type="date" name="endDate">
		</p>
		<hr>
		<h3>Personal car mileage</h3>
		<p>
			Mileage before trip <input type="number" name="startMilage" step="1" min="0"><br> 
			Mileage after trip <input type="number" name="endMilage" step="1" min="0"><br> 
			License plate <input type="text" name="plate">
		</p>
		<hr>
		<input type="submit" value="Save">
	</form>
	<a href="trip.jsp"><button>Back</button></a>
	</div>

</body>
</html>