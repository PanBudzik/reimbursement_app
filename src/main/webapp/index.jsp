<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Login</title>
</head>
<body>

	<div>
	<h2>Sign in!</h2>
	<form action="Login" method="post">
		Username: <input type="text" name="userId" required><br>
		Password: <input type="password" name="pass" required><br> 
		<input type="submit" value="Login"/>
	</form>
	</div>
</body>
</html>