<%@page import="com.example.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%Employee  e = (Employee) request.getAttribute("e");  %>
<body bgcolor= pink>
<h1>Update Page...!</h1>
<%-- ${e} --%> 
<form action="up">

 <input type ="hidden" name="eid" value="<%= e.getEid()%>"><br><br>
Name :<input type ="text" name="ename" value="<%= e.getEname()%>"><br><br>
Address :<input type ="text" name="address" value="<%= e.getAddress()%>"><br><br>
Company :<input type ="text" name="companeyName" value="<%= e.getCompaneyName()%>"><br><br>
UserName :<input type ="text" name="uname" value="<%= e.getUname()%>"><br><br>
Password :<input type ="text" name="pass" value="<%= e.getPass()%>"><br><br>
<input type="submit" value="Update">
</form>
</body>
</html>