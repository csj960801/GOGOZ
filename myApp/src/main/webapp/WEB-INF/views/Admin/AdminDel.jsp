<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${admindel == 1}">
	<script type="text/javascript">
		alert("게시글 삭제완료");
		window.location.href = "/";
	</script>
</c:if>
<c:if test="${admindel == 2}">
	<script type="text/javascript">
		alert("회원 삭제완료");
		window.location.href = "/";
	</script>
</c:if>