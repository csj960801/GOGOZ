<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${update}">
	<script>
		alert("수정완료되었습니다!");
		window.location.href = "/";
	</script>
</c:if>
<c:choose>
	<c:when test="${!update}">
		<script>
			alert("존재하지않는 이메일 입니다.");
			history.back();
		</script>
	</c:when>
</c:choose>