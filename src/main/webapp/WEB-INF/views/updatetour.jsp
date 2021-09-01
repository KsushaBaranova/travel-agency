<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Tour</title>
</head>
<body>
	<div align="center">
		<h1>Edit Tour</h1>
	</div>
<form action="updatetour" method="POST">

		<input type="hidden" value="${tour.idTour}" name="tourId" />

		<table>
			<tr>
				<td>Name Tour:</td>
				<td><input type="text" value="${tour.nameTour}" name="nameTour" /></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><input type="text" value="${tour.descriptionTour}"   name="descriptionTour"/></td>
			</tr>

			<tr>
				<td>Date:</td>
				<td><input type="date" value="${tour.dateTour}"  name="dateTour" /></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><input type="number" value="${tour.price}"  name="price"/></td>
			</tr>
			
			<tr>
				<td>IdCity:</td>
				<td><input type="number" value="${tour.city}"  name="idCity"/></td>
			</tr>
			
			<tr>
				<td>IdHotel:</td>
				<td><input type="number" value="${tour.hotel}"  name="idHotel"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>

		</table>
	</form>
</body>
</html>