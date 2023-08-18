<%@page import="com.example.model.Employee"%>
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

<%List<Employee> list =(List) request.getAttribute("l"); %>
<body bgcolor= cyan>
<style>
h1{text-align: center;}
</style> 
<h1>Show Register Information </h1>
<hr>
<h1>Welcome Employee Profile...!</h1>
<%-- ${l} --%>
<h1 style="color:red;"></h1>
<form name="mypage">
<table border ="4" bgcolor="yellow">
<thead>
<tr>

<th>SELECT</th>
<th>EId</th>
<th>ENAME</th>
<th>ADDRESS</th>
<th>COMPANEYNAME</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>UPDATE</th>
<th>DELETE</th>
 </tr>
</thead>
<tbody>
<tr>
<%for(Employee e :list) {%>

<td> <input type="radio" name="eid" value="<%=e.getEid() %>"></td>
<td><%=e.getEid() %></td>
<td><%=e.getEname() %></td>
<td><%=e.getAddress() %></td>
<td><%=e.getCompaneyName() %></td>
<td><%=e.getUname() %></td>
<td><%=e.getPass() %></td>
<td> <input type="submit" onclick="updateData()" value="Update"></td>
<td> <input type="submit" onclick="deleteData()" value="Delete"></td>
</tr>
<%} %>
</tbody>
</table>
</form>
</body>
</html>