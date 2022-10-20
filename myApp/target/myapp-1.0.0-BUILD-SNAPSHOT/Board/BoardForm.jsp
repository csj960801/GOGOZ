<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/Template/Top.jsp" />

<div class="board-wrapper">
	<div class="content-title">
		<h2 class="content-menu-h2">Board</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>Board</li>
			<li>BoardForm</li>
		</ol>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="table-responsive form-group">
					<p class="text-center notice-p">게시글을 지우시려면 게시글을 더블클릭해주세요</p>
					<table class="table board-table table-hover table-striped">
						<tbody>
							<tr>
								<th>제목</th>
								<td><input type="text" id="b-title" name="title" class="form-control" /></td>
							</tr>
							<tr>
								<th>게시자명</th>
								<td><input type="text" id="b-name" name="writer" class="form-control" /></td>
							</tr>
							<tr>
								<th>게시날짜</th>
								<td><input type="date" id="b-date" name="date" class="form-control" /></td>
							</tr>
							<tr>
								<th>게시글</th>
								<td><textarea cols="30" rows="20" name="content" id="b-content" class="form-control">
								</textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<button id="boardBtn" class="btn btn-success">게시글업로드</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="BoardResult-div"></div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />