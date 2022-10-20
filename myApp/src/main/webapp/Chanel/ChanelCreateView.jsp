<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginForbidden.jsp" />

<div class="Chanel-main">
	<div class="content-title">
		<h2 class="content-menu-h2">ChanelCreate</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>Chanel</li>
			<li>ChanelCreate</li>
		</ol>
	</div>
	<div class="container chanel_container">
		<div class="row chanel_container">
			<div class="col-md-12- col-xs-12 form-group">
				<div class="CreateChanel_wrapper">
					<form id="chanelCreateFrm" name="chanelCreateFrm">
						<div class="ChenalCreate_wrapper">
							<label class="chanel_label" for="chanel_label">채널생성</label>
							<input type="password" class="form-control chanelCreateForm" name="chanel" autocomplete="off"/>
							<p class="chanel_p">
								<span class="chanel_span">* 생성하실 4자리의 채널번호를 입력해주세요.</span>
							</p>
						</div>
						<input type="hidden" name="chanelMaker" class="chanelMaker" value="${sessionScope.loginName}"/>
					</form>
			    </div>	
				
				<div class="clearfix"></div>
				
				<div class="ChanelListFrm_wrapper">
				<h3 class="chanelList_h3">채널을 알고계시나요?</h3>
					<form id="ChanelListFrm" name="ChanelListFrm">
						<div class="ChenalCreate_wrapper">
							<label class="chanel_label" for="chanel_label">채널검색</label>
							<input type="password" class="form-control chanelFindForm" name="chanel" autocomplete="off"/>
							<p class="chanel_p">
								<span class="chanel_span">* 검색하실 4자리의 채널번호를 입력해주세요.</span>
							</p>
						</div>
					</form>
			    </div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />