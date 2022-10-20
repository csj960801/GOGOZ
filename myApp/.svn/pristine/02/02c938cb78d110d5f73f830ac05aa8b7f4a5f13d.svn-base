/**
 * 
 */

var createChannelButton = document.querySelector('#createChannel');
var createChannelIdInput = document.querySelector('#createChannelId');
var refreshChannelButton = document.querySelector('#refreshChannel');
var channelList = document.querySelector('#channelList');
var getChannelList;
var disconnectChannelButton = document.querySelector('#disconnectChannel');
var chattingTimeline = document.querySelector('#timeline');
var sendMessageInput = document.querySelector('#sendMessage');
var selectFileInput = document.querySelector('#selectFile');
var sendTextButton = document.querySelector('#sendText');
var sendFileButton = document.querySelector('#sendFile');
var sendFileToRemoteBar = document.querySelector('#sendFileToRemoteBar');
var sendFileToRemoteBarWrapper = document
		.querySelector('#sendFileToRemoteBarWrapper');
var remoteVideo = document.querySelector('#remoteVideo');
var userIdInput = document.querySelector('#userId');
var userId;
var app;

app = new PlayRTC({
	projectKey : '60ba608a-e228-4530-8711-fa38004719c1',
	localMediaTarget : 'localVideo',
	remoteMediaTarget : 'remoteVideo',
	video : true,
	audio : true
});

getChannelList = function() {
	app.getChannelList(function(result) {
		var channels = result.channels;
		var channelsLength = channels.length;

		while (channelList.hasChildNodes()) {
			channelList.removeChild(channelList.firstChild);
		}

		for (var i = 0; i < channelsLength; i++) {
			var channelListAnchor = document.createElement('a');
			var linkIcon = document.createElement('span');

			channelListAnchor.classList.add('list-group-item');
			channelListAnchor.setAttribute('data-channelid',
					channels[i].channelId);
			channelListAnchor.textContent = channels[i].channelId;

			linkIcon.classList.add('glyphicon', 'glyphicon-menu-right',
					'pull-right');
			linkIcon.setAttribute('aria-hidden', 'true');

			channelListAnchor.appendChild(linkIcon);

			channelList.appendChild(channelListAnchor);
		}
	});
}

getChannelList();

app.on('connectChannel', function(channelId) {
	createChannelIdInput.value = channelId;
	getChannelList();
});

app.on('disconnectChannel', function(channelId) {
	createChannelIdInput.value = '';

	while (chattingTimeline.hasChildNodes()) {
		chattingTimeline.removeChild(chattingTimeline.firstChild);
	}

	getChannelList();
});

app.on('otherDisconnectChannel', function(channelId) {
	remoteVideo.src = '';

	while (chattingTimeline.hasChildNodes()) {
		chattingTimeline.removeChild(chattingTimeline.firstChild);
	}

	getChannelList();
});

app.on("stateChange", function(state, pid, uid) {
	/*
	 * if (state == "CONNECTED") { app.getMedia().record();
	 * 
	 * var peers = app.getAllPeer(); var peer =
	 * app.getPeerByPeerId(peers[0].id); peer.getMedia().record(); } else
	 * if(state == "CLOSED"){ app.getMedia().recordStop(function(blob){
	 * PlayRTC.utils.fileDownload(blob, "local.wav"); });
	 * 
	 * app.getPeerByPeerId(pid).getMedia().recordStop(function(blob){
	 * PlayRTC.utils.fileDownload(blob, "remote.wav"); }); }
	 */
});

app.on('addDataStream', function(pid, uid, dataChannel) {
	dataChannel.on('message', function(message) {
		var chatParagraph;

		if (message.type === 'text') {
			chatParagraph = document.createElement('p');
			chatParagraph.classList.add('local');
			chatParagraph.textContent = message.data;

			chattingTimeline.appendChild(chatParagraph);
		} else if (message.type === 'file') {
			PlayRTC.utils.fileDownload(message.blob, message.fileName);
			sendFileToRemoteBar.style.width = '0px';
		}
	});

	dataChannel.on('progress',
			function(message) {
				var width = sendFileToRemoteBarWrapper.clientWidth;
				var progressbar = (width / message.fragCount)
						* (message.fragIndex + 1);

				if (message.totalSize === message.fragSize) {
					return;
				}

				sendFileToRemoteBar.style.width = progressbar + 'px';
			});

	dataChannel.on('error', function(event) {
		alert('ERROR. See the log.');
	});
});

refreshChannelButton.addEventListener('click', function(event) {
	event.preventDefault();
	getChannelList();
}, false);

channelList.addEventListener('click', function(event) {
	var channelId = event.target.dataset.channelid;

	userId = userIdInput.value;

	app.connectChannel(channelId, {
		peer : {
			uid : userId
		}
	});

}, false);

createChannelButton.addEventListener('click', function(event) {
	event.preventDefault();

	userId = userIdInput.value;

	app.createChannel({
		peer : {
			uid : userId
		}
	})

}, false);

disconnectChannelButton.addEventListener('click', function(event) {
	event.preventDefault();
	app.deleteChannel();
}, false);

sendTextButton.addEventListener('click', function(event) {
	var chatParagraph;
	var message = sendMessageInput.value;

	event.preventDefault();

	if (message) {
		app.sendText(message);

		chatParagraph = document.createElement('p');
		chatParagraph.classList.add('remote');
		chatParagraph.textContent = message;

		chattingTimeline.appendChild(chatParagraph);
	}
	sendMessageInput.value = '';
}, false);

sendFileButton.addEventListener('click', function(event) {
	var myFile = selectFileInput.files[0];

	event.preventDefault();

	if (!myFile) {
		return false;
	}
	app.sendFile(myFile);
	selectFileInput.value = '';
}, false);
