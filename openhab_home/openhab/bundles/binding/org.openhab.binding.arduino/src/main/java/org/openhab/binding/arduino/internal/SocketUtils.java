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
	
}
