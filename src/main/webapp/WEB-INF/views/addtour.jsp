<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AddTour</title>
</head>
<body>
	<div align="center">
		<h1>Add Tour</h1>
	</div>


	<div align="left">
		<form action="createtour" method="post">
			<table>
				<tr>
					<td>Name Tour:</td>
					<td><input type="text" placeholder="Name tour" name="nameTour" /></td>
				</tr>

				<tr>
					<td>Description:</td>
					<td><input type="text" placeholder="Description"
						name="descriptionTour" /></td>
				</tr>

				<tr>
					<td>Date:</td>
					<td><input type="date" placeholder="Date Tour" name="dateTour" /></td>
				</tr>

				<tr>
					<td>Price:</td>
					<td><input type="number" placeholder="Price" name="price" /></td>
				</tr>

				<tr>
					<td>IdCity:</td>
					<td><input type="number" placeholder="Id City" name="idCity" /></td>
				</tr>

				<tr>
					<td>IdHotel:</td>
					<td><input type="number" placeholder="Id Hotel" name="idHotel" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Add Tour" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>