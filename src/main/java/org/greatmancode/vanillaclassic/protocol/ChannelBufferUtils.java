package org.greatmancode.vanillaclassic.protocol;

import org.jboss.netty.buffer.ChannelBuffer;

public class ChannelBufferUtils {

	public final static int STRING_LENGTH = 64;
	public static String readString(ChannelBuffer buf) {

		char[] characters = new char[STRING_LENGTH];
		for (int i = 0; i < 64; i++) {
			characters[i] = buf.readChar();
		}

		return new String(characters);
	}
	
	public static void writeString(ChannelBuffer buf, String str) {
		for (int i = 0; i < STRING_LENGTH; i++) {
			if (str.length() < i) {
				buf.writeChar(0x20);
			} else {
				buf.writeChar(str.charAt(i));
			}
		}
	}
}
