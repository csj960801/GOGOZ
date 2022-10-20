<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/Template/Top.jsp" />

<div class="login-wrapper">
	<div class="content-title">
		<h2 class="content-menu-h2">MemberLogin</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>member</li>
			<li>MemberLogin</li>
		</ol>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="table-responsive form-group">
					<table class="login-table table table-hover">
						<tbody>
							<tr>
								<th><label for="login-name">성함</label></th>
								<td><input type="text" name="login-name"
									class="form-control" id="login-name"></td>
							</tr>
							<tr>
								<th><label for="login-email">email</label></th>
								<td><input type="email" name="login-email"
									class="form-control" id="login-email"></td>
							</tr>
							<tr>
							<td colspan="2" align="center">
							 <button id="loginBtn" class="btn btn-success">login</button>
							</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />