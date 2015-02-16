<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Paste</h1>
<h2>Paste your shit here.</h2>
<form action="../Paste" method="POST">
	Title:
	<input type="text" name="title">
		<br>
	<textarea name="paste" style="width:640px; height:480px;">
		
	</textarea><br>
	Password: 
	<input type="text" name="password">
		<br>
	<input type="submit" name="submit">
</form>
</body>
</html>