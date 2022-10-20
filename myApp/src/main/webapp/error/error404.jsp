<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/Template/Top.jsp" />

<!-- 404error Handler -->
<div class="error404">
	<div class="group-container container-fluid">
		<div class="group-row row">
			<div class="group-col col-md-12 col-xs-12">
				<section class="error-sector">
					<label for="error-label">sorry, 404 Error Encountered..</label>
				</section>

				<div class="clearfix"></div>

				<section class="error-resolve">
					<dl class="error-dl">
						<dt class="error-dt">Try these ways</dt>
						<%
							String wayExplain = "";
							for (int wayCnt = 1; wayCnt <= 3; wayCnt++) {
								if (wayCnt == 1) {
									wayExplain = "ShutDown This WebApp and then Retry.";
								} else if (wayCnt == 2) {
									wayExplain = "Check out your Network.";
								} else if (wayCnt == 3) {
									wayExplain = "Probably Main Server has ploblem";
								}
						%>
						<dd class="error-dd">
							<strong><%=wayCnt%>.</strong><%=wayExplain%></dd>
						<%
							}
						%>
					</dl>
				</section>
			</div>
		</div>
	</div>
</div>