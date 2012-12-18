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
package com.greatmancode.vanillaclassic.material;

import com.greatmancode.vanillaclassic.material.basic.Air;
import com.greatmancode.vanillaclassic.material.basic.Bedrock;
import com.greatmancode.vanillaclassic.material.basic.CobbleStone;
import com.greatmancode.vanillaclassic.material.basic.Dirt;
import com.greatmancode.vanillaclassic.material.basic.Grass;
import com.greatmancode.vanillaclassic.material.basic.Sapling;
import com.greatmancode.vanillaclassic.material.basic.Stone;
import com.greatmancode.vanillaclassic.material.basic.WoodenPlank;

/**
 * Holds all the materials found in the classic game.
 */
public class VanillaClassicMaterials {
	public static final Air AIR = new Air();
	public static final Stone STONE = new Stone();
	public static final Grass GRASS = new Grass();
	public static final Dirt DIRT = new Dirt();
	public static final CobbleStone COBBLESTONE = new CobbleStone();
	public static final WoodenPlank WOODEN_PLANK = new WoodenPlank();
	public static final Sapling SAPLING = new Sapling();
	public static final Bedrock BEDROCK = new Bedrock();
}
