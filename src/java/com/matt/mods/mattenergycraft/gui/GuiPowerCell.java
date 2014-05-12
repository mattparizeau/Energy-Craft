package com.matt.mods.mattenergycraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import com.matt.mods.mattenergycraft.inventory.ContainerPowerCell;
import com.matt.mods.mattenergycraft.tiles.TileEntityPowerCell;

public class GuiPowerCell extends GuiContainer {

	private TileEntityPowerCell powercell;
	
	public GuiPowerCell(EntityPlayer player, TileEntityPowerCell powercell)
	{
		super(new ContainerPowerCell(player, powercell));
		this.powercell = powercell;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		this.fontRendererObj.drawString(this.powercell.getInventory().getInventoryName(), 12, 5, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
	{
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}
	
}
