<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>Product</title>
</head>
<body>
<h3>Product</h3>


<script type="text/javascript">
$(document).ready(function(e){
	console.log('jQuery running..');
	var productStr = JSON.stringify({"id":1,"name":"Samsung S2","productType":"Mobile","price":23000.00,"quantity":15});
	$.ajax({
		url:'<c:url value="/product/insert" />',
		type:"post",
		dataType:"json",
		data:productStr,
		processData:false,
		beforeSend:function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");			
		},
		success:function(responseJson){
			console.log('output: '+JSON.stringify(responseJson));			
		},
		error:function(err){
			console.log('error:'+err);
		}
	});
});
</script>
</body>
</html>