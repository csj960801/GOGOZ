<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/Template/Top.jsp" />
<div class="main">
	<div class="content-title">
		<h2 class="content-menu-h2">ChanelList</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>&nbsp;</li>
		</ol>
	</div>
	<div class="container chanel_container">
		<div class="row chanel_row">
			<div class="chanel_wrapper table-responsive form-group">
				<table class="table chanellist_tbl">
					<colgroup>
						<col width="15%" />
						<col width="45%" />
						<col width="40%" />
					</colgroup>
					<thead class="chanellist_thead">
						<tr>
							<th>no</th>
							<th>채널생성자</th>
							<th>채널</th>
						</tr>
					</thead>
					<tbody class="chanellist_tbody">
						<c:if test="${chanelList != null}">
							<c:forEach var="chanelList" varStatus="status" items="${chanelList}">
								<tr>
									<td>${status.count}</td>
									<td>${chanelList.chanelMaker}</td>
									<td><a href="#" class="chanellist_tab">${chanelList.chanel}</a></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:choose>
							<c:when test="${chanelList == null}">
								<tr>
									<td colspan="3">생성된 채널이 존재하지않습니다.</td>
								</tr>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/Template/Bottom.jsp" />