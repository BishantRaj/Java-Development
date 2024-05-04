<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addMetal">
	<input type="text" name="id"><br><br>
	<input type="text" name="name"><br><br>
	<input type="text" name="prop"><br><br>
	<input type="submit"><br><br>
	</form>
	
<form action="getMetal">
	<input type="text" name="id"><br><br>
	<input type="submit"><br><br>
	</form>
	
<form action="delMetal">
	<input type="text" name="id"><br><br>
	<input type="submit" value="Delete"><br><br>
	</form>
<form action="getallMetal">
	<input type="text" name="name"><br><br>
	<input type="submit" value="get"><br><br>
	</form>
</body>
</html>