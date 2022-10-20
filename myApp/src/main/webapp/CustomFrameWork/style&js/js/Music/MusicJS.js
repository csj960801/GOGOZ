/**
 * MusicDownload 전용 by CSJ
 */
$(function() {
  // ie8외 브라우저에서 지원되게끔.
  if(window.addEventListener){
		
	$("#AdminUploader").click(function() {
	    window.location.href="/FileUpload/FileUpload.jsp";
	});
	$("#downloader").click(function() {
	    window.location.href="/Music/MusicList.music";
	});
	$("#downloader-blocked, #chanel-block").click(function() {
        alert("회원만 사용가능한 서비스입니다. 로그인을 해주세요.");
	    window.location.href="/MemberLogin/login.jsp";
	});
   
    MusicUploader();
	
	}
    // ie8이하의 브라우저일 경우
    else{
		document.getElementsByTagName("body")[0].innerHTML = "<h1>지원되지않는 브라우저환경입니다.</h1>";
	}

});

/**
 * 파일업로더 전용(FileUpload.jsp)
 * @returns
 */
function MusicUploader(){
	$("#uploadBtn").on("click",function(){
		var uploader = document.getElementById("uploader").value;
		var uploadDate = document.getElementById("uploadDate").value;
		var uploadMusic = document.getElementById("uploadMusic").value;
	
	    var fileArray = new Array();
	    fileArray[0] = uploader;
	    fileArray[1] = uploadDate;
	    fileArray[2] = uploadMusic;
		
	    for(var i=0; i<fileArray.length; i++){
	    	if(fileArray[i] == null || fileArray[i].length <= 0){
	    		alert("입력된 정보들을 다시 확인해주세요");
	    		document.getElementById("uploader").focus();
	    		return false;
	    	}
		 }
	    document.getElementById("FileUploadFrm").setAttribute("method","post");
	    document.getElementById("FileUploadFrm").setAttribute("action","/Music/MusicList.music");
		//document.getElementById("FileUploadFrm").setAttribute("enctype","multipart/form-data");
		});
	
	$("#DownloadBtn").on("click",function(){
	    document.getElementById("FileUploadFrm").setAttribute("method","get");
	    document.getElementById("FileUploadFrm").setAttribute("action","/Music/MusicList.music");	    	
	});
};

/**
 * MusicDownload.jsp에서 선택한 음악을 다운로드 해줄 데이터와 form생성
 * @returns
 */
function multiPartForm(music){
	// 국가코드 확인
	var nationLang = navigator.language;
	
	$(".musicTitle").on("click",function(){
       window.location.href="/Music/MusicDownloadActivate.music?selectedMusic=" + encodeURI(music)
       															+ "&nationLang=" + encodeURI(nationLang);
	});
};