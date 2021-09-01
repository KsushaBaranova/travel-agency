<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Order</h1>
	</div>
<form action="updateorder" method="POST">

		<input type="hidden" value="${order.idOrder}" name="orderId" />

		<table>
			<tr>
				<td>Id User:</td>
				<td><input type="number" value="${order.idUser}" name="userId" /></td>
			</tr>

			<tr>
				<td>Id Tour:</td>
				<td><input type="number" value="${order.idTour}"   name="tourId"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Order" /></td>
			</tr>

		</table>
	</form>

</body>
</html>