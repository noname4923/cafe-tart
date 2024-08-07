$(document).ready(function() {
    var swiper = new Swiper('.swiper-container', {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
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
            alert('AJAX 에러');
            return false;
        }
    });
}
