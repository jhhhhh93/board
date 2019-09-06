<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>로그인</title>

<link href="${cp}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${cp}/css/signin.css" rel="stylesheet">

<script src="${cp}/js/jquery-3.4.1.min.js"></script>

<script>
	$(document).ready(function() {
		$("#signinBtn").on("click", function() {
			//로그인 요청
			$("#frm").submit();
		});
	});
</script>

</head>

<body>
	<div class="container">

		<form class="form-signin"
			action="${cp }/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="userId" class="sr-only">userId</label>
			<input value="sally" name="userId" type="text" id="userId" class="form-control" placeholder="userId" required autofocus> 
			<label for="pass"class="sr-only">Password</label> 
			<input value="sally1234" name="pass" type="password" id="pass" class="form-control" placeholder="Password" required>

			<button id="signinBtn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>

	</div>
	<!-- /container -->
	
	

</body>
</html>
