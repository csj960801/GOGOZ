<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 로그인 5회 실패시 24시간 이용 불가능 
<c:if test="${cookie.loginFailIp.value != null}">
	<script type="text/javascript">
		window.onload = function() {
			var forbiddenIp = "${cookie.loginFailIp.value}";
			if (forbiddenIp != null) {
				alert(forbiddenIp + " 은 24시간 동안 서비스를 사용하실 수 없습니다.");
				self.close();
				return false;
			}
		};
	</script>
</c:if>
 -->