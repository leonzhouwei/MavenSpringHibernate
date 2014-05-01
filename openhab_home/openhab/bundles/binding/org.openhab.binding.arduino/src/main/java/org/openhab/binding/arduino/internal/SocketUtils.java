package org.openhab.binding.arduino.internal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

final class SocketUtils {
	
	static void sendViaUDPSocket(final String ip, final int port, final String data) throws IOException {
		InetAddress addr = InetAddress.getByName(ip);
		byte[] sendData = data.getBytes();
		// send udp
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, addr, port);
		DatagramSocket clientSocket = new DatagramSocket();
		clientSocket.send(sendPacket);
		clientSocket.close();
	}
	
	static String sendAndReceiveViaUDPSocket(String ip, int port, String send, int timeout) throws IOException {
		DatagramSocket clientSocket = null;
		try {
			InetAddress addr = InetAddress.getByName(ip);
			byte[] sendData = send.getBytes();
			// send
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, addr, port);
			clientSocket = new DatagramSocket();
			clientSocket.setSoTimeout(timeout);
			clientSocket.send(sendPacket);
			// receive
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			clientSocket.receive(receivePacket);
		} finally {
			if (clientSocket != null) {
				clientSocket.close();
			}
		}
		return null;
	}
	
}
