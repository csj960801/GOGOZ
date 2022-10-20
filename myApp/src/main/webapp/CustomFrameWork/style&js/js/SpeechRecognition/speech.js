/**
 * CSJ
 */
window.onload = speech();
/**
 * 음성인식 담당 함수
 * 
 * @returns
 */
function speech() {

	window.SpeechRecognition = window.SpeechRecognition
			|| window.webkitSpeechRecognition;

	const recog = new SpeechRecognition();

	recog.lang = "ko-KR";

	recog.continuous = true;

	recog.maxAlternatives = 11000;

	recog.interimResults = true;

	recog.start();
	recog.addEventListener("result", (recogResult) => {
		console.log(recogResult);
		
		for (var i = 0; i < recogResult.results.length; i++) {
			var data = recogResult.results[i][0].transcript;
			console.log("인식된데이터: " + data);
		   
			// 회원가입
			if((data.indexOf("가입") > -1) || (data.indexOf("회원가입") > -1) || (data.indexOf("회원") > -1)){
		        alert("네, 회원가입 페이지로 이동하도록 할게요.");
		        if(i > 1)break;
		     	window.location.href="/MemberRegister/MemberRegister.jsp";
			}
			// 로그인
		    if((data.indexOf("로그인") > -1) || (data.indexOf("로긴") > -1)){
		    	alert("네, 로그인 페이지로 이동합니다");
		        if(i > 1)break;
				window.location.href="/MemberLogin/login.jsp";
			}
		    // 프로그램 종료
		    if((data.indexOf("종료") > -1) || (data.indexOf("꺼") > -1)){
		    	alert("네, GoGoZ 서비스를 이용해주셔서 감사합니다. 좋은 하루 되세요.");
		        if(i > 1)break;
				window.close();
		    }
		    
		}
	});
};
