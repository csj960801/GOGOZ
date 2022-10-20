/**
 * Created By CSJ
 */
$(function() {
	// 게시글 초기화
	boardContentReset();
});

// 게시글입력창을 2번 클릭시 value값 초기화
function boardContentReset() {

	$("#b-content").on("dblclick", function() {
		document.getElementById("b-content").value = "";
	});

}// end of boardContentReset()
