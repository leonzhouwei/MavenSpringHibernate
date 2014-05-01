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
	
	static String sendAndReceiveViaUDPSocket(String ip, int port, int timeoutMillis, String send) throws IOException {
		String received = null;
		DatagramSocket clientSocket = null;
		try {
			InetAddress addr = InetAddress.getByName(ip);
			byte[] sendData = send.getBytes();
			// send
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, addr, port);
			clientSocket = new DatagramSocket();
			clientSocket.setSoTimeout(timeoutMillis);
			clientSocket.send(sendPacket);
			// receive
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			clientSocket.receive(receivePacket);
			received = new String(receiveData, Constants.UTF_8);
		} finally {
			if (clientSocket != null) {
				clientSocket.close();
			}
		}
		return received;
	}
	
}
