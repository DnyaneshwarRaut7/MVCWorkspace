<%@page import="com.example.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script >
function updateData(){
	
	alert("UpdateData Function Called.....");
	document.mypage.action="update";
	document.mypage.submit(); 
}
function deleteData(){
	
	alert("DeleteData Function Called.....");
	document.mypage.action="remove";
	document.mypage.submit();
}

</script>
<%List<Student> list =(List) request.getAttribute("l"); %>
<body bgcolor="pink">
<style>
h1{text-align: center;}

</style> 
<h1>Jamkhed Mahavidyalya Jamkhed</h1>
<h1>Welcome </h1>
<h1>BCA Department</h1>
<%--  ${l} --%>
<form name="mypage">

<table border ="4" bgcolor="yellow">
<thead>
<tr>
<th>SELECT</th>
<th>Id</th>
<th>NAME</th>
<th>ADDRESS</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>MAILID</th>
<th>UPDATE</th>
<th>DELETE</th>
</tr>
</thead>
<tbody>
<tr>
<%for(Student s :list) {%>
<td> <input type="radio" name="id" value="<%=s.getId() %>"></td>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getAddress() %></td>
<td><%=s.getUname() %></td>
<td><%=s.getPass() %></td>
<td><%=s.getMail() %></td>
<td> <input type="submit" onclick="updateData()" value="Update"></td>
<td> <input type="submit" onclick="deleteData()" value="Delete"></td>
</tr>
<%} %>
</tbody>
</table>
</form>

</body>
</html>