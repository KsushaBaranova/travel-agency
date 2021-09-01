<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AdminPage</title>
</head>
<body>
	<div align="center">
		<h1>This is AdminPage!</h1>
	</div>

	<table>
		<tr>
			<td><form action="alltours" method="GET">
					<input type="submit" value="All Tours" />
				</form></td>
			<td>
				<form action="allorders" method="GET">
					<input type="submit" value="All Orders" />
				</form>
			</td>
		</tr>
	</table>

</body>
</html>