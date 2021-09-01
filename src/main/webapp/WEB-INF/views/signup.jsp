<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SignUp User</title>
</head>
<body>


	<div align="center">
		<h1>SignUp</h1>
	</div>


	<div align="left">
		<form action="createuser" method="post">
			<p>
				<input type="text" placeholder="Your name" name="name" />
			</p>
			<p>
				<input type="text" placeholder="Your lastname" name="lastname" />
			</p>
			<p>
				<input type="date" placeholder="Your birthday" name="birthday" />
			</p>
			<p>
				<input type="email" placeholder="Your email" name="email" />
			</p>
			<p>
				<input type="password" placeholder="Your password" name="password" />
			</p>
			<p>
				<input type="password" placeholder="Your password" name="passwordCheck" />
			</p>
			<p>
				<input type="number" placeholder="Your role" name="role" />
			</p>
			<p>
				<input type="submit" value="SignUp"/>
			</p>
		</form>

	</div>

</body>
</html>