<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${UploadSuccess}">
	<script>
		alert('음악다운로더로딩 성공!');
		window.location.href = '/';
	</script>
</c:if>
