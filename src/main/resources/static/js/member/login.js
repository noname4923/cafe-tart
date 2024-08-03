/* [NTA-blog] 로그인 JS */
$(document).ready(function() {
	
});

/* Login 기능 */
function login() {
	alert('로그인');
	
	var email = $('#email').val();
	var password = $('#password').val();
	
	var userData = {
		'email' : email,
		'password' : password 
	}
	
	$.ajax({
		type: 'POST',
		async: false,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType: 'json',
		url: '/member/login',
		data: userData,
		success: function(data) {

			console.log('Login AJAX data : ', data);
			
			if (data.status == 200) { // 서버에서 success 상태를 확인하는 경우
                // window.location.reload(); // 현재 페이지 새로고침
                // 페이지 이동
				window.location.href = '/'; // 메인 페이지로 리디렉션
				
				// 현재 페이지의 쿼리 매개변수를 유지하고 새로운 URL로 이동
				//window.location.href = window.location.origin + "/newPage";
            } else {
                alert('로그인 실패: ' + data.message); // 실패 시 메시지 표시
            }
		},
		error: function(e) {
			//placeAlert('알림', '회원정보 조회 실패했습니다.');
			alert('Login AJAX 에러');
			return false;
		}
	});
	
}
