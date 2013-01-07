/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2012 - 2013, Greatman <http://www.github.com/greatman/>
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
package com.greatmancode.vanillaclassic.protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.math.Quaternion;
import org.spout.api.protocol.NetworkSynchronizer;
import org.spout.api.protocol.Session;
import org.spout.api.protocol.event.ProtocolEventListener;

import com.greatmancode.vanillaclassic.material.ClassicBlockMaterial;
import com.greatmancode.vanillaclassic.protocol.msg.LevelDataChunkMessage;
import com.greatmancode.vanillaclassic.protocol.msg.LevelFinalizeMessage;
import com.greatmancode.vanillaclassic.protocol.msg.LevelInitializeMessage;
import com.greatmancode.vanillaclassic.protocol.msg.PositionMessage;

/**
 * Synchronizes the game between multiple classic clients
 */
public class VanillaClassicSynchronizer extends NetworkSynchronizer implements ProtocolEventListener {
	private static final int WORLD_SIZE = 500;
	public VanillaClassicSynchronizer(Session session) {
		super(session, 2);
	}

	protected void sendPosition(Point p, Quaternion rot) {
		session.send(false, new PositionMessage((short) -1, (short)p.getX(), (short) p.getY(), (short)p.getZ(), (byte) rot.getYaw(), (byte) rot.getPitch()));
	}
	
	protected void worldChanged(World world) {
		System.out.println("CHANGING WORLD");
		session.send(false, new LevelInitializeMessage());
		byte[] blocks = new byte[WORLD_SIZE * WORLD_SIZE * WORLD_SIZE];
		for (int x = 0; x <= WORLD_SIZE; x++) {
			for (int y = 0; y <= WORLD_SIZE; y++) {
				for (int z = 0; z <= WORLD_SIZE; z++) {
					if (world.getBlock(x,y,z).getMaterial().equals(BlockMaterial.AIR)) {
						blocks[coordsToBlockIndex(x, y, z)] = 0;
					} else {
						blocks[coordsToBlockIndex(x, y, z)] = ((ClassicBlockMaterial) world.getBlock(x, y, z).getMaterial()).getClassicId();
					}
					
				}
			}
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip;
		try {
			gzip = new GZIPOutputStream(out);
			DataOutputStream dataOut = new DataOutputStream(gzip);
			dataOut.writeInt(blocks.length);
			dataOut.write(blocks);
			dataOut.close();
			gzip.close();
			byte[] data = out.toByteArray();
			
			out.close();

			double numChunks = data.length / 1024;
			double sent = 0;

			for (int chunkStart = 0; chunkStart < data.length; chunkStart += 1024) {
				byte[] chunkData = new byte[1024];

				short length = 1024;
				if (data.length - chunkStart < length)
					length = (short) (data.length - chunkStart);

				System.arraycopy(data, chunkStart, chunkData, 0, length);

				session.send(false, new LevelDataChunkMessage(length, chunkData, (byte) ((sent / numChunks) * 255)));
				sent++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.send(false, new LevelFinalizeMessage((short)WORLD_SIZE,(short)WORLD_SIZE,(short)WORLD_SIZE));
		
		Point spawnPoint = world.getSpawnPoint().getPosition();
		session.getPlayer().getTransform().setPosition(new Point(world, 50, 100, 50));
	}

	public static int coordsToBlockIndex(int x, int y, int z) {
		if (x < 0 || y < 0 || z < 0 || x > WORLD_SIZE || y > WORLD_SIZE || z > WORLD_SIZE)
			return -1;

		return x + (z * WORLD_SIZE) + (y * WORLD_SIZE * WORLD_SIZE);
	}
}
