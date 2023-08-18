<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=orange>
<h1>Welcome</h1>
<hr>
<h1>Login Page Start</h1>
<%String s= (String) request.getAttribute("str");%>
<% if (s!=null){ %>
<h3 style="color:blue;"><%out.print(s);%></h3>
<%}%>
<form action="login">

UserName : <input type ="text" name="uname"><br><br>
Password : <input type ="password" name="pass"><br><br>

<input type="submit" value="Login">

</form>
</body>
</html>