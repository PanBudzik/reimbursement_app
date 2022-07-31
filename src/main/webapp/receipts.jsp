<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		

		if(session.getAttribute("userId")==null) response.sendRedirect("index.jsp");
		%>
		<%= session.getAttribute("userId")%>
		
		
		<h2>Faza 3 - new document</h2>

                    <p>
                    
                
</body>
</html>