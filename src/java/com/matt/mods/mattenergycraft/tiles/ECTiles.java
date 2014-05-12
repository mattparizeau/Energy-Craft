package com.matt.mods.mattenergycraft.tiles;

import com.matt.mods.mattenergycraft.EnergyCraft;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ECTiles {
	
	public static final void initTiles()
	{
		GameRegistry.registerTileEntity(TileEntityMachine.class, EnergyCraft.prefix + "machine");
		GameRegistry.registerTileEntity(TileEntityPowerCell.class, EnergyCraft.prefix + "power_cell");
		GameRegistry.registerTileEntity(TileEntityTerminal.class, EnergyCraft.prefix + "terminal");
	}
	
}
