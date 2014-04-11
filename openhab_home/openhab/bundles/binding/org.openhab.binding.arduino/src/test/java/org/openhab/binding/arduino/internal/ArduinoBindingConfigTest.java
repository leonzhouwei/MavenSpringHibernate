package org.openhab.binding.arduino.internal;

import org.junit.Assert;
import org.junit.Test;

public class ArduinoBindingConfigTest {

	@Test
	public void testParse() {
		final String expected = "127.0.0.1:8081:led13";
		final String actual = ArduinoBindingConfigImpl.parse(expected).toString();
		Assert.assertEquals(expected, actual);
	}

}
