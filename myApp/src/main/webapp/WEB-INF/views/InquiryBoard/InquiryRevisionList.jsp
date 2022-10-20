<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<c:if test="${sessionScope.loginName == null}">
	<script>
		alert("로그인을 하지 않을경우 사용할 수 없습니다.");
		window.location.href = "/";
	</script>
</c:if>
<body>
	<div class="container">
		<div class="row manager_row">
			<div class="col-xs-12 col-md-12 form-group">
				<div class="manager_tbl_wrapper table-responsive">
					<form id="InquiryBoardFrm" name="InquiryBoardFrm">
						<h3 class="manager_title"><span class="title_span">${sessionScope.loginName}</span> 회원님이 작성하신 게시글 정보</h3>
						<table class="table manager_table table-hover">
							<colgroup>
								<col width="150px" />
								<col width="200px" />
								<col width="180px" />
								<col width="300px" />
							</colgroup>
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>날짜</th>
									<th>내용</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${memberBoardList != null}">
									<c:forEach varStatus="status" var="list" items="${memberBoardList}">
										<tr class="manager_tr">
											<td class="manager_td">${status.count}</td>
											<td class="manager_td">${list.title}</td>
											<td class="manager_td">${list.writer}</td>
											<td class="manager_td">${list.date}</td>
											<td class="manager_td">
												<a href="javascript:inquiryRevisionResolver('${list.content}');" class="inquirylist_update">${list.content}</a>
											    <input type="hidden" class="inquirylist_update_data" value="${list.content}"/>
											</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:choose>
									<c:when test="${memberBoardList == null}">
										<tr>
											<td class="manager_td" colspan="4">현재 데이터 없음</td>
										</tr>
									</c:when>
								</c:choose>

							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<c:if test="${inquirySuccess > 0}">
	<script>
		alert("게시글 수정 완료 했습니다.");
		window.location.href = "/";
	</script>
</c:if>

<jsp:include page="/Template/Bottom.jsp" />