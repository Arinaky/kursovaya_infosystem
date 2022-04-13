<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Авторизация</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<form class="form" action="${pageContext.request.contextPath}/Auth" method="post">
			<h1 class="form_title">Авторизация</h1>
			<div class="form_group">
				<input class="form_input" placeholder="" name="username" value="${username}">
				<label class="form_label">Прекрасное имя</label>
			</div>

			<div class="form_group">
				<input class="form_input"  placeholder="" name="password" value="${password}">
				<label class="form_label">Надежный пароль</label>
			</div>

			<div class="form_b">
				<button class="form_button">Войти</button>
			</div>
		</form>

	</body>
	</html>