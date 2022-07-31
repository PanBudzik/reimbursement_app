<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Summary</title>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("userId") == null)
		response.sendRedirect("index.jsp");
	%>
<div>
<h2>Summary</h2>
<p>
Licence plate of personal vehicle: ${sessionScope.plate}<br/> <br/> 
Distance drivern with personal vehicle: ${sessionScope.distanceDriven}<br/><br/> 
Return (${sessionScope.rateMilage}$/km): ${sessionScope.amountMilage}$<br/><br/> 
</p>
<p>
Duration of trip: ${sessionScope.daysOfAllowance}<br/><br/> 
Allowance (${sessionScope.rateAllowance}$/day): ${sessionScope.amountAllowance}$<br/><br/> 
</p>
	Receipts:
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
				<td>${s.receiptAmount}$</td>
			</tr>
		</c:forEach>

	</table>
</div>
<div>
<h2>Total without limit: ${sessionScope.total}$</h2>
<h3>limit: ${sessionScope.limitTotal}$</h3>
<h1>Final total: ${sessionScope.totalWithLimit}$</h1>
<a href="home.jsp"><button>Back</button></a>
</div>


</body>
</html>