package org.openhab.binding.arduino.internal;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SocketUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void testSendViaUDPSocket() throws IOException {
		final String ip = "localhost";
		final int port = 8081;
		final String data = "led13:0";
		SocketUtils.sendViaUDPSocket(ip, port, data);
	}
	
//	@Test
	public void testSendViaTimeoutUDPSocket() throws IOException {
		final String ip = "localhost";
		final int port = 8081;
		final String data = "temperature";
		String receive = SocketUtils.sendAndReceiveViaUDPSocket(ip, port, 5000, data);
		System.out.println(receive);
	}

}
