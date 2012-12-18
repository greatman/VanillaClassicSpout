package org.greatmancode.vanillaclassic;

import org.greatmancode.vanillaclassic.configuration.VanillaClassicConfiguration;
import org.greatmancode.vanillaclassic.protocol.VanillaClassicProtocol;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.protocol.Protocol;

public class VanillaClassicPlugin extends CommonPlugin {

	private static VanillaClassicPlugin instance;
	private VanillaClassicConfiguration config;

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
