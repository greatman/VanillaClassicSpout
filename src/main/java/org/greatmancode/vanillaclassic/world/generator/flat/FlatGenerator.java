package org.greatmancode.vanillaclassic.world.generator.flat;

import org.greatmancode.vanillaclassic.material.VanillaClassicMaterials;
import org.greatmancode.vanillaclassic.world.generator.VanillaClassicGenerator;
import org.spout.api.generator.GeneratorPopulator;
import org.spout.api.generator.Populator;
import org.spout.api.geo.World;
import org.spout.api.geo.cuboid.Chunk;
import org.spout.api.geo.discrete.Point;
import org.spout.api.util.cuboid.CuboidShortBuffer;

public class FlatGenerator implements VanillaClassicGenerator {

	private final int height;

	public FlatGenerator(int height) {
		this.height = height;
	}

	@Override
	public void generate(CuboidShortBuffer blockData, int chunkX, int chunkY, int chunkZ, World world) {
		//Thanks DDoS
		int x = chunkX << 4, z = chunkZ << 4;
		for (int dx = x; dx < x + 16; ++dx) {
			for (int dz = z; dz < z + 16; ++dz) {
				final int startY = chunkY << Chunk.BLOCKS.BITS;
				final int endY = Math.min(Chunk.BLOCKS.SIZE + startY, height);
				for (int y = startY; y < endY; y++) {
					if (y <= 0) {
						blockData.set(dx, y, dz, VanillaClassicMaterials.BEDROCK.getId());
					} else if (y == height - 1) {
						blockData.set(dx, y, dz, VanillaClassicMaterials.GRASS.getId());
					} else {
						blockData.set(dx, y, dz, VanillaClassicMaterials.DIRT.getId());
					}
				}
			}
		}

	}

	@Override
	public Populator[] getPopulators() {
		return new Populator[0];
	}

	@Override
	public GeneratorPopulator[] getGeneratorPopulators() {
		return new GeneratorPopulator[0];
	}

	@Override
	public String getName() {
		return "FlatGenerator";
	}

	@Override
	public Point getSafeSpawn(World world) {
		return new Point(world, 0, height, 0);
	}

	@Override
	public int[][] getSurfaceHeight(World world, int chunkX, int chunkZ) {
		int[][] heights = new int[Chunk.BLOCKS.SIZE][Chunk.BLOCKS.SIZE];
		for (int x = 0; x < Chunk.BLOCKS.SIZE; x++) {
			for (int z = 0; z < Chunk.BLOCKS.SIZE; z++) {
				heights[x][z] = height - 1;
			}
		}
		return heights;
	}

}
