<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${del}">
	<script>
		alert("회원탈퇴가 성공적으로 완료되었습니다. 그동안 이용해주셔서 감사합니다!");
		window.location.href = "/";
	</script>
</c:if>
<c:choose>
	<c:when test="${!del}">
		<script>
			alert("존재하지않는 Email입니다!");
			history.back();
		</script>
	</c:when>
</c:choose>