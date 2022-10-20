/**
 * Created By CSJ
 */
$(function() {
	// 게시글 초기화
	boardContentReset();

	urlCheck();
});

// 게시글입력창을 2번 클릭시 value값 초기화
function boardContentReset() {

	$("#b-content").on("dblclick", function() {
		document.getElementById("b-content").value = "";
	});

}// end of boardContentReset()

/**
 * url 확인
 * 
 * @returns
 */
function urlCheck() {
	// var protocol = window.location.protocol; //프로토콜(http:)
	// var host = window.location.host; // 호스트 이름
	var path = window.location.pathname; // /폴더명/페이지파일명

	var pathArr = window.location.pathname.split("/");
	for (var i = 0; i < pathArr.length; i++) {
		console.log(pathArr[i]);
		if (pathArr[i].indexOf("MemberDelete") > -1) {
			document.querySelector("#MemberDelete .use_info").innerHTML = "(사용중)";
		}
		if (pathArr[i].indexOf("MemberUpdate") > -1) {
			document.querySelector("#MemberUpdate .use_info").innerHTML = "(사용중)";
		}
		if (pathArr[i].indexOf("Board") > -1) {
			document.querySelector("#InquiryBoard .use_info").innerHTML = "(사용중)";
		}

		// 기기의 화면에 따라 폰트 사이즈 변경
		var deviceWidth = screen.width;
		if (deviceWidth > 767) {
			document.querySelector("#" + pathArr[1] + ">.use_info").style.fontSize = "13px";
		} else {
			document.querySelector("#" + pathArr[1] + ">.use_info").style.fontSize = "10px";
		}
	}
};

/**
 * 키보드 CapsLock을 눌렀을 경우, alert발생
 * 
 * @returns
 */
window.onload = keyboardEffect();
function keyboardEffect() {
	var browserInfo = navigator.userAgent.toUpperCase();
	var useBrowser = [ "CHROME", "FIREFOX", "MOZILA" ];

	for (var i = 0; i < useBrowser.length; i++) {
		// 크롬, 파이어폭스, 모질라 브라우저가 포함되어 있을 경우,
		if (browserInfo.indexOf(useBrowser[i]) > -1) {
			window.addEventListener("keydown", function(event) {
				if (event.getModifierState("CapsLock")) {
					alert("CapsLock이 켜졌습니다.");
				} else {
					// alert("CapsLock이 꺼졌습니다.");
				}
			});
		}
		// IE(윈도우 익스플로러)
		/*
		 * window.onkeydown = function(event) { var caplock =
		 * event.getModifierState("CapsLock"); if (caplock) { alert("CapsLock
		 * Switch On"); } else { // alert("CapsLock Switch Off"); } }
		 */
	}// end of for()
	// console.log(browserInfo);

};