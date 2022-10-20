<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/Template/Top.jsp" />

<div class="Event_Popup hidden-xs"></div>
<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-xs-12 form-group main-title-wrapper">
				<form id="mainFrm" name="mainFrm">
					<!-- <h1 class="main-title">GoGoZ</h1> -->
					<h1 class="main-title"><img src="/Picture/BrandLogo/GoGoZ_2.png" class="img-responsive main_img"></h1>
					<div class="row banner_row">
						<div class="col-md-12 hidden-xs">
							<div class="main_banner_wrapper">
								<h2 class="introduce_h2">is Available in Entire of The
									Devices!</h2>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="contents-wrapper">
							<div class="col-md-6 col-xs-12 img_wrap">
								<c:if test="${sessionScope.adminSession != null && sessionScope.loginName == null}">
									<img src="/Picture/musicDown.jpg"
										class="img-responsive img-thumbnail" id="AdminUploader">
								</c:if>
								<c:choose>
									<c:when test="${sessionScope.adminSession == null && sessionScope.loginName != null}">
										<img src="/Picture/musicDown.jpg"
											class="img-responsive img-thumbnail" id="downloader">
									</c:when>
									<c:when test="${sessionScope.adminSession == null && sessionScope.loginName == null}">
								        <img src="/Picture/musicDown.jpg" class="img-responsive img-thumbnail" id="downloader-blocked">
									</c:when>
								</c:choose>
								<p class="main-content-p">MusicDownload</p>
							</div>

							<div class="clearfix visible-xs"></div>

							<div class="col-md-6 col-xs-12 img_wrap">
								<c:if test="${sessionScope.loginName != null}">
								    <img src="/Picture/live.jpg" class="img-responsive img-thumbnail" id="chanel">
								</c:if>
								<c:if test="${sessionScope.loginName == null}">
								    <img src="/Picture/live.jpg" class="img-responsive img-thumbnail" id="chanel-block">
								</c:if>		
								<p class="main-content-p">Live</p>
							</div>

						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="clearfix"></div>

	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />