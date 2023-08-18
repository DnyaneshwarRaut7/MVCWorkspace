<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="register">

id:<input type="text" name="id"><br><br>
name:<input type="text" name="name"><br><br>
address:<input type="text" name="address"><br><br>
mobileNo:<input type="text" name="mobileNo"><br><br>
mailId:<input type="text" name="mailId"><br><br>
gender:<input type="radio" name="gender" value="Male">Male
      :<input type="radio" name="gender" value="Female">Female<br><br>
      
CheckBox: <input type="checkbox" name="cource">Java 
        :  <input type="checkbox" name="cource">Python<br><br>
        
 Dropdown: <select>
 
 
     <option>Pune</option> 
     <option>Mumbai</option>
     <option>Nashik</option>
     <option>Nagpur</option> 
 </select>  <br><br>         
           

<input type="submit" value="login">

</form>
</body>
</html>