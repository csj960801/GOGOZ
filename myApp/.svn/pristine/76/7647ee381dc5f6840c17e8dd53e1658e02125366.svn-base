/**
 * 메인 페이지에 띄울 이벤트 팝업
 */
$(function() {
	$.ajax({
		url : "/Template/Event/EventPopup.jsp",
		data : { // 이벤트종류 데이터 설정
			"Event" : "demo"
		},
		dataType : "html",
		success : function(form) {
			if (form != null) {
				$(".Event_Popup").html(form);
			}
		},
		error : function() {
			alert("이벤트를 불러오지 못하였습니다");
			return false;
		}
	});
});