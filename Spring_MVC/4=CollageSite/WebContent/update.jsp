<%@page import="com.example.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%Student s=(Student) request.getAttribute("s"); %>
<body bgcolor= pink>
<h1>UPDATE PAGE</h1>
<%--  ${s}--%>
<form action="up">

     : <input type="hidden" name="Id" value=<%=s.getId() %>><br><br>
Name    : <input type="text" name="name" value=<%=s.getName() %>><br><br>
Address :<input type="text" name="address" value=<%=s.getAddress() %>><br><br>
Uname   :<input type="text" name="uname" value=<%=s.getUname() %>><br><br>
Password:<input type="password" name="pass" value=<%=s.getPass() %>><br><br>
E-mailId:<input type="email" name="mail" value=<%=s.getMail() %>><br><br> 

<input type="submit" value="update">
</form>


</body>
</html>