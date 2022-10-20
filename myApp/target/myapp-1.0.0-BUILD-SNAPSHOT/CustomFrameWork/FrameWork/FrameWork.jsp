<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String protocolType = request.getProtocol();
	if (protocolType.equals("http/1.1".toLowerCase()) || protocolType.equals("http/1.1".toUpperCase())) {
%>
<meta content="initial-scale=1.0, width=device-width, user-scalable=yes"
	name="viewport" />

<!-- style -->
<link href="/CustomFrameWork/style&js/fontAwesome/font-awesome.min.css"
	rel="stylesheet" />
<link href="/CustomFrameWork/style&js/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/CustomStyle.css"
	rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/MeetFace.css" rel="stylesheet" />

<!-- js -->
<script src="/CustomFrameWork/style&js/js/jquery-3.2.1.js"></script>
<script src="/CustomFrameWork/style&js/bootstrap/bootstrap.min.js"></script>
<script src="/CustomFrameWork/style&js/js/CustomJs.js"></script>
<script src="/CustomFrameWork/style&js/js/CustomEffect.js"></script>

<!--
<script src="/CustomFrameWork/style&js/js/RTC/playrtc.js"></script>
<script src="/CustomFrameWork/style&js/js/RTC/playrtc.min.js"></script>
<script src="/CustomFrameWork/style&js/js/RTC/ComponentFunction.js"></script>
 -->
<%
	}
%>