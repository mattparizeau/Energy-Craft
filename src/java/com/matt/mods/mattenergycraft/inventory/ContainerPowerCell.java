package com.matt.mods.mattenergycraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

import com.matt.mods.mattenergycraft.tiles.TileEntityPowerCell;

public class ContainerPowerCell extends ContainerMachine {
	
	public ContainerPowerCell(EntityPlayer player, TileEntityPowerCell powercell)
	{
		super(player, powercell);
		
		this.addSlotToContainer(new Slot(powercell.getInventory(), 0, 0, 0));
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				this.addSlotToContainer(new Slot(player.inventory, i + j * 9 + 9, 8 + i * 18, 8 + j * 18));
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 8 + 54));
		}
	}
	
}
