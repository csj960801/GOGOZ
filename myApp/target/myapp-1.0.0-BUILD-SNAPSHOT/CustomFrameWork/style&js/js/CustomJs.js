//Create By CSJ
$(function() {

	// ie8버젼 이하의 브라우저 block
	browserCheck();

	// 메인페이지에 게시글 출력
	boardListAjax();

	// 라이브 기능에 공연 라이브를 띄운다.
	MeetFace();

	// 클라이언트 페이징 전용
	$("#downloader").on("click", function() {
		location.href = "/paging.do?pageNum=1";
	});
	$("#perform").on("click", function() {
		location.href = "/paging.do?pageNum=2";
	});
	$("#BandDiary").on("click", function() {
		location.href = "/paging.do?pageNum=3";
	});
	$("#MemberRegister").on("click", function() {
		location.href = "/paging.do?pageNum=4";
	});
	$("#MemberLogin").on("click", function() {
		location.href = "/paging.do?pageNum=5";
	});
	$("#BoardClient").on("click", function() {
		location.href = "/paging.do?pageNum=6";
	});

	// 백엔드 기능 전용
	// 회원가입
	$("#registerBtn")
			.on(
					"click",
					function() {
						var MemberName = $("#userName").val();
						var MemberEmail = $("#userEmail").val();
						if (MemberEmail === null || MemberEmail === undefined
								|| MemberName.length > 4
								|| MemberName.length <= 1
								|| MemberEmail.indexOf("@") <= -1) {
							alert("입력된 정보는 옳지않는 형식입니다.");
							return false;
						}

						location.href = "/memberPaging.do?backend=memberinsert&MemberName="
								+ encodeURI(MemberName)
								+ "&MemberEmail="
								+ encodeURI(MemberEmail);
					});

	// 로그인
	$("#loginBtn")
			.on(
					"click",
					function() {
						var loginName = $("#login-name").val();
						var loginEmail = $("#login-email").val();

						if (loginName.length <= 0 || loginEmail === undefined
								|| loginEmail === null
								|| loginEmail.indexOf("@") <= -1) {
							alert("login형식에 어긋났습니다.");
							return false;
						}

						location.href = "/memberPaging.do?backend=memberlogin&loginName="
								+ encodeURI(loginName)
								+ "&loginEmail="
								+ encodeURI(loginEmail);

					});

	// 게시판
	$("#boardBtn").on(
			"click",
			function() {
				var title = $("#b-title").val();
				var writer = $("#b-name").val();
				var date = $("#b-date").val();
				var content = $("#b-content").val();

				if (title.length <= 1 || writer.length <= 1 || date == null
						|| content.length <= 1) {
					alert("입력된 게시글 데이터는 잘못된형식입니다.");
					return false;
				}

				window.location.href = "/boardPaging.do?BoardPaging=1&title="
						+ encodeURI(title) + "&writer=" + encodeURI(title)
						+ "&date=" + encodeURI(date) + "&content="
						+ encodeURI(content);

			});
});

// 게시판 리스트 출력
function boardListAjax() {

	$.ajax({
		url : "/Board/BoardList.jsp",
		type : "post",
		dataType : "html",
		success : function(result) {
			$(".board-list-wrapper").html(result);
		},
		error : function(e) {
			alert("BoardListError!");
			console.log(e);
		}

	});

}// end of boardListAjax()

// RTC 오픈소스
function MeetFace() {

	if (window.addEventListener) {

		$.ajax({
			url : "/Content/RTC/MeetFace.jsp",
			type : "post",
			dataType : "html",
			success : function(play) {
				$(".Rtc-activate-wrapper").html(play);
			},
			error : function(e) {
				alert("Rtc Error!");
				console.log(e);
			}

		});
	}
	else {
		alert("지원하지않는 브라우저 버전입니다!");
		window.location.href="/";
	}
}

// ie8버젼 이하의 브라우저 및 익스플로러 block
function browserCheck() {
	var browser = navigator.userAgent.toLowerCase();
	var appType = navigator.appName;

	if (window.addEventListener) {

		if (browser.indexOf("chrome") > -1 || browser.indexOf("firefox") > -1) {
			alert("지원브라우저 확인 되었습니다" + browser);
		}

		if ((appType == "Netscape" && navigator.userAgent.search('Trident') != -1)
				|| (browser.indexOf("msie") != -1)
				|| (navigator.userAgent.search("edge") != -1)) {
			// search() ㅡ 검색된 문자열의 위치값을 내놓는다. (전체 문자열에서 몇번째에 있는지)
			// Trident는 MS의 IE(익스플로러)에서 사용하고 있는 레이아웃 엔진의 이름
			alert("익스플로러 브라우저는 지원되지않습니다. 크롬과 파이어폭스 브라우저에서 다시 접속해주세요!");
			document.getElementsByTagName("body")[0].innerHTML = "<h1 class='main-title'>접속거부.</h1>";
			return false;
		}

	} else {
		alert("ie8버젼 이하의 브라우저는 지원하지않습니다.");
		return false;
	}
}// end of browserCheck()
