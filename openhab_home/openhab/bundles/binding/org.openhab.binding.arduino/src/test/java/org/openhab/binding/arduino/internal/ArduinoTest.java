package org.openhab.binding.arduino.internal;

public class ArduinoTest {
	public static void main(String[] args) {
		char[] msg = { '1', '2', ':', '0' };
		controlLight(msg);
	}

	static void controlLight(char[] msg) {
		int index = -1;
		int len = msg.length;
		for (int i = 0; i < len; ++i) {
			if (msg[i] == ':') {
				index = i;
				break;
			}
		}
		if (index > 0 && (len - 1) > index) {
			int number = msg[0] - '0';
			number = number % 10;
			for (int i = 1; i < index; ++i) {
				int j = msg[i] - '0';
				j = j % 10;
				number = number * 10 + j;
			}
			if (number > 1 && number < 14) {
				if (msg[len - 1] == '0') {
					System.out.println(number + " LOW");
				} else if (msg[len - 1] == '1') {
					System.out.println(number + " HIGH");
				} else {
					// no operations
				}
			}
		}
	}
}
