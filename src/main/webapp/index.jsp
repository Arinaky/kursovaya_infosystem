<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Калькулятор</title>
		<link rel="stylesheet" type="text/css" href="style1.css">
	</head>
	<body>
		<div class="container">
		<div class="title">Калькулятор клининговых услуг</div>
		<form action="${pageContext.request.contextPath}/Calc">
			<div class="user-details">
                <p>Проверка: ${1+2}</p>
				<div class="input-box">
					<span class="details">Фамилия</span>
					<input type="text" placeholder="Ваша фамилия" required id="surname" value="surname">
				</div>

				<div class="input-box">
					<span class="details">Имя</span>
					<input type="text" placeholder="Ваше имя" required id="name" value="name">
				</div>

				<div class="input-box">
					<span class="details">Отчество</span>
					<input type="text" placeholder="Отчество" required id="patronymic" value="patronymic">
				</div>

				<div class="input-box">
					<span class="details">Адрес</span>
					<input type="text" placeholder="Адрес" required id="address" value="address">
				</div>

				<div class="input-box">
					<span class="details">Промокод</span>
					<input type="text" placeholder="Промокод" required>
				</div>

				<div class="input-box">
					<span class="details">Дата и время</span>
					<input type="datetime-local"  id="data_time" value="data_time">
				</div>

				<div class="input-box">
				<button class="but-det">Ввести промокод</button>
			</div>

			</div>

			<div class="clean-details">
				<input type="radio" name="clean" id="dot-1">
				<input type="radio" name="clean" id="dot-2">
				<input type="radio" name="clean" id="dot-3">
				<input type="radio" name="clean" id="dot-4">
				<input type="radio" name="clean2" id="m-1">
				<input type="radio" name="clean2" id="m-2">
				<input type="radio" name="clean2" id="m-3">
				<input type="radio" name="clean2" id="m-4">
				<input type="radio" name="clean3" id="dop-3">
				<input type="radio" name="clean4" id="dop-4">
				<input type="radio" name="clean5" id="dop-5">
				<input type="radio" name="clean6" id="dop-6">
				<input type="radio" name="clean7" id="dop-7">
				<input type="radio" name="clean8" id="dop-8">
				<input type="radio" name="clean9" id="dop-9">
				<input type="radio" name="clean10" id="dop-10">
				<span class="clean-title">Вид уборки</span>
				<div class="category">
					<label for="dot-1">
						<span class="dot one"></span>
						<span class="clean">Генеральная</span>
					</label>
					<label for="dot-2">
						<span class="dot two"></span>
						<span class="clean">Облегченная</span>
					</label>
					<label for="dot-3">
						<span class="dot three"></span>
						<span class="clean">После ремонта</span>
					</label>
					<label for="dot-4">
						<span class="dot four"></span>
						<span class="clean">Послестроительная</span>
					</label>

				</div>
				<span class="clean-title">Квадратура</span>
				<div class="category">
					<label for="m-1">
						<span class="m a"></span>
						<span class="clean2">0 - 100</span>
					</label>
					<label for="m-2">
						<span class="m b"></span>
						<span class="clean2">100-400</span>
					</label>
					<label for="m-3">
						<span class="m c"></span>
						<span class="clean2">400-700</span>
					</label>
					<label for="m-4">
						<span class="m d"></span>
						<span class="clean2">700-1000</span>
					</label>

				</div>
				<span class="clean-title">Дополнительные услуги</span>
				<div class="category">
					<label for="dop-3">
						<span class="dop q"></span>
						<span class="clean3">Полировка полов</span>
					</label>
					<label for="dop-4">
						<span class="dop w"></span>
						<span class="clean4">Мытье посуды</span>
					</label>
					<label for="dop-5">
						<span class="dop r"></span>
						<span class="clean5">Стирка+глажка</span>
					</label>
					<label for="dop-6">
						<span class="dop t"></span>
						<span class="clean6">Мытье окон</span>
					</label>

				</div>

				<div class="category">
					<label for="dop-7">
						<span class="dop y"></span>
						<span class="clean7">Уборка стен</span>
					</label>
					<label for="dop-8">
						<span class="dop u"></span>
						<span class="clean8">Чистка унитаза</span>
					</label>
					<label for="dop-9">
						<span class="dop i"></span>
						<span class="clean9">Чистка раковин</span>
					</label>
					<label for="dop-10">
						<span class="dop o"></span>
						<span class="clean10">Уборка балкона</span>
					</label>

				</div>

			</div>



			<div class="price">
				<div class="output-box">
					<span class="price-details">Стоимость</span>
				</div>
				<label for="">
						<span class="price-details2">Здесь будет сумма</span>
					</label>
			</div>

			<div class="button">
				<input type="submit" value="Заказать">
			</div>

		</form>
	</div>

	</body>
	</html>