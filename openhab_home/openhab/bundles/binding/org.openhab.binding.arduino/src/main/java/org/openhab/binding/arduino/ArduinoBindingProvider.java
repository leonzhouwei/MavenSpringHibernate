/**
 * Copyright (c) 2010-2014, openHAB.org and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.arduino;

import java.util.List;

import org.openhab.core.binding.BindingProvider;

/**
 * This interface is implemented by classes that can provide mapping information
 * between openHAB items and Arduino items.
 * 
 * Implementing classes should register themselves as a service in order to be
 * taken into account.
 * 
 * @author 
 * @since 
 */
public interface ArduinoBindingProvider extends BindingProvider {
	
	public ArduinoBindingConfig getBindingConfig(String itemName);
	
	public List<String> getPollItemNames();
	
}
