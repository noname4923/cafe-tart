<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Your website description here">
    <meta name="author" content="Your Name">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="/css/pages/main.css" rel="stylesheet">
    
    <!-- 메인 JS -->
	<script type="text/javascript" src="/js/main/main.js"></script>
	
	<!-- Swipe 기능 -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <title>Cafe-Tart 메인</title>
</head>


<!-- LazyLoad 추가 예정 -->

<body>
    <div layout:fragment="content">
        <div class="search-bar">
            <input type="text" placeholder="검색어를 입력하세요...">
            <button>검색</button>
        </div>

        <div class="container">
            <div class="left-menu">
                <h3>프로필</h3>
                <p>로그인한 사용자 정보</p>
                <h3>카테고리</h3>
                <ul>
                    <li><a href="#">카테고리 1</a></li>
                    <li><a href="#">카테고리 2</a></li>
                    <li><a href="#">카테고리 3</a></li>
                </ul>
                <h3>최근 글</h3>
                <ul>
                    <li><a href="#">최근 글 1</a></li>
                    <li><a href="#">최근 글 2</a></li>
                    <li><a href="#">최근 글 3</a></li>
                </ul>
                <h3>인기 글</h3>
                <ul>
                    <li><a href="#">인기 글 1</a></li>
                    <li><a href="#">인기 글 2</a></li>
                    <li><a href="#">인기 글 3</a></li>
                </ul>
            </div>

            <div class="main-contents">
                <h2>주요 블로그 포스트</h2>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">포스트 1</div>
                        <div class="swiper-slide">포스트 2</div>
                        <div class="swiper-slide">포스트 3</div>
                        <div class="swiper-slide">포스트 4</div>
                        <div class="swiper-slide">포스트 5</div>
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
