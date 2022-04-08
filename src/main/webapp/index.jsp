<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Курсовая</title>
</head>
<body>
	<h1>Курсовая</h1>
	<h2><em>Разработано DreamTeam</em></h2>
	<form action="${pageContext.request.contextPath}/Calc" method="post">
		<label for="radius">Радиус: </label>
		<br>
		<input type="text" name="radius" id="radius" value="${radius}">
		<br>
		<label for="height">Высота: </label>
		<br>
		<input type="text" name="height" id="height" value="${height}">
		<br>
		<input type="submit" name="sign" value="Calculate">
	</form>
</body>
</html>
