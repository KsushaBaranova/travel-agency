<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>
</head>
<body>
<table border=1 align="center">
		<tr>
			<td>ID User</td>
			<td>ID Tour</td>
			<td>DO</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.idUser}</td>
				<td>${order.idTour}</td>

				<td>
					<form action="updateorder" method="GET">
						<input type="hidden" name="orderId" value="${order.idOrder}"> 
						<input type="submit" value="Update" style="float: left">
					</form>
					<form action="deleteorder" method="POST">
						<input type="hidden" name="orderId" value="${order.idOrder}"> 
						<input type="submit" value="Delete" style="float: left">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action = "createorder" method="GET">
    <input type="submit" value="Add new order">
</form>
</body>
</html>