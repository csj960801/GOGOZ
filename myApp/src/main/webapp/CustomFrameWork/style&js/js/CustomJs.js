// Create By CSJ
function MenuHoverOption(){
	$("#MemberRegister").mouseover(function(){
		$("#MemberRegister").text("회원가입");
	});
	$("#MemberLogin").mouseover(function(){
		$("#MemberLogin").text("로그인");
	});
	$("#MemberRegister").mouseout(function(){
		$("#MemberRegister").text("MemberReg");
	});
	$("#MemberLogin").mouseout(function(){
		$("#MemberLogin").text("Login");
	});
};
$(function() {	
	MenuHoverOption();
	
	browserCheck();
	
	//브라우저 지원 버전체크, 네트워크 연결유무확인
	if (window.addEventListener && navigator.onLine) {

		// 로그인 & 회원가입 & 로그아웃
		MemberFunction();
		
		// 게시판
		BoardFunction();
		
		// 관리자 페이지
		$("#MemberAdmin").click(function(){
			window.location.href="/Admin/Admin.do";
		});
	}
	else{
		alert("지원되지않는 브라우저버전이거나 네트워크에 연결되어 있지않습니다.");
	    return false;
	}
});
/**
 * ie8버젼 이하의 브라우저 및 익스플로러 block
 */
function browserCheck() {
	var browser = navigator.userAgent.toLowerCase();
	var appType = navigator.appName;

		if (browser.indexOf("chrome") > -1 || browser.indexOf("firefox") > -1) {
			// alert("지원브라우저 확인 되었습니다" + browser);
		}
		if ((appType == "Netscape" && browser.search('trident') != -1) || (browser.indexOf("msie") != -1) || (browser.search("edge") != -1)) {
			// search() ㅡ 검색된 문자열의 위치값을 내놓는다. (전체 문자열에서 몇번째에 있는지)
			// Trident는 MS의 IE(익스플로러)에서 사용하고 있는 레이아웃 엔진의 이름
			alert("익스플로러 브라우저는 지원되지않습니다. 크롬과 파이어폭스 브라우저에서 다시 접속해주세요!");
			document.getElementsByTagName("body")[0].innerHTML = "<h1 class='main-title'>접속거부.</h1>";
			return false;
	   }
}

/**
 * 로그인 & 회원가입 & 로그아웃 & 회원탈퇴 & 회원정보수정
 */
function MemberFunction() {
	
	// 회원가입
	$("#MemberRegister").on("click",function() {
        window.location.href="/MemberRegister/MemberRegister.jsp";
	});
	$("#registerBtn").click(function(){
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		if(name.length <= 0 || email.length <= 0){
			alert("입력된 데이터가 없습니다.");
			document.getElementById("name").focus();
			return false;
		}else if(name.length > 4 || email.length > 20){
			alert("입력된 데이터들이 옳지 않는 형식입니다.");
			return false;		
		}
		
		//var userdata={"name":name, "email":email};
		/*$.ajax({
		    url:"/MemberReg/MemberReg.do",
		    data: JSON.stringify(userdata),
		    dataType:"json",
			contentType:"application/json;charset=UTF-8",
		    type:"post",
		    success:function(result){
		    	alert("회원가입 성공~");
        		window.location.href="/MemberLogin/login.do";
		    },
		    error:function(){
		     	alert("회원가입 실패했습니다.");				    
		    }
		});*/
		document.regFrm.action = "/MemberReg/MemberReg.do";
		document.regFrm.method = "post";
	    document.regFrm.submit();
	});
	
	// 로그인
	$("#MemberLogin").on("click",function() {
        window.location.href="/MemberLogin/login.jsp";
	});
	
	var loginCnt=0;
	$("#loginBtn").click(function() {
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var rememberName = document.querySelector(".remember").checked;
		console.log("체크박스 값: " + rememberName);
		
		if(name.length <= 0 || email.length <= 0){
			alert("입력된 데이터가 없습니다.");
			document.getElementById("name").focus();
			return false;
		}else if(name.length > 4 || email.length > 25){
			alert("입력된 데이터들이 옳지 않는 형식입니다.");
			loginCnt++;
			if(loginCnt == 5){
				alert(loginCnt+"회 로그인 실패하셨습니다.\n24시간 후 이용해주세요.");
				document.loginFrm.action = "/index.do?login=F";
				document.loginFrm.method = "post";
			    document.loginFrm.submit();
			}
			console.log(loginCnt);
			
			return false;		
		}		
		
		/*var logindata = {"name":name, "email":email};
        $.ajax({
        	url:"/MemberLog/MemberLog.do",
        	data:JSON.stringify(logindata),
        	dataType:"json",
        	contentType:"application/json;charset=utf-8",
          	type:"post",
            success:function(result){
        		alert("로그인 성공~");
        		window.location.href="/index.do?result="+encodeURI(result);
        	},
        	error:function(){
        		alert("로그인 실패");
        	}
        });*/
		document.loginFrm.action = "/MemberLog/MemberLog.do?remember="+encodeURI(rememberName);
		document.loginFrm.method = "post";
	    document.loginFrm.submit();
	});
    
	// 로그아웃
	$("#MemberLogOut").click(function(){
		window.location.href="/MemberLogout.do";
	});

	// 회원탈퇴
	$("#MemberDelete").on("click",function() {
        window.location.href="/MemberDelete/delete.jsp";
	});
	$("#delBtn").click(function() {
		var email = document.getElementById("del_email").value;
		if(email.length <= 0){
			alert("입력된 데이터가 없습니다.");
			document.getElementById("del_email").focus();
			return false;
		}		
		//document.getElementById("delFrm").setAttribute("action","/MemberDel/MemberDel.do");
		//document.getElementById("delFrm").setAttribute("method","post");

		document.delFrm.action = "/MemberDel/MemberDel.do";
		document.delFrm.method = "post";
	    document.delFrm.submit();

	});
	
	// 회원수정
	$("#MemberUpdate").on("click",function() {
        window.location.href="/MemberUpdate/update.jsp";
	});
	$("#updateBtn").click(function() {
		var originEmail = document.getElementById("originEmail").value;
		var modifyEmail = document.getElementById("modifyEmail").value;
		if(originEmail.length <= 0 || modifyEmail.length <= 0){
			alert("입력되지 않은 폼이 있습니다.");
			document.getElementById("originEmail").focus();
			return false;
		
		}else if(originEmail == modifyEmail){
	
			alert("기존이메일과 수정이메일이 동일합니다.");
			document.getElementById("originEmail").value = "";
			document.getElementById("modifyEmail").value = "";			
			
			document.getElementById("originEmail").focus();
			return false;							
		
		}		
		//document.getElementById("updateFrm").setAttribute("action","/MemberUpdate/MemberUpdate.do");
		//document.getElementById("updateFrm").setAttribute("method","post");

		document.updateFrm.action = "/MemberUpdate/MemberUpdate.do";
		document.updateFrm.method = "post";
	    document.updateFrm.submit();

	});
}

