<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello World!
<c:url value="/user/register" var="registerUrl"/>
<c:url value="/user/login" var="loginUrl"/>
<c:url value="/product/productHome" var="productUrl"/>
<c:url value="/static/product.html" var="productHtmlUrl"/>
<a href="${registerUrl}">User Register</a><br/>
<a href="${loginUrl}">User Login</a><br/>
<a href="${productUrl}">Product Page</a><br/>
<a href="${productHtmlUrl}">Product html Page</a><br/>

<c:choose>
	<c:when test="${not empty currentUser}">
		Welcome, ${currentUser.username}
		<c:url value="/user/logout" var="logoutUrl"/>
		<a href="${logoutUrl}">Logout</a>
	</c:when>
	<c:otherwise>
		Not logged in
	</c:otherwise>
</c:choose>	
</body>
</html>