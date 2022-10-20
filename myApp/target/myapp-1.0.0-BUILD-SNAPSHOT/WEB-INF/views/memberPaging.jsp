<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${memberInsert}">
	<script>
		alert("MemberRegister success!");
		location.href = "/Member/login.jsp";
	</script>
</c:if>
<c:choose>
	<c:when test="${memberlogin}">
		<script>
			alert("login success!");
			location.href = "/";
		</script>
	</c:when>
</c:choose>