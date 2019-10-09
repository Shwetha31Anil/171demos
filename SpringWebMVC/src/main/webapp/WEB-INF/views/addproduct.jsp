<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<h3>Add Product</h3>
${error}
<div>
<c:url var="addAction" value="/add/Product"></c:url>
  <form:form action="${addAction}" method="post" commandName="product">
    <label for="productId">Product Id</label>
    <form:input path="pid" readonly="true" size="8" 
			disabled="true" />
			<form:hidden path="pid" />
    <label for="pname">Product Name</label>
    <form:input type="text" path="pname" id="pname" name="pname" placeholder="Your product name.."/>

   
   <label for="pcost">Product cost</label>
    <form:input type="text" path="pcost" id="pcost" name="pcost" placeholder="cost"/>
    

   
   <label for="qty">Quantity</label>
    <form:input type="text" path="qty" id="qty" name="qty" placeholder="quantity"/>
    
     <label for="brand">Brand</label>
    <input type="text" id="brand" name="brand" placeholder="enter brand">

   
  
    <input type="submit" value="Addproduct">
  </form:form>
</div>

</body>
</html>
