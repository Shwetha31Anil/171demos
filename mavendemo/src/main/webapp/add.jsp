<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
${message}
<form action="addProduct" method="post">
ProductId: <input type="text" name="pid" required="required" /><br/>
<br/>
ProductName: <input type="text" name="pname" required="required"/><br/>
<br/>
<br/>
Cost: <input type="text" name="cost" required="required"/><br/>
<br/>
Quantity: <input type="text" name="qty" required="required"/><br/>
<br/>
<br/>
Brand: <input type="text" name="brand" required="required"><br/><br/>
<input type="submit" value="AddProduct">
</form>
</body>
</html>