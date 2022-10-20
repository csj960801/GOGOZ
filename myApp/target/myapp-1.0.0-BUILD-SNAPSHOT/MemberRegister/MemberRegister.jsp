<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/Template/Top.jsp" />

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
				<div class="memberRegister-Wrapper form-group">
					<fieldset class="Member-fieldset">
						<legend class="Member-legend">회원가입</legend>
						<input type="text" class="form-control" name="userName"
							id="userName">
						<button class="btn btn-primary" id="registerBtn">회원가입</button>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />