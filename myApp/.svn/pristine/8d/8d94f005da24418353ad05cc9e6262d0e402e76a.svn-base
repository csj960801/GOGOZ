<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${movePage == 'download'}">
	<jsp:include page="/Content/MusicDownLoader.jsp" />
</c:if>

<c:choose>
	<c:when test="${movePage == 'perform'}">
		<jsp:include page="/Content/ShowPerform.jsp" />
	</c:when>
	<c:when test="${movePage == 'BandDiary'}">
		<jsp:include page="/Content/BandDiary.jsp" />
	</c:when>
	<c:when test="${movePage == 'memberReg'}">
		<jsp:include page="/Member/MemberRegister.jsp" />
	</c:when>
	<c:when test="${movePage == 'memberlogin'}">
		<jsp:include page="/Member/login.jsp" />
	</c:when>
	<c:when test="${movePage == 'board'}">
		<jsp:include page="/Board/BoardForm.jsp" />
	</c:when>
</c:choose>