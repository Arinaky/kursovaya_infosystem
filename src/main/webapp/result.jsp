<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Заказ</title>
		<link rel="stylesheet" type="text/css" href="css/style2.css">
	</head>
	<body>
        <div class="container">
        		<div class="title">Благодарим за обращение!</div>
        		<form action="#">
        			<div class="order-numb">
                <h1>№${number}</h1>
                <p>Данные о вашем заказе: </p>
                </div>
                <div class="user-details">
                <p>

                    Фамилия: ${surname} <br>
                    Имя: ${name} <br>
                    Отчество: ${patronymic} <br>
                    Адрес: ${address} <br>
                    Дата и время: ${date_time} <br>
                    Площадь помещения: ${clean_area} <br>
                    Вид уборки: ${clean_type} <br>
                    Дополнительные услуги:
                    <br>
                    ${clean_services}
                </p>

        			</div>

        			<div class="result">
        				 <p>
                    К оплате: ${price} руб.
                		</p>
          			</div>

        			<div class="button">
                    <a href="index.jsp" class="header_link">Вернуться назад</a>
                    </div>

        		</form>
        	</div>

	</body>
	</html>

