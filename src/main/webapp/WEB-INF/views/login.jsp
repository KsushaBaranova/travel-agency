<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login Page</title>
</head>
<body>

	<div align="center">
		<h1>Login</h1>
	</div>

	<div align="center" style="padding-top: 20px">
		<form action="login" method="post">
			<p>
				<input type="text" placeholder="Your login" name="login" />
			</p>
			<p>
				<input type="password" placeholder="Your password" name="password" />
			</p>
			<p>
				<input type="submit" value="Log in" />
			</p>
		</form>

		<form action="createuser" method="GET">
			<input type="submit" value="Sign up" />
		</form>
	</div>
</body>
</html>