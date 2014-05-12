package com.matt.mods.mattenergycraft.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

import com.matt.mods.mattenergycraft.inventory.InventorySimple;

public class TileEntityPowerCell extends TileEntityMachine {
	
	private InventorySimple inventory;
	private int power;
	private int maxPower;
	
	public TileEntityPowerCell()
	{
		this.inventory = new InventorySimple(1, "power_cell");
		this.power = 0;
		this.maxPower = 5000;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		this.inventory.writeToNBT(compound);
		
		compound.setInteger("Power", this.power);
		compound.setInteger("MaxPower", this.maxPower);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		this.inventory.readFromNBT(compound);
		
		this.power = compound.getInteger("Power");
		this.maxPower = compound.getInteger("MaxPower");
		
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public int getMaxPower()
	{
		return this.maxPower;
	}
	
	public int getScaledPower(int scale)
	{
		return this.power * scale / this.maxPower;
	}
	
	public IInventory getInventory()
	{
		return this.inventory;
	}
	
}
