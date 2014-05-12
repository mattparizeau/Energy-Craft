package com.matt.mods.mattenergycraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class ECBlocks {
	
	public static Block power_cell;
	public static Block terminal;
	
	public static final void initBlocks()
	{
		power_cell = new BlockPowerCell().setBlockName("power_cell").setBlockTextureName("power_cell");
		terminal = new BlockTerminal().setBlockName("terminal").setBlockTextureName("terminal");
		
		GameRegistry.registerBlock(power_cell, "power_cell");
		GameRegistry.registerBlock(terminal, "terminal");
	}
	
}
