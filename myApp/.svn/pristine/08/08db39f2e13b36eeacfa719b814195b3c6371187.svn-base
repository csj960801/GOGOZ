<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${MemberReg}">
	<script>
		alert("회원가입 정상적으로 완료되었습니다!");
		window.location.href = "/MemberLogin/login.jsp";
	</script>
</c:if>
<c:choose>
	<c:when test="${duplicated}">
		<script>
			alert("현재 존재하는 회원명입니다.");
			history.back();
		</script>
	</c:when>
</c:choose>
<div class="success_wrapper">${Data}</div>