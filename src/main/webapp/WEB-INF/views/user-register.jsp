<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<h3>User Details:</h3>
	<form:form modelAttribute="userDTO" method="post">
		<form:label path="username"/>Username:
		<form:input path="username"/><br/>
		
		<form:label path="password"/>Password:
		<form:input path="password"/><br/>
		
		<input type="submit" value="register"/>	
	</form:form>
</body>
</html>