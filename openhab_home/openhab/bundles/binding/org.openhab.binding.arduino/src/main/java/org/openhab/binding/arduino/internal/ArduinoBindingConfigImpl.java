package org.openhab.binding.arduino.internal;

import org.openhab.binding.arduino.ArduinoBindingConfig;

public final class ArduinoBindingConfigImpl implements ArduinoBindingConfig {
	private static final String separator = ":";
	
	private String ip;
	private int port;
	private String deviceName;
	private int pollingPeriod = -1; // mills
	
	public static ArduinoBindingConfigImpl parse(String string) {
		String[] frags = string.split(separator);
		int port = Integer.parseInt(frags[1]);
		int pollPeriod = -1;
		if (frags.length == 4) {
			pollPeriod = Integer.parseInt(frags[3]);
		}
		ArduinoBindingConfigImpl config = new ArduinoBindingConfigImpl(frags[0], port, frags[2], pollPeriod);
		return config;
	}
	
	public ArduinoBindingConfigImpl(String ip, int port, String deviceName, int pollingPeriod) {
		this.ip = ip;
		this.port = port;
		this.deviceName = deviceName;
		this.pollingPeriod = pollingPeriod;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public int getPollingPeriod() {
		return pollingPeriod;
	}
	
	public boolean canPoll() {
		return pollingPeriod > 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ip);
		sb.append(separator);
		sb.append(port);
		sb.append(separator);
		sb.append(deviceName);
		if (canPoll()) {
			sb.append(separator);
			sb.append(pollingPeriod);
		}
		return sb.toString();
	}

}
