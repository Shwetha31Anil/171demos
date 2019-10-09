<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
<title>Customer</title>
</head>
<body>

<ul>
  <li><a href="aproducts">Products</a></li>
  <li><a href="#">Add admin</a></li>
  <li><a href="logout">Logout</a></li>
  <li style="float:right"><a>Logged in as ${sessionScope.sname}</a></li>
</ul>
</body>
</html>