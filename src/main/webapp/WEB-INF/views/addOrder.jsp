<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<div align="center">
		<h1>Add Order</h1>
	</div>


	<div align="left">
		<form action="createorder" method="post">
			<table>
				<tr>
					<td>Id User:</td>
					<td><input type="number" placeholder="ID User" name="userId" /></td>
				</tr>

				<tr>
					<td>Id Tour:</td>
					<td><input type="number" placeholder="ID Tour"
						name="tourId" /></td>
				</tr>

				<tr>
					<td>Is Paid:</td>
					<td><input type="checkbox" name="isPaid" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Add Order" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>