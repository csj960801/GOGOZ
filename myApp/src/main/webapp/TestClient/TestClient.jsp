<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<c:if test="${sessionScope.loginName == null}">
	<script>
		alert("로그인 후 이용가능합니다.");
		window.location.href = "/MemberLogin/login.jsp";
	</script>
</c:if>
<div class="container">
	<div class="row">
		<div class="col-md-12 col-xs-12">
			<form id="TestfunctionFrm" name="TestfunctionFrm" class="form-group">
				<div class="portNum_wrapper">
					<dl class="port_dl">
						<dt class="port_dt">Owner로 부터 제공받으신 숫자를 입력해주세요</dt>
						<dd class="port_dd">
							<input type="password" name="portNum" id="clientportNum"
								class="form-control portNum" placeholder="서버에서 제공한 숫자 4자리">
						</dd>
						<dd class="port_dd">
							<button id="clientfunctionBtn" class="btn btn-primary">접속</button>
						</dd>
					</dl>
				</div>
			</form>
			<div id="serverPortGenerator_div">
				<ul class="portList">
					<c:forEach var="port" items="${serverport}">
						<c:forEach var="getPort" items="${port}">
							<li>${getPort.portNum}</li>
						</c:forEach>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/Template/Bottom.jsp" />