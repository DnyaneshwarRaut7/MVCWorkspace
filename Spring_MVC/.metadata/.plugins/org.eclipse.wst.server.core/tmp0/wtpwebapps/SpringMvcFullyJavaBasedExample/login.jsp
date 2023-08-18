<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login here</h1>

<%String s = (String) request.getAttribute("str"); %>
<% if(s != null){ %>
 <h5 style="color:red;"><%out.print(s);%></h5>
<%} %>

<form action="log">
   Username : <input type="text" name="uname"><br><br>
   Password : <input type="text" name="pass"><br><br>
   
   <input type="submit" value="Login">

</form>
</body>
</html>