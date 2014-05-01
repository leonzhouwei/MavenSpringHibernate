/**
 * Copyright (c) 2010-2014, openHAB.org and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.arduino.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openhab.binding.arduino.ArduinoBindingConfig;
import org.openhab.binding.arduino.ArduinoBindingProvider;
import org.openhab.core.binding.BindingConfig;
import org.openhab.core.items.Item;
import org.openhab.model.item.binding.AbstractGenericBindingProvider;
import org.openhab.model.item.binding.BindingConfigParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>This class can parse information from the generic binding format and 
 * provides Arduino binding information from it. It registers as a 
 * {@link ArduinoBindingProvider} service as well.</p>
 * 
 * <p>Here are some examples for valid binding configuration strings:
 * <ul>
 * </ul>
 * 
 * @author  
 * @since 
 */
public class ArduinoGenericBindingProvider extends AbstractGenericBindingProvider implements ArduinoBindingProvider {
	private static final Logger logger = LoggerFactory.getLogger(ArduinoGenericBindingProvider.class);
	
	/**
	 * {@inheritDoc}
	 */
	public String getBindingType() {
		return "arduino";
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void validateItemType(Item item, String bindingConfig) throws BindingConfigParseException {
		// we accept all types of items
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processBindingConfiguration(String context, Item item, String bindingConfig) throws BindingConfigParseException {
		super.processBindingConfiguration(context, item, bindingConfig);
		// addBindingConfig(item, customizedConfig);
		logger.info("oops: " + context + ", " + item.getName() + ", " + bindingConfig);
		logger.info("oops: arduino binding config parse start");
		try {
			ArduinoBindingConfigImpl config = ArduinoBindingConfigImpl.parse(bindingConfig);
			logger.info("oops: " + config.toString());
			if (config != null) {
				addBindingConfig(item, config);
				logger.info("oops: getBindingConfig(): " + item.getName() + " " + getBindingConfig(item.getName()));
			}
		} catch (Exception e) {
			logger.warn("", e);
		}
		logger.info("oops: arduino binding config parse end");
	}
	
	@Override
	public ArduinoBindingConfigImpl getBindingConfig(String itemName) {
		BindingConfig bc = bindingConfigs.get(itemName);
		ArduinoBindingConfigImpl abc = null;
		if (bc instanceof ArduinoBindingConfigImpl) {
			abc = (ArduinoBindingConfigImpl) bc;
		}
		return abc;
	}

	@Override
	public List<String> getPollItemNames() {
		List<String> ret = new ArrayList<String>();
		Collection<String> allNames = getItemNames();
		Iterator<String> it = allNames.iterator();
		while (it.hasNext()) {
			String name = it.next();
			ArduinoBindingConfig abc = getBindingConfig(name);
			if (abc != null && abc.canPoll()) {
				ret.add(name);
			}
		}
		return ret;
	}

}
