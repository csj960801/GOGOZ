<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${login}">
	<script>
		alert("로그인 성공");
		window.location.href = "/";
	</script>
</c:if>
<c:choose>
	<c:when test="${!login}">
		<script>
			alert("존재하지않는 계정입니다.");
			history.back();
		</script>
	</c:when>
</c:choose>

<div class="success_wrapper">${Data}</div>