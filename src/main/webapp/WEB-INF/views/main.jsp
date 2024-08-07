<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Your website description here">
    <meta name="author" content="Your Name">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="/css/pages/main.css" rel="stylesheet">
    
    <!-- Swipe 기능 -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    
    <!-- 메인 JS -->
    <script type="text/javascript" src="/js/main/main.js"></script>
    <title>Cafe-Tart 메인</title>
</head>
<body>
    <div class="main-content container">
        <nav class="lnb">
            <a href="#">Menu</a>
            <a href="#">Order</a>
            <a href="#">Locations</a>
        </nav>
        <div class="content">
            <h1>미지타르트에 오신 걸 환영해요!</h1>
            <p>포르투칼의 파스테이스 드 벨렝의 맛을 재현한 맛!</p>
        </div>

        <!-- Swiper -->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="/img/deploy_products/eggTart001.png" alt="에그타르트 001">
				</div>
				<div class="swiper-slide">
					<img src="/img/deploy_products/eggTart002.png" alt="에그타르트 002">
				</div>
				<div class="swiper-slide">
					<img src="/img/deploy_products/eggTart003.png" alt="에그타르트 003">
				</div>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination"></div>
			<!-- Add Navigation -->
			<!-- 
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
			 -->
		</div>

	</div>
</body>
</html>
