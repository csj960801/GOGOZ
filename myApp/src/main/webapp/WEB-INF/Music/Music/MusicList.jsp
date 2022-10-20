<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />

<c:if test="${duplicated}">
	<script>
		alert("중복되어 올라온 곡이 있습니다!");
		history.back();
	</script>
</c:if>
<c:choose>
	<c:when test="${!duplicated && musicData > 0}">
		<script>
			alert("업로드되었습니다.");
		</script>
	</c:when>
    <c:when test="${sessionScope.loginName == null}">
     <script>
		alert("로그인 후 이용가능합니다.");
		window.location.href = "/MemberLogin/login.jsp";
	 </script>
 </c:when>
</c:choose>

<div class="content-title">
	<h2 class="content-menu-h2">MusicDownloader</h2>
	<ol class="breadcrumb content-title-breadcrumb">
		<li>Music</li>
		<li>MusicDownloader</li>
	</ol>
</div>

<div class="MusicDownLoader_Wrapper">
	<div class="container">
		<div class="row music_row">
			<div class="col-md-12 col-xs-12 table-responsive">
					<table class="table musicTbl">
						<thead class="musicTblHead">
							<tr>
								<th>CNT</th>
								<th>올린이</th>
								<th>올린날짜</th>
								<th>음악명</th>
							</tr>
						</thead>
						<tbody class="musicTblBody">
							<c:if test="${musicList.size() == 0}">
								<tr>
									<td colspan="3"><h3 class="no_uploadAlert">현재 업로드된 파일이 존재하지않습니다!</h3></td>
								</tr>
							</c:if>
							<c:choose>
								<c:when test="${musicList.size() > 0}">
									<c:forEach items="${musicList}" var="music">
										<c:forEach items="${music}" varStatus="status" var="musiclist">
										<tr>
											<td>${status.count}</td>						
										    <td>${musiclist.uploader}</td>						
											<td>${musiclist.uploadDate}</td>
											<td id="form_parent_td">
											<a href="javascript:multiPartForm('${musiclist.uploadMusic}')"
												class="musicTitle" class="btn btn-primary">${musiclist.uploadMusic}
											</a>
											</td>
										</tr>
										</c:forEach>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>
					</table>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/Template/Bottom.jsp" />