<%@ page language="java" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Tour Information</h1>
	</div>
	
	<p>Name Tour: ${tour.nameTour}</p>
	<p>Description: ${tour.descriptionTour}</p>
	<p>Date: ${tour.dateTour}</p>
	<p>Price: ${tour.price}</p>
	<p>City Id: ${tour.city}</p>
	<p>Hotel Id: ${tour.hotel}</p>
	
	<form action="updatetour" method="GET">
		<input type="hidden" value="${tour.idTour}" name="tourId" /> <input
			type="submit" value="Update Tour" />
	</form>
	
		<div align="left" style="padding-top: 10px">
		<form action="deletetour" method="POST">
			<input type="hidden" value="${tour.idTour}" name="tourId" /> <input
				type="submit" value="Delete Tour" />
		</form>
	</div>
	
</body>
</html>