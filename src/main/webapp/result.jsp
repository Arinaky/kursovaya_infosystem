<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Авторизация</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
        <p>Спасибо за обращение!</p>
        <p>Номер вашего заказа: *тут должен быть номер*</p>
        <p>
            Данные о вашем заказе: <br>
            Фамилия: ${surname} <br>
            Имя: ${name} <br>
            Отчество: ${patronymic} <br>
            Адрес: ${address} <br>
            Дата и время: ${date_time} <br>
            Площадь помещения: ${clean_area} <br>
            Вид уборки: ${clean_type} <br>
            Дополнительные услуги: ${clean_services} <br>
        </p>
        <br>
        <p>
            Стоимость: ${price}
        </p>
        <br>
        <p>
            ${result}
        </p>
	</body>
	</html>