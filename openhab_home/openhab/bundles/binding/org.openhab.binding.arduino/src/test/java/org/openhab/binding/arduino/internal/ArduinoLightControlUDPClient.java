package org.openhab.binding.arduino.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class ArduinoLightControlUDPClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		System.out.println("client socket established at " + clientSocket.getLocalSocketAddress());
		InetAddress addr = InetAddress.getByName("192.168.1.177");
		byte[] sendData = new byte[1024];
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, addr, 8888);
		clientSocket.send(sendPacket);
		clientSocket.close();
	}

}
