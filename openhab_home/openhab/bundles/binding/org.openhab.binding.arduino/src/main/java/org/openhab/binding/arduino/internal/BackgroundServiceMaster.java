package org.openhab.binding.arduino.internal;

import java.util.List;

import org.openhab.binding.arduino.ArduinoBindingProvider;
import org.openhab.core.events.EventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class BackgroundServiceMaster {
	
	private static final Logger logger = LoggerFactory.getLogger(BackgroundServiceMaster.class);
	
	private EventPublisher eventPublisher;
	private ArduinoBindingProvider abp; 
	private Thread thread;
	
	public BackgroundServiceMaster(ArduinoBindingProvider abp, EventPublisher eventPublisher) {
		logger.warn("oops");
		this.eventPublisher = eventPublisher;
		this.abp = abp;
	}
	
	public void start() {
		synchronized (this) {
			if (thread == null) {
				Runnable r = new Runnable() {
					@Override
					public void run() {
						while (true) {
							if (abp.isBindingConfigProcessDone() == true) {
								break;
							}
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						// find the items demanding polling
						List<String> names = abp.getPollItemNames();
						for (String name : names) {
							logger.warn("oops: " + name + ", " + abp.getBindingConfig(name).toString());
						}
					}
				};
				thread = new Thread(r);
				thread.start();
			}	
		}
	}

}
