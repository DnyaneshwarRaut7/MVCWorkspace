<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>

<form action="regis" method="post">

   ID : <input type="text" name="eid"><br><br>
   Name : <input type="text" name="ename"><br><br>
   Address : <input type="text" name="address"><br><br>
   Company : <input type="text" name="companyName"><br><br>
   Username : <input type="text" name="uname"><br><br>
   Password : <input type="text" name="pass"><br><br>
   
   <input type="submit" value="Register">&nbsp;&nbsp;
   <a href="login.jsp">Login Here</a>
   
   <a href="filePage.jsp">File Upload</a>

</form>
</body>
</html>