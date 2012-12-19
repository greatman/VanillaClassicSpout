/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2012, Greatman <http://www.github.com/greatman/>
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
package com.greatmancode.vanillaclassic.world.generator;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.greatmancode.vanillaclassic.VanillaClassicPlugin;
import com.greatmancode.vanillaclassic.world.generator.flat.FlatGenerator;

public final class VanillaClassicGenerators {
	public static final FlatGenerator FLAT = new FlatGenerator(5);
	private static final Map<String, VanillaClassicGenerator> BY_NAME = new HashMap<String, VanillaClassicGenerator>();

	private VanillaClassicGenerators() {

	}

	static {
		for (Field objectField : VanillaClassicGenerators.class.getDeclaredFields()) {
			objectField.setAccessible(true);
			try {
				final Object object = objectField.get(null);
				if (object instanceof VanillaClassicGenerator) {
					BY_NAME.put(objectField.getName().toLowerCase(), (VanillaClassicGenerator) object);
				}
			} catch (Exception ex) {
				VanillaClassicPlugin.getInstance().getLogger().log(Level.SEVERE, "Could not properly reflect VanillaClassicGenerators! Unexpected behaviour may occur, please report to greatman!", ex);
			}
		}
	}

	public static VanillaClassicGenerator byName(String name) {
		return BY_NAME.get(name.toLowerCase());
	}

	public static Collection<VanillaClassicGenerator> getGenerators() {
		return BY_NAME.values();
	}
}