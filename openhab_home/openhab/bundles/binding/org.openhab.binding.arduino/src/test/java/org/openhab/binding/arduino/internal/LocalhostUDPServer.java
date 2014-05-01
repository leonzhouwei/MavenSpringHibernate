package org.openhab.binding.arduino.internal;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class LocalhostUDPServer {
	
	public static void main(String[] args) {
		DatagramSocket serverSocket = null;
		try {
			serverSocket = new DatagramSocket(8081);
			System.out.println("server established at " + serverSocket.getLocalSocketAddress());
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			while (true) {
				zeroBytes(receiveData);
				zeroBytes(sendData);
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				serverSocket.receive(receivePacket);
				String sentence = new String(receivePacket.getData(), Constants.UTF_8);
				InetAddress addr = receivePacket.getAddress();
				int port = receivePacket.getPort();
				System.out.println("RECEIVED: " + sentence);
				String result = process(sentence);
				if (result != null) {
					sendData = result.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData,
							sendData.length, addr, port);
					serverSocket.send(sendPacket);	
				}
			}
		} catch (Exception e) {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}
	}
	
	private static String process(String data) {
		data = data.trim();
		
		if (data.startsWith("led")) {
			return null;
		}
		
		if (data.startsWith("temperature")) {
			return "temperature:25";
		}
		
		return null;
	}
	
	private static void zeroBytes(byte[] bytes) {
		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = 0;
		}
	}
}
