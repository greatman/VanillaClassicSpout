package org.greatmancode.vanillaclassic.configuration;

import java.io.File;
import java.util.logging.Level;

import org.greatmancode.vanillaclassic.VanillaClassicPlugin;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class VanillaClassicConfiguration extends ConfigurationHolderConfiguration {

	public VanillaClassicConfiguration(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}
	
	@Override
	public void load() {
		try {
			super.load();
			super.save();
		}
		catch (ConfigurationException e) {
			VanillaClassicPlugin.getInstance().getLogger().log(Level.WARNING, "Error loading VanillaClassic configuration: ", e);
			
		}
	}
	
	@Override
	public void save() {
		try {
			super.save();
		} catch (ConfigurationException e) {
			VanillaClassicPlugin.getInstance().getLogger().log(Level.WARNING, "Error saving VanillaClassic configuration: ", e);
		}
	}
}
