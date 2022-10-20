<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${chanelMap > 0}">
	<script type="text/javascript">
		alert("채널 생성 되었습니다.");
	</script>
</c:if>
<c:if test="${chanelMap == -1}">
	<script type="text/javascript">
		alert("채널 중복 되었습니다.");
	</script>
</c:if>