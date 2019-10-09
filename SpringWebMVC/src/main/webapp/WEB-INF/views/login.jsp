<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<body>
<h2>Login</h2>
${error}
<form action="login" method="post">
	UserName: <input type="text" name="lname"/>
	<br/><br/><br/><br/>
	Password: <input type="password" name="pass"/>
<br/><br/><br/><br/>
<input type="submit" value="Login">
</form>
</body>
</html>
