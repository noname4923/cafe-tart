/* [NTA-blog] 메인 JS */
$(document).ready(function() {
	
	var swiper = new Swiper('.swiper-container', {
		slidesPerView: 1,
		spaceBetween: 10,
		pagination: {
			el: '.swiper-pagination',
			clickable: true,
		},
		loop: true,
		autoplay: {
			delay: 3000,
			disableOnInteraction: false,
		},
	});


	//$('#memberInfoButton').on("click", function () {
	//});



});


/* Main 시작 기능 */
function getMemberInfo() {
	alert('회원정보 갖고오기 예시..');

	$.ajax({
		type: 'GET',
		async: true,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType: 'json',
		url: '/member/v1/selectMemberInfo',
		//data: areaData,
		success: function(data) {

			console.log('AJAX data : ', data);
			
			$('#memberInfoArea').text(data.data.nm);
		},
		error: function(e) {
			//placeAlert('알림', '회원정보 조회 실패했습니다.');
			alert('AJAX 에러');
			return false;
		}
	});
	
}
