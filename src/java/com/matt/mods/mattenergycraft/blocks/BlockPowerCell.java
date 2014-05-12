package com.matt.mods.mattenergycraft.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mods.mattenergycraft.tiles.TileEntityPowerCell;

public class BlockPowerCell extends BlockMachine {
	
	public BlockPowerCell()
	{
		super();
	}
	
	@Override
	public boolean hasGui()
	{
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityPowerCell();
	}
	
}
