<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateuser" method="POST">

		<input type="hidden" value="${user.id}" name="userId" />

		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${user.name}" name="name" /></td>
			</tr>

			<tr>
				<td>LastName:</td>
				<td><input type="text" value="${user.lastName}"  name="lastname"/></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" value="${user.email}" name="email" /></td>
			</tr>

			<tr>
				<td>Birthday:</td>
				<td><input type="date" value="${user.dayOfBirthd}" name="birthday"/></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" value="${user.password}" name="password"/></td>
			</tr>
			
			<tr>
				<td>Confirm password:</td>
				<td><input type="password" value="${user.password}" name="passwordCheck"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>

		</table>
	</form>
</body>
</html>