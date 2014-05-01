package org.openhab.binding.arduino.internal;

import java.io.IOException;

import org.openhab.binding.arduino.ArduinoBindingConfig;
import org.openhab.core.events.EventPublisher;
import org.openhab.core.library.types.DecimalType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class BackgroundService {
	
	private static final Logger logger = LoggerFactory.getLogger(BackgroundService.class);
	
	private String itemName;
	private ArduinoBindingConfig abc;
	private EventPublisher ep;
	private Thread thread;
	
	BackgroundService(String itemName, ArduinoBindingConfig abc, EventPublisher ep) {
		this.itemName = itemName;
		this.abc = abc;
		this.ep = ep;
	}
	
	synchronized void start() {
		if (thread != null) {
			return;
		}
		Runnable r = new Runnable() {
			@Override
			public void run() {
				String ip = abc.getIp();
				int port = abc.getPort();
				String send = abc.getDeviceName();
				try {
					String receive = SocketUtils.sendAndReceiveViaUDPSocket(ip, port, send, 5000);
					if (receive != null) {
						receive = receive.trim();
						DecimalType newState = new DecimalType(receive);
						ep.postUpdate(itemName, newState);
					}
				} catch (IOException e) {
					logger.warn("", e);
				}
				pause();
			}
		};
		thread = new Thread(r);
		thread.setDaemon(true);
		thread.start();
	}
	
	private void pause() {
		try {
			Thread.sleep(abc.getPollingPeriod());
		} catch (InterruptedException e) {
		}
	}

}
