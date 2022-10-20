<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginNeed.jsp" />

<body>
	<div class="update_wrapper">
		<div class="container update_container">
			<div class="row update_row">
				<div class="col-md-12 col-xs-12 table-responsive form-group">
					<form id="updateFrm" name="updateFrm">
						<h3 class="update_h3"><span class="loginInfo">${sessionScope.loginName}</span>님의 이메일수정</h3>
						<table class="table update_table">
							<tbody>
								<tr>
									<th>기존이메일</th>
									<td><input type="text" class="form-control originEmail"
										name="originEmail" id="originEmail" value="${sessionScope.loginEmail}" readonly="readonly"></td>
								</tr>
								<tr>
									<th>수정이메일</th>
									<td><input type="text" class="form-control modifyEmail"
										name="modifyEmail" id="modifyEmail"></td>
								</tr>
								<tr>
									<td colspan="2" align="right">
										<button id="updateBtn" class="update btn btn-primary">수정하기</button>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/Template/Bottom.jsp" />