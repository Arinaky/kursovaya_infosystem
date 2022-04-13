<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Калькулятор</title>
		<link rel="stylesheet" type="text/css" href="css/style1.css">
</head>
<body>
		<div class="container">
			<header class="header">
				<div class="contain">
					<div class="header_body">
						<a href="#" class="header_logo">
							<img src="img/logof.png" alt="">
						</a>
						<div class="header_burger">
							<span></span>
						</div>
						<nav class="header-menu">
							<ul class="header-list">
								<li><a href="" class="header_link">Панель админа</a></li>
								<li><a href="" class="header_link">О нас</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>

		    <div class="title">Калькулятор</div>

		    <form action="${pageContext.request.contextPath}/Calc" method="post">
			    <div class="user-details">
				    <div class="input-box">
					    <span class="details">Фамилия</span>
					    <input type="text" placeholder="Ваша фамилия" required name="surname" id="surname" value="${surname}">
				    </div>
				    <div class="input-box">
					    <span class="details">Имя</span>
					    <input type="text" placeholder="Ваше имя" required name="name" id="name" value="${name}">
				    </div>
				    <div class="input-box">
					    <span class="details">Отчество</span>
					    <input type="text" placeholder="Отчество" required name="patronymic" id="patronymic" value="${patronymic}">
				    </div>
				    <div class="input-box">
					    <span class="details">Адрес</span>
					    <input type="text" placeholder="Адрес" required name="address" id="address" value="${address}">
				    </div>
				    <div class="input-box">
					    <span class="details">Дата и время</span>
					    <input type="datetime-local" name="date_time" id="date_time" value="${date_time}">
				    </div>
				    <div class="input-box">
                        <span class="details">Площадь помещения</span>
                    	<input type="text" name="clean_area" id="clean_area" value="${clean_area}">
                    </div>
			    </div>

			    <div class="clean-details">
				    <input type="radio" name="clean_type" id="dot-1" value="Генеральная">
				    <input type="radio" name="clean_type" id="dot-2" value="Облегченная">
		    		<input type="radio" name="clean_type" id="dot-3" value="После ремонта">
		    		<input type="radio" name="clean_type" id="dot-4" value="Послестроительная">
			    	<input type="radio" name="clean2" id="m-1">
				    <input type="radio" name="clean2" id="m-2">
    				<input type="radio" name="clean2" id="m-3">
	    			<input type="radio" name="clean2" id="m-4">
		    		<input type="checkbox" name="clean_service_1" id="dop-3" value="Полировка полов">
			    	<input type="checkbox" name="clean_service_2" id="dop-4" value="Мытье посуды">
				    <input type="checkbox" name="clean_service_3" id="dop-5" value="Стирка+глажка">
    				<input type="checkbox" name="clean_service_4" id="dop-6" value="Мытье окон">
	    			<input type="checkbox" name="clean_service_5" id="dop-7" value="Уборка стен">
		    		<input type="checkbox" name="clean_service_6" id="dop-8" value="Чистка унитаза">
			    	<input type="checkbox" name="clean_service_7" id="dop-9" value="Чистка раковин">
				    <input type="checkbox" name="clean_service_8" id="dop-10" value="Уборка балкона">

				    <span class="clean-title">Вид уборки</span>
				    <div class="category">
					    <label for="dot-1">
						    <span class="dot one"></span>
						    <span class="clean_type">Генеральная</span>
					    </label>
					    <label for="dot-2">
						    <span class="dot two"></span>
						    <span class="clean_type">Облегченная</span>
					    </label>
					    <label for="dot-3">
						    <span class="dot three"></span>
    						<span class="clean_type">После ремонта</span>
	    				</label>
		    			<label for="dot-4">
			    			<span class="dot four"></span>
				    		<span class="clean_type">Послестроительная</span>
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
			    			<span class="clean_service_1">Полировка полов</span>
				    	</label>
					    <label for="dop-4">
    						<span class="dop w"></span>
	    					<span class="clean_service_2">Мытье посуды</span>
		    			</label>
			    		<label for="dop-5">
				    		<span class="dop r"></span>
					    	<span class="clean_service_3">Стирка+глажка</span>
					    </label>
    					<label for="dop-6">
	    					<span class="dop t"></span>
		    				<span class="clean_service_4">Мытье окон</span>
			    		</label>
				    </div>

    				<div class="category">
	    				<label for="dop-7">
		    				<span class="dop y"></span>
			    			<span class="clean_service_5">Уборка стен</span>
				    	</label>
					    <label for="dop-8">
    						<span class="dop u"></span>
	    					<span class="clean_service_6">Чистка унитаза</span>
		    			</label>
			    		<label for="dop-9">
				    		<span class="dop i"></span>
					    	<span class="clean_service_7">Чистка раковин</span>
    					</label>
	    				<label for="dop-10">
		    				<span class="dop o"></span>
			    			<span class="clean_service_8">Уборка балкона</span>
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
        			<div class="button">
		    		    <input type="submit" value="Заказать">
			        </div>
		    </form>

		    <form action="promo">
			    <div class="output-box">
					<span class="price-details">У вас есть промокод? </span>
				</div>
			    </div>
			    <div class="promo-d">
		            <div class="input-box">
					    <input type="text" placeholder="Промокод" required>
				    </div>
	            </div>
	            <div class="input-box">
				    <button class="but-det">Применить</button>
			    </div>
	        </form>
</body>
</html>