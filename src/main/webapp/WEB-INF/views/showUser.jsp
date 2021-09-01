<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Specific User Page</h1>
	</div>

	<p>Id: ${user.id}</p>
	<p>Name: ${user.name}</p>
	<p>LastName: ${user.lastName}</p>
	<p>Email: ${user.email}</p>
	<p>Birthday: ${user.dayOfBirthd}</p>
	<p>Role Id: ${user.idRole}</p>

	<form action="updateuser" method="GET">
		<input type="hidden" value="${user.id}" name="userId" /> 
		<input type="submit" value="Update" />
	</form>

	<div align="left" style="padding-top: 10px">
		<form action="deleteuser" method="POST">
			<input type="hidden" value="${user.id}" name="userId" /> 
			<input type="submit" value="Delete" />
		</form>
	</div>

</body>
</html>