<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<body>
<jsp:include page="adminview.jsp"></jsp:include>
<br/>
<br/>
<br/><a href="addproduct">Addproduct</a>
<br/>
<br/>
<table id="customers">
	<tr>
		<th>ProductId </th>
		<th>ProductName</th>
		<th>Cost</th>
		<th>qty</th>
		<th>brand</th>
	</tr>
<c:forEach items="${listproduct}" var="p">
	<tr>
		<td>${p.pid}</td>
		<td>${p.pname}</td>
		<td>${p.pcost}</td>
		<td>${p.qty}</td>
		<td>${p.brand}</td>
		<td><a href='edit/${p.pid}'>Edit</a></td>
		<td><a href='delete/${p.pid}'>Delete</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>