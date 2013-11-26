<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="./Design/stylesheet.css"
      type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Members Login Page</title>
</head>
<body>
	<center>
		<h1>Social Alarm Clock</h1>
		<h2><font color="red">Login failed, please try again</h2></font>
	</center>
	<form action="Login">
		Email: <input type="text" name="Email" /><br>
		Password: <input type="password" name="PassW" /> 
			<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<br> Not a member? Please <a href="GetUserDetails.jsp">click the following to register</a>
</body>
</html>