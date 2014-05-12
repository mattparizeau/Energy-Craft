package com.matt.mods.mattenergycraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mods.mattenergycraft.EnergyCraft;
import com.matt.mods.mattenergycraft.gui.GuiPowerCell;
import com.matt.mods.mattenergycraft.inventory.ContainerPowerCell;
import com.matt.mods.mattenergycraft.tiles.TileEntityPowerCell;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	
	public static final void initGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(EnergyCraft.instance, new GuiHandler());
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileEntityPowerCell)
			{
				TileEntityPowerCell powercell = (TileEntityPowerCell)tile;
				return new ContainerPowerCell(player, powercell);
			}
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileEntityPowerCell)
			{
				TileEntityPowerCell powercell = (TileEntityPowerCell)tile;
				return new GuiPowerCell(player, powercell);
			}
		}
		return null;
	}
	
}
