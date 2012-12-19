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

import org.spout.api.material.BlockMaterial;

import com.greatmancode.vanillaclassic.material.basic.Bedrock;
import com.greatmancode.vanillaclassic.material.basic.Bookshelf;
import com.greatmancode.vanillaclassic.material.basic.BrickBlock;
import com.greatmancode.vanillaclassic.material.basic.Cloth;
import com.greatmancode.vanillaclassic.material.basic.CobbleStone;
import com.greatmancode.vanillaclassic.material.basic.Dirt;
import com.greatmancode.vanillaclassic.material.basic.DoubleSlab;
import com.greatmancode.vanillaclassic.material.basic.Flower;
import com.greatmancode.vanillaclassic.material.basic.Glass;
import com.greatmancode.vanillaclassic.material.basic.Grass;
import com.greatmancode.vanillaclassic.material.basic.Gravel;
import com.greatmancode.vanillaclassic.material.basic.Leaves;
import com.greatmancode.vanillaclassic.material.basic.MossStone;
import com.greatmancode.vanillaclassic.material.basic.Mushroom;
import com.greatmancode.vanillaclassic.material.basic.Obsidian;
import com.greatmancode.vanillaclassic.material.basic.Sand;
import com.greatmancode.vanillaclassic.material.basic.Sapling;
import com.greatmancode.vanillaclassic.material.basic.Slab;
import com.greatmancode.vanillaclassic.material.basic.Sponge;
import com.greatmancode.vanillaclassic.material.basic.Stone;
import com.greatmancode.vanillaclassic.material.basic.TNT;
import com.greatmancode.vanillaclassic.material.basic.Wood;
import com.greatmancode.vanillaclassic.material.basic.WoodenPlank;
import com.greatmancode.vanillaclassic.material.liquid.Lava;
import com.greatmancode.vanillaclassic.material.liquid.StationaryLava;
import com.greatmancode.vanillaclassic.material.liquid.StationaryWater;
import com.greatmancode.vanillaclassic.material.liquid.Water;
import com.greatmancode.vanillaclassic.material.ore.CoalOre;
import com.greatmancode.vanillaclassic.material.ore.GoldOre;
import com.greatmancode.vanillaclassic.material.ore.IronOre;
import com.greatmancode.vanillaclassic.material.ore.block.GoldBlock;
import com.greatmancode.vanillaclassic.material.ore.block.IronBlock;

/**
 * Holds all the materials found in the classic game.
 */
public class VanillaClassicMaterials {
	public static final BlockMaterial AIR = BlockMaterial.AIR;
	public static final Stone STONE = new Stone();
	public static final Grass GRASS = new Grass();
	public static final Dirt DIRT = new Dirt();
	public static final CobbleStone COBBLESTONE = new CobbleStone();
	public static final WoodenPlank WOODEN_PLANK = new WoodenPlank();
	public static final Sapling SAPLING = new Sapling();
	public static final Bedrock BEDROCK = new Bedrock();
	public static final Water WATER = new Water();
	public static final StationaryWater StationaryWater = new StationaryWater();
	public static final Lava LAVA = new Lava();
	public static final StationaryLava STATIONARY_LAVA = new StationaryLava();
	public static final Sand SAND = new Sand();
	public static final Gravel GRAVEL = new Gravel();
	public static final GoldOre GOLD_ORE = new GoldOre();
	public static final IronOre IRON_ORE = new IronOre();
	public static final CoalOre COAL_ORE = new CoalOre();
	public static final Wood WOOD = new Wood();
	public static final Leaves LEAVES = new Leaves();
	public static final Sponge SPONGE = new Sponge();
	public static final Glass GLASS = new Glass();
	public static final Cloth RED_CLOTH = new Cloth("Red Cloth", 21);
	public static final Cloth ORANGE_CLOTH = new Cloth("Orange Cloth", 22);
	public static final Cloth YELLOW_CLOTH = new Cloth("Yellow Cloth", 23);
	public static final Cloth LIME_CLOTH = new Cloth("Lime Cloth", 24);
	public static final Cloth GREEN_CLOTH = new Cloth("Green Cloth", 25);
	public static final Cloth AQUA_GREEN_CLOTH = new Cloth("Aqua Green Cloth", 26);
	public static final Cloth CYAN_CLOTH = new Cloth("Cyan Cloth", 27);
	public static final Cloth BLUE_CLOTH = new Cloth("Blue Cloth", 28);
	public static final Cloth PURPLE_CLOTH = new Cloth("Purple Cloth", 29);
	public static final Cloth INDIGO_CLOTH = new Cloth("Indigo Cloth", 30);
	public static final Cloth VIOLET_CLOTH = new Cloth("Violet Cloth", 31);
	public static final Cloth MAGENTA_CLOTH = new Cloth("Magenta Cloth", 32);
	public static final Cloth PINK_CLOTH = new Cloth("Pink Cloth", 33);
	public static final Cloth BLACK_CLOTH = new Cloth("Black Cloth", 34);
	public static final Cloth GRAY_CLOTH = new Cloth("Gray Cloth", 35);
	public static final Cloth WHITE_CLOTH = new Cloth("White Cloth", 36);
	public static final Flower DANDELION = new Flower("Dandelion", 37);
	public static final Flower ROSE = new Flower("Rose", 38);
	public static final Mushroom BROWN_MUSHROOM = new Mushroom("Brown Mushroom", 39);
	public static final Mushroom RED_MUSHROOM = new Mushroom("Red Mushroom", 40);
	public static final GoldBlock GOLD_BLOCK = new GoldBlock();
	public static final IronBlock IRON_BLOCK = new IronBlock();
	public static final DoubleSlab DOUBLE_SLAB = new DoubleSlab();
	public static final Slab SLAB = new Slab();
	public static final BrickBlock BRICK_BLOCK = new BrickBlock();
	public static final TNT TNT = new TNT();
	public static final Bookshelf BOOKSHELF = new Bookshelf();
	public static final MossStone MOSS_STONE = new MossStone();
	public static final Obsidian OBSIDIAN = new Obsidian();
}
