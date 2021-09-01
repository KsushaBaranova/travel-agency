<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>All Tours</title>
</head>
<body>
	<table border=1 align="center">
		<tr>
			<td>Name Tour</td>
			<td>Description</td>
			<td>Date Tour</td>
			<td>Price</td>
			<td>City</td>
			<td>Hotel</td>
			<c:if test="${loggedInUser.idRole == 1}">
			<td>DO</td>
			</c:if>
		</tr>
		<c:forEach items="${tours}" var="tour">
			<tr>
				<td>${tour.nameTour}</td>
				<td>${tour.descriptionTour}</td>
				<td>${tour.dateTour}</td>
				<td>${tour.price}</td>
				<td>${tour.city}</td>
				<td>${tour.hotel}</td>
				<td><c:if test="${loggedInUser.idRole == 1}">
						<form action="updatetour" method="GET">
							<input type="hidden" name="tourId" value="${tour.idTour}">
							<input type="submit" value="Update" style="float: left">
						</form>
						<form action="deletetour" method="POST">
							<input type="hidden" name="tourId" value="${tour.idTour}">
							<input type="submit" value="Delete" style="float: left">
						</form>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

<c:if test="${loggedInUser.idRole == 1}">
	<form action="createtour" method="GET">
		<input type="submit" value="Add new tour">
	</form>
</c:if>
</body>
</html>