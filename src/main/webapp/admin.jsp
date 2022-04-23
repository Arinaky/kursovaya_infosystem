<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ru">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Панель администратора</title>
		<link rel="stylesheet" type="text/css" href="css/style1.css">
	</head>
	<body>
	    <div class="container">
	        <div class="title">Привет, админ</div>
	        <div>Оставьте поле пустым, если не хотите менять цену</div>
	    </div>

	    <div class="container">
		    <div class="title">Цена за виды уборки</div>
		    <form action="#">
			    <div class="user-details">
				    <div class="input-box">
					    <span class="details">Цена за уборку одного квадратного метра</span>
					    <input type="text" placeholder="Введите коэффициент" required name="clean_area">
				    </div>
			    </div>
			    <div class="button">
				    <input type="submit" value="Применить">
			    </div>
		    </form>
	    </div>

		<div class="container">
		    <div class="title">Цена за виды уборки</div>
		    <form action="#">
			    <div class="user-details">
				    <div class="input-box">
					    <span class="details">Цена за генеральную уборку</span>
					    <input type="text" placeholder="Введите коэффициент" required name="clean_type1">
				    </div>

    				<div class="input-box">
	    				<span class="details">Цена за облегченную уборку</span>
		    			<input type="text" placeholder="Введите коэффициент" required name="clean_type2">
			    	</div>

    				<div class="input-box">
	    				<span class="details">Цена за уборку после ремонта</span>
		    			<input type="text" placeholder="Введите коэффициент" required name="clean_type3">
			    	</div>

    				<div class="input-box">
	    				<span class="details">Цена за послестроительную уборку</span>
		    			<input type="text" placeholder="Введите коэффициент" required name="clean_type4">
			    	</div>
			    </div>
			    <div class="button">
				    <input type="submit" value="Применить">
			    </div>
		    </form>
	    </div>

	    <div class="container">
        		    <div class="title">Цена за дополнительные услуги</div>
        		    <form action="#">
        			    <div class="user-details">
        				    <div class="input-box">
        					    <span class="details">Цена за услугу "Полировка полов"</span>
        					    <input type="text" placeholder="Введите коэффициент" required name="clean_service_1">
        				    </div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Мытье посуды"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_2">
        			    	</div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Стирка+глажка"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_3">
        			    	</div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Мытье окон"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_4">
        			    	</div>

        			    	<div class="input-box">
        					    <span class="details">Цена за услугу "Уборка стен"</span>
        					    <input type="text" placeholder="Введите коэффициент" required name="clean_service_5">
        				    </div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Чистка унитаза"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_6">
        			    	</div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Чистка раковин"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_7">
        			    	</div>

            				<div class="input-box">
        	    				<span class="details">Цена за услугу "Уборка балкона"</span>
        		    			<input type="text" placeholder="Введите коэффициент" required name="clean_service_8">
        			    	</div>
        			    </div>
        			    <div class="button">
        				    <input type="submit" value="Применить">
        			    </div>
        		    </form>
        	    </div>

	</body>
	</html>