/**
 * 게시판 기능
 */
function BoardFunction(){
	
	// 질문 게시판
	$("#InquiryBoard").on("click", function(){
	    window.location.href="/Board/BoardForm.jsp";			
	});
	$("#InquirySubmitBtn").click(function() {
		var title = document.getElementById("b-title").value;
		var writer = document.getElementById("b-name").value;
		var date = document.getElementById("b-date").value;
		var content = document.getElementById("b-content").value;
		var BoardArray = [title, writer, date, content];
		
		for(var dataInt in BoardArray){
			if(BoardArray[dataInt] == null || BoardArray[dataInt].length <= 0){
				alert("입력되지 않은 폼이 있습니다.");
				return false;
			}
		}
		/*var boardJson = {"title":title, "writer":writer, "date":date, "content":content};
		$.ajax({
			url:"/InquiryBoard/Inquiry.do",
			type:"post",
			dataType:"json",
			data:JSON.stringify(boardJson),
			contentType:"application/json",
			success:function(result){
				alert("문의해주셔서감사합니다! 빠른 시일내에 답변하겠습니다 ");
				window.location.href = "/";
			},
			error:function(){
				alert("문의실패");
			    return false;
			}
		});*/
		document.InquiryBoardFrm.action = "/InquiryBoard/Inquiry.do";
		document.InquiryBoardFrm.method = "post";
	    document.InquiryBoardFrm.submit();
	});
	
	// 게시글 수정을 위해 유저가 작성했던 게시글 목록으로 
	$("#InquiryReviseBtn").click(function(){
		var userName = document.querySelector(".userMember").value;
		document.InquiryBoardFrm.action = "/InquiryBoard/InquiryRevisionList.do?updateType=client&userName="+encodeURI(userName);
		document.InquiryBoardFrm.method = "post";
	    document.InquiryBoardFrm.submit();
	});
	
	// 게시글 수정완료 
	$("#InquiryUpdateBtn").click(function(){
		var inquiry_update_data = document.querySelector(".updateNum").value;
		document.InquiryBoardFrm.action = "/InquiryBoard/InquiryRevisionList.do?updateType=server&updateContent="+encodeURI(inquiry_update_data);
		document.InquiryBoardFrm.method = "post";
	    document.InquiryBoardFrm.submit();
	});
};


/**
 * 게시글 수정을 요청한 데이터 파악하는 함수 
 * @param revisionData
 * @returns
 */
function inquiryRevisionResolver(revisionData){
	document.InquiryBoardFrm.action = "/InquiryBoard/InquiryRevision.do?updateData="+encodeURI(revisionData);
	document.InquiryBoardFrm.method = "post";
    document.InquiryBoardFrm.submit();		
}

/**
 * 관리자 전용
 * @param data
 * @param type
 * @returns
 */
function Admin(data, type){
    if(type == "board"){
    
    	 document.AdminFrm.action="/Admin/AdminDel.do?titleparam=" + encodeURI(data) + "&delParam=board";
		 document.AdminFrm.method ="post";
	     document.AdminFrm.submit();

    }else if(type == "memberDel"){
		
		 document.AdminFrm.action="/Admin/AdminDel.do?titleparam=" + encodeURI(data) + "&delParam=member";
		 document.AdminFrm.method ="post";
	     document.AdminFrm.submit();
	
	//회원 수정 페이지로(client)
    }else if(type == "memberUpdate"){
		
		 document.AdminFrm.action="/Admin/AdminUpdate.do?updateType=client";
		 document.AdminFrm.method ="post";
	     document.AdminFrm.submit();

	//회원 수정 완료시키기(server)
    }else if(type == "memberUpdateComplete"){
		
		 document.AdminFrm.action="/Admin/AdminUpdate.do?updateType=server";
		 document.AdminFrm.method ="post";
	     document.AdminFrm.submit();
	}
};