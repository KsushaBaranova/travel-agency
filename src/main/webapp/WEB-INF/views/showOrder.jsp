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
		<h1>Order Information</h1>
	</div>
	
	<p>Id Order: ${order.idOrder}</p>
	<p>Id User: ${order.idUser}</p>
	<p>Id Tour: ${order.idTour}</p>


	
	<form action="updateorder" method="GET">
		<input type="hidden" value="${order.idOrder}" name="orderId" /> <input
			type="submit" value="Update Order" />
	</form>
	
		<div align="left" style="padding-top: 10px">
		<form action="deleteorder" method="POST">
			<input type="hidden" value="${order.idOrder}" name="orderId" /> <input
				type="submit" value="Delete Order" />
		</form>
	</div>

</body>
</html>