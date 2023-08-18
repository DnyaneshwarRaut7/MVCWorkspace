<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=pink>
<h1>Index Page</h1>

<form action="register" method="post">

<!-- ID :<input type ="hidden" name="eid" value="0"><br><br> -->
Name :<input type ="text" name="ename"><br><br>
Address :<input type ="text" name="address"><br><br>
Company :<input type ="text" name="companeyName"><br><br>
UserName :<input type ="text" name="uname"><br><br>
Password :<input type ="password" name="pass"><br><br>
<input type="submit" value="Register">&nbsp;&nbsp;
<a href ="login.jsp">login Here</a>&nbsp;&nbsp;
<a href ="filepage.jsp">File Upload Here</a>
</form>
</body>
</html>