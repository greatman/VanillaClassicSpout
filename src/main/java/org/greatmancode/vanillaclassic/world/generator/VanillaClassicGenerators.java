package org.greatmancode.vanillaclassic.world.generator;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.greatmancode.vanillaclassic.world.generator.flat.FlatGenerator;

public class VanillaClassicGenerators {
	public static final FlatGenerator FLAT = new FlatGenerator(5);
	private static final Map<String, VanillaClassicGenerator> BY_NAME = new HashMap<String, VanillaClassicGenerator>();

	static {
		for (Field objectField : VanillaClassicGenerators.class.getDeclaredFields()) {
			objectField.setAccessible(true);
			try {
				final Object object = objectField.get(null);
				if (object instanceof VanillaClassicGenerator) {
					BY_NAME.put(objectField.getName().toLowerCase(), (VanillaClassicGenerator) object);
				}
			} catch (Exception ex) {
				System.out.println("Could not properly reflect VanillaGenerators! Unexpected behaviour may occur, please report to http://issues.spout.org!");
				ex.printStackTrace();
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