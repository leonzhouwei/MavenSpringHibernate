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
		logger.warn("oops: " + eventPublisher);
		this.eventPublisher = eventPublisher;
		this.abp = abp;
	}
	
	public void start() {
		synchronized (this) {
			if (thread == null) {
				Runnable r = new Runnable() {
					@Override
					public void run() {
						// find the items demanding polling
						List<String> names = abp.getPollItemNames();
						for (String name : names) {
							logger.warn("oops: " + name + ", " + abp.getBindingConfig(name).toString());
							BackgroundService bs = new BackgroundService(name, abp.getBindingConfig(name), eventPublisher);
							bs.start();
						}
					}
				};
				thread = new Thread(r);
				thread.start();
				logger.warn("oops: background service master started");
			}	
		}
	}

}
