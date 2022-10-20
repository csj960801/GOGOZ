<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginForbidden.jsp" />

<c:if test="${sessionScope.loginName != null || sessionScope.adminSession != null}">
	<script>
		alert("로그인이 이미 되어있는 상태입니다.");
		window.location.href = '/';
	</script>
</c:if>

<div class="MemberRegister-main">
	<div class="content-title">
		<h2 class="content-menu-h2">MemberRegister</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>member</li>
			<li>MemberRegister</li>
		</ol>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12- col-xs-12">
				<form id="MemberRegFrm" name="regFrm">
					<div class="memberRegister-Wrapper form-group">
						<fieldset class="Member-fieldset">
							<div class="userName-wrapper">
								<label for="name">성함</label> 
								<input type="text" class="form-control" name="name" id="name" autocomplete="off">

								<div class="clearfix"></div>

								<label for="email">Email</label>
								<input type="Email" class="form-control" name="email" id="email" autocomplete="off">
							</div>
							
							<div class="Function_Section">
								<button class="btn btn-primary" id="registerBtn">회원가입</button>
								<p class="text-center account_Exist">
									<a href="javascript:window.location.href='/MemberLogin/login.jsp'" class="account-a">게정</a>이 있으신가요?
								</p>
							</div>
						</fieldset>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />