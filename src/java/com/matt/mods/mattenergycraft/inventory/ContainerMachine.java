package com.matt.mods.mattenergycraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import com.matt.mods.mattenergycraft.tiles.TileEntityMachine;

public class ContainerMachine extends Container {
	
	protected EntityPlayer player;
	protected TileEntityMachine tile;
	
	public ContainerMachine(EntityPlayer player, TileEntityMachine tile)
	{
		this.player = player;
		this.tile = tile;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile.isUseableByPlayer(player);
	}
}
