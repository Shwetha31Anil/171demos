<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
${message}
<table>
	<tr>
		<th>Product Id</th>
		<th>ProdcutName</th>
		<th>Cost</th>
		<th>Quantity</th>
		<th>Brand</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${applicationScope.listProduct}" var="p">
	<tr>
	<td>${p.pid}</td>
	<td>${p.pname}</td>
	<td>${p.cost}</td>
	<td>${p.qty}</td>
	<td>${p.brand}</td>
	<td><a href="#">Edit</a></td>
	<td><a href="delete?id=<c:out value='${p.pid}'/>">Delete</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>