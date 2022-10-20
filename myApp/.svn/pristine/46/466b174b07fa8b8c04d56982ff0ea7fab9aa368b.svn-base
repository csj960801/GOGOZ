<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<c:if test="${sessionScope.adminSession == null}">
	<script>
		alert("관리자만 이용가능합니다.");
		window.location.href = "/";
	</script>
</c:if>

<body>
	<form id="AdminFrm" name="AdminFrm">
			
	<div class="manager_tbl_wrapper table-responsive">
		<table class="table manager_table">
			<colgroup>
				<col width="35%" />
				<col width="35%" />
				<col width="25%" />
			</colgroup>
			<thead>
				<tr>
					<th>회원명</th>
					<th>Email</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr class="manager_tr">
					<td class="manager_td">
					   <input type="text" value="${UpdateName}" name="name">
					</td>
					<td class="manager_td">
					   <input type="text" value="${UpdateEmail}" name="email">
					</td>
					<td class="manager_td">
						<button id="AdminupdateBtn" onclick="Admin('','memberUpdateComplete')"class="btn btn-sm">회원수정</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
</body>
<jsp:include page="/Template/Bottom.jsp" />

<c:if test="${memberUpdate > 0}">
	<script>
		alert("수정 완료했습니다.");
		window.location.href = "/Admin/Admin.do";
	</script>
</c:if>