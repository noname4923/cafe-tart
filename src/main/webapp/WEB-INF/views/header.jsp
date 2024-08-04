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

<!-- CSS -->
<link href="/css/common/header.css" rel="stylesheet">
<link href="/css/common/bootstrap.css" rel="stylesheet">
<link href="/css/common/navbar.css" rel="stylesheet">


<!-- JavaScript files (deferred to load after the DOM is ready) -->
<script src="/js/common/bootstrap.bundle.min.js"></script>
<script src="/js/common/jquery-3.6.3.min.js"></script>

<!-- Cafe-Tart 파비콘 -->
<link rel="icon" href="/ntaProto.ico">
</head>
<body>
	<header class="header">
		<div class="logo">블로그 로고</div>
		<div class="nav">
			<a href="#">홈</a> <a href="#">블로그</a> <a href="#">구독</a>
		</div>

		<!-- 권한 영역 -->
		<div class="auth">
			<!-- 로그인 상태라면,  -->
			<c:if test="${pageContext.request.getSession().getAttribute('member') != null}">
				<!-- 로그아웃 페이지 이동 -->
				<a href="/member/logout"> <img alt="로그아웃" src="/img/logout.svg">
				</a>
				<!-- 마이페이지 페이지 이동 -->
				<a href="/member/mypage"> <img alt="마이페이지" src="/img/mypage.svg">
				</a>
			</c:if>
			<!--  로그인 상태가 아니라면, -->
			<c:if test="${pageContext.request.getSession().getAttribute('member') == null}">

				<!-- 로그인 페이지 이동 -->
				<a href="/member/loginView"> <img alt="로그인" src="/img/login.svg">
				</a>
				<!-- 회원가입 페이지 이동 -->
				<a href="/member/joinView"> <img alt="회원가입" src="/img/join.svg">
				</a>
			</c:if>
		</div>
	</header>
</body>
</html>
