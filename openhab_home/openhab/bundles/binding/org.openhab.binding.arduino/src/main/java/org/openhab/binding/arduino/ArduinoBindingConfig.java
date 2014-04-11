package org.openhab.binding.arduino;

import org.openhab.core.binding.BindingConfig;

public interface ArduinoBindingConfig extends BindingConfig {

	public String getIp();

	public int getPort();

	public String getDeviceName();

	public int getPollingPeriod();
	
	public boolean canPoll();
	
}
