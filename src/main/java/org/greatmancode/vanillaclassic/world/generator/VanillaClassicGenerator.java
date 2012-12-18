package org.greatmancode.vanillaclassic.world.generator;

import org.spout.api.generator.WorldGenerator;
import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;

public interface VanillaClassicGenerator extends WorldGenerator {
	public abstract Point getSafeSpawn(World world);
}
