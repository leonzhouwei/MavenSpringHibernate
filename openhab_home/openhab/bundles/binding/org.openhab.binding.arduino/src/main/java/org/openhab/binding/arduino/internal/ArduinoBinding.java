/**
 * Copyright (c) 2010-2014, openHAB.org and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.arduino.internal;

import org.openhab.binding.arduino.ArduinoBindingConfig;
import org.openhab.binding.arduino.ArduinoBindingProvider;
import org.openhab.core.binding.AbstractBinding;
import org.openhab.core.binding.BindingProvider;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.types.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author 
 * @since 
 */
public class ArduinoBinding extends AbstractBinding<ArduinoBindingProvider> {

	private static final Logger logger = LoggerFactory.getLogger(ArduinoBinding.class);
	
	private static final String SEPARATOR = ":";
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public void internalReceiveCommand(String itemName, Command command) {
		try {
			if (command instanceof OnOffType) {
				controlLight(itemName, (OnOffType) command);
			}
		} catch (Exception e) {
			logger.warn("", e);
		}
	}

	private void controlLight(String itemName, OnOffType command) {
		// get the binding config
		ArduinoBindingConfig abc = getBindingConfig(itemName);
		if (abc == null) {
			return;
		}
		logger.warn("oops: " + itemName + ", " + abc.toString() + ", " + command);
		// prepare the data
		final String ip = abc.getIp();
		final int port = abc.getPort();
		StringBuilder sb = new StringBuilder();
		sb.append(abc.getDeviceName());
		sb.append(SEPARATOR);
		if (command == OnOffType.OFF) {
			sb.append("0");
		} else if (command == OnOffType.ON) {
			sb.append("1");
		} else {
			// no operations
		}
		final String data = sb.toString();
		logger.info("oops: will send to " + ip + ":" + port + " udp containing data '" + data + "'");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					SocketUtils.sendViaUDPSocket(ip, port, data);
				} catch (Exception e) {
					logger.warn("", e);
				}
			}
		};
		Thread thread = new Thread(r);
		thread.start();
	}
	
	ArduinoBindingConfig getBindingConfig(String itemName) {
		ArduinoBindingConfig abc = null;
		for (BindingProvider bp : providers) {
			if (bp instanceof ArduinoBindingProvider) {
				ArduinoGenericBindingProvider agbp = (ArduinoGenericBindingProvider) bp;
				abc = agbp.getBindingConfig(itemName);
			}
		}
		return abc;
	}
	
	@Override
	public void allBindingsChanged(BindingProvider provider) {
		for (BindingProvider bp : providers) {
			if (bp instanceof ArduinoBindingProvider) {
				ArduinoBindingProvider abp = (ArduinoBindingProvider) bp;
				BackgroundServiceMaster master = new BackgroundServiceMaster(abp, eventPublisher);
				master.start();
			}
		}
	}
	
}
