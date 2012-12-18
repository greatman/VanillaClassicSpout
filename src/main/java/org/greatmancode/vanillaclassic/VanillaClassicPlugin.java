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
package org.greatmancode.vanillaclassic;

import org.greatmancode.vanillaclassic.configuration.VanillaClassicConfiguration;
import org.greatmancode.vanillaclassic.protocol.VanillaClassicProtocol;

import org.spout.api.plugin.CommonPlugin;
import org.spout.api.protocol.Protocol;

public class VanillaClassicPlugin extends CommonPlugin {
	private static VanillaClassicPlugin instance;
	private VanillaClassicConfiguration config;
	public static final String salt = "98h87qwdgauisgd87asd"; //TODO: Need to random that
	@Override
	public void onEnable() {
		config.load();
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoad() {
		instance = this;
		config = new VanillaClassicConfiguration(getDataFolder());
		Protocol.registerProtocol(new VanillaClassicProtocol());
	}

	public static VanillaClassicPlugin getInstance() {
		return instance;
	}

	public VanillaClassicConfiguration getConfig() {
		return config;
	}
}
