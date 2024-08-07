<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Your website description here">
<meta name="author" content="Your Name">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="/css/pages/join.css" rel="stylesheet">
<title>회원가입</title>
</head>

<body>
	<div layout:fragment="content">
		<div class="container">

			<h1>회원가입</h1>
			<form action="/signup" method="POST">
				<div class="form-group">
					<label for="email">이메일</label> <input type="email" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="form-group">
					<label for="confirm_password">비밀번호 확인</label> <input
						type="password" id="confirm_password" name="confirm_password"
						required>
				</div>
				<div class="form-group">
					<label for="name">이름</label> <input type="text" id="name"
						name="name" required>
				</div>
				<div class="form-group">
					<label for="birth">생년월일</label> <input type="date" id="birth"
						name="birth">
				</div>
				<div class="form-group">
					<label for="mobile">연락처</label> <input type="tel" id="mobile"
						name="mobile">
				</div>
				<div class="form-group">
					<label for="address">주소</label> <input type="text" id="address"
						name="address">
				</div>
				<div class="form-group">
					<input type="checkbox" id="psnl_yn" name="psnl_yn" required>
					<label for="psnl_yn">개인정보 수집 동의</label>
				</div>
				<div class="form-group">
					<input type="checkbox" id="psnl_consign_yn" name="psnl_consign_yn"
						required> <label for="psnl_consign_yn">개인정보 3자 위탁
						동의</label>
				</div>
				<div class="form-group">
					<input type="checkbox" id="psnl_full_agr_yn"
						name="psnl_full_agr_yn" required> <label
						for="psnl_full_agr_yn">개인정보 입력 풀 저장 동의</label>
				</div>
				<div class="form-group">
					<button type="submit">회원가입</button>
				</div>
			</form>
			<div class="form-footer">
				<p>
					이미 회원이라면 <a href="/login">로그인</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>