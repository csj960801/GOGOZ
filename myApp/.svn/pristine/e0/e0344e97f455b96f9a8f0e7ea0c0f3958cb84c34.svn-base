<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${selectList != null}">
	<div class="col-md-12 col-xs-12 table-responsive">
	<h3 class="boarder-list-title">현재 올라온 게시글</h3>
		<table class="table-hover table-bordered board-table table">
			<thead>
				<tr>
					<th>Num</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>게시글</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${selectList}" varStatus="status" var="BoardList">
						<!-- vo 값으로 입력하여주어야함 -->
						<td><c:out value="${status.count}" /></td>
						<td><c:out value="${BoardList.title}" /></td>
						<td><c:out value="${BoardList.writer}" /></td>
						<td><c:out value="${BoardList.date}" /></td>
						<td><c:out value="${BoardList.content}" /></td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>

</c:if>