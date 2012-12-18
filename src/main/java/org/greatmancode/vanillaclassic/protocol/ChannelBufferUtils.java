/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2011-2012, Greatman <http://github.com/greatman/>
 * VanillaClassic is licensed under the SpoutDev License Version 1.
 *
 * VanillaClassic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * VanillaClassic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
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
