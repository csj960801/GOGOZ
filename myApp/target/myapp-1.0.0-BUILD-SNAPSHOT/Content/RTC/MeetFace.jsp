<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/CustomFrameWork/style&js/js/RTC/playrtc.js"></script>
<script src="/CustomFrameWork/style&js/js/RTC/playrtc.min.js"></script>
<script src="/CustomFrameWork/style&js/js/RTC/ComponentFunction.js"></script>

<div class="row">
	<div class="col-md-12">
		<h1 class="page-header">Live Test</h1>
	</div>

	<div class="col-md-6 col-md-offset-3 hide">
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			...
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">

			<h2 class="h3">Profile/Config</h2>
			<h3 class="h4">User Id</h3>
			<form>
				<div class="form-group">
					<label class="sr-only" for="userId">User Id</label> <input
						class="form-control" type="text" id="userId"
						placeholder="Enter your user id." value="">
				</div>
			</form>

			<h2 class="h3">Channel</h2>
			<h3 class="h4">Create</h3>
			<form>
				<div class="from-gruop">
					<input class="form-control" type="text" id="createChannelId"
						placeholder="Create and connect the channel." value="" readonly="">
					<label class="sr-only" for="createChannelId">Channel Id</label>
				</div>
				<button class="btn btn-default btn-sm btn-block" id="createChannel">
					<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
					Create
				</button>
			</form>
			<button class="btn btn-default btn-sm btn-block"
				id="disconnectChannel">
				<span class="glyphicon glyphicon-stop" aria-hidden="true"></span>
				Disconnect
			</button>

			<h3 class="h4">Channel List</h3>
			<div class="list-group channel-list" id="channelList"></div>

			<button class="btn btn-default btn-sm pull-right" id="refreshChannel">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
				Refresh
			</button>
		</div>

		<div class="col-md-7">
			<h2 class="h3">Remote</h2>
			<div class="well">
				<video class="remote-video center-block" id="remoteVideo" controls></video>

				<div class="text-center hide">
					<button class="btn btn-default btn-sm" id="saveFileFromRemote">
						<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
						Save
					</button>
				</div>
			</div>

		</div>
		<div class="col-md-3">
			<h2 class="h3">Local</h2>
			<div class="well">
				<video class="local-video center-block" id="localVideo" muted
					controls></video>
				<div class="progress" id="sendFileToRemoteBarWrapper">
					<div class="progress-bar" id="sendFileToRemoteBar"
						role="progressbar" aria-valuenow="0" aria-valuemin="0"
						aria-valuemax="100" style="width: 0px;">
						<!--<span class="sr-only">60% Complete</span>-->
					</div>
				</div>
			</div>

			<div class="well chat-timeline" id="timeline" style="overflow: auto;"></div>

			<form>
				<label class="sr-only" for="sendMessage">Transfer Message</label>
				<div class="input-group input-group-sm">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</div>
					<input type="text" class="form-control" id="sendMessage"
						placeholder="Enter your message."> <span
						class="input-group-btn">
						<button class="btn btn-default" id="sendText">
							<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
							Send
						</button>
					</span>
				</div>
			</form>

			<form class="form-inline">
				<div class="row">
					<div class="col-md-8">
						<label class="sr-only" for="selectFile">Choose File</label> <input
							type="file" id="selectFile">
					</div>
					<div class="col-md-4">
						<button class="btn btn-default btn-xs pull-right" id="sendFile">
							<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
							Send
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>