<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>MusicApp</title>
<jsp:include page="/CustomFrameWork/FrameWork/FrameWork.jsp" />
</head>
<div class="container-fluid">
	<div class="row">
		<div class="nav navbar-inverse main-menu">
			<div class="col-md-5 col-xs-6">
				<div class="navbar-header">
					<c:if test="${sessionScope.loginName == null}">
						<a href="/" class="navbar-brand">Spring-Header</a>
					</c:if>
					<c:choose>
						<c:when test="${sessionScope.loginName != null}">
							<a href="/" class="navbar-brand">${sessionScope.loginName}</a>
						</c:when>
					</c:choose>
				</div>
			</div>

			<div class="col-md-7 col-xs-6">
				<div class="navbar-body">
					<ul class="navbar-ul nav navbar-nav ">
						<c:if test="${sessionScope.loginName == null}">
							<li><a href="#" id="MemberRegister">회원가입</a></li>
							<li><a href="#" id="MemberLogin">로그인</a></li>
							<li><a href="#" id="BoardClient">게시판</a></li>
						</c:if>
						<c:choose>
							<c:when test="${sessionScope.loginName != null}">
								<li><a href="#" id="Login-success"><strong>'${sessionScope.loginName}'</strong>
										로그인 되었습니다</a></li>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</html>