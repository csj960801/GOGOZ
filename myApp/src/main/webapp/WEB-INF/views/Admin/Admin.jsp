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
	<div class="container">
		<div class="row manager_row">
			<div class="col-xs-12 col-md-12 form-group">
				<div class="manager_tbl_wrapper table-responsive">
					<form id="AdminFrm" name="AdminFrm">
						<h3 class="manager_title">문의/회원 정보</h3>
						<table class="table manager_table">
							<colgroup>
								<col width="150px" />
								<col width="200px" />
								<col width="180px" />
								<col width="300px" />
								<col width="50px" />
							</colgroup>
							<thead>
								<tr>
									<th>제목</th>
									<th>글쓴이</th>
									<th>날짜</th>
									<th>내용</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${Inquirylist != null}">
									<c:forEach var="list" items="${Inquirylist}">
										<tr class="manager_tr">
											<td class="manager_td">${list.title}</td>
											<td class="manager_td">${list.writer}</td>
											<td class="manager_td">${list.date}</td>
											<td class="manager_td">${list.content}</td>
											<td class="manager_td">
												<button id="AdminBoardDelBtn" onclick="Admin('${list.title}','board')" class="btn btn-sm">해당문의삭제</button>
											</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:choose>
									<c:when test="${Inquirylist == null}">
										<tr>
											<td class="manager_td" colspan="5">현재 데이터 없음</td>
										</tr>
									</c:when>
								</c:choose>

							</tbody>
						</table>

						<div class="manager_tbl_wrapper table-responsive">
							<table class="table manager_table">
								<colgroup>
									<col width="30%" />
									<col width="30%" />
									<col width="20%" />
									<col width="20%" />
								</colgroup>
								<thead>
									<tr>
										<th>회원명</th>
										<th>Email</th>
										<th>&nbsp;</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${memberlist != null}">
										<c:forEach var="memberlist" items="${memberlist}">
											<tr class="manager_tr">
												<td class="manager_td">${memberlist.name}</td>
												<td class="manager_td">${memberlist.email}</td>
												<td class="manager_td">
													<button id="AdmindelBtn" onclick="Admin('${memberlist.name}','memberDel')" class="btn btn-sm">회원삭제</button>
												</td>
												<td class="manager_td">
													<button id="AdminupdateBtn" onclick="Admin('${memberlist.email}','memberUpdate')" class="btn btn-sm">회원수정</button>
													<input type="hidden" name="name" value="${memberlist.name}" />
													<input type="hidden" name="email" value="${memberlist.email}" />
												</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:choose>
										<c:when test="${memberlist == null}">
											<tr>
												<td class="manager_td" colspan="4">현재 존재하는 회원 없음</td>
											</tr>
										</c:when>
									</c:choose>

								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/Template/Bottom.jsp" />