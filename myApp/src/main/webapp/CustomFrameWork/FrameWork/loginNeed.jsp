<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 회원이 아닐 경우  -->
<c:if test="${sessionScope.loginName == null}">
	<script type="text/javascript">
		alert("로그인을 하지 않을경우 사용할 수 없습니다.");
		window.location.href = "/";
	</script>
</c:if>