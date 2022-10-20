package com.function.Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientSocket {

	private static Logger clientsocketlog = LoggerFactory.getLogger(ClientSocket.class);
	private Socket Clientsocket;
	private InetAddress clientinfo;

	/**
	 * 매게변수로 접속할 포트를 입력받고 클라이언트 호스트 출력
	 * 
	 * @param port
	 * @return
	 */
	public String clientAddress(int port) {
		String clientportinfo = "";
		try {
			Clientsocket = new Socket("localhost", port);
			// client소켓 inputstream
			InputStream streamreader = Clientsocket.getInputStream();
			// client소켓에 outputstream
			OutputStream streamwriter = Clientsocket.getOutputStream();

			clientinfo = Clientsocket.getLocalAddress();
			clientportinfo = clientinfo.getHostName();

			clientsocketlog.info("=========================");
			clientsocketlog.info(clientinfo + "접속했습니다!");
			clientsocketlog.info("=========================");

		} catch (Exception e) {
			clientsocketlog.info("=========================");
			clientsocketlog.info("클라이언트 소켓예외: " + e.toString());
			clientsocketlog.info("=========================");
		}

		return clientportinfo;
	}

}