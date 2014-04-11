package org.openhab.binding.arduino.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class UDPClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		System.out.println("client socket established at " + clientSocket.getLocalSocketAddress());
		InetAddress addr = InetAddress.getByName("192.168.1.177");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, addr, 8888);
		clientSocket.send(sendPacket);
//		DatagramPacket receivePacket = new DatagramPacket(receiveData,
//				receiveData.length);
//		clientSocket.receive(receivePacket);
//		String modifiedSentence = new String(receivePacket.getData());
//		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}

}
