<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sign up / Login Form</title>
<link rel="stylesheet" href="css/inscription.css">

</head>

<body>
	<div class="main">
		<input type="checkbox" id="chk" aria-hidden="true">

		<div class="signup">
			<form action="InscriptionController" method="post">
				<label for="chk" aria-hidden="true">Sign up</label> <input
					type="text" name="nom" placeholder="User name"> <input
					type="email" name="email" placeholder="Email"> <input
					type="password" name="pwd" placeholder="Password">
				<button type="submit" value="Inscription">Sign up</button>
			</form>
		</div>

		<div class="login">
			<form method="post" action="LoginController">
				<label for="chk" aria-hidden="true">Login</label> <input
					type="email" name="email" placeholder="Email" required>
				<input type="password" name="pwd" placeholder="Password"
					required="">
				<button>Login</button>
			</form>
		</div>
	</div>
</body>
</html>

