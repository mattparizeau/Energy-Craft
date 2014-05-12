package com.matt.mods.mattenergycraft.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTerminal extends TileEntity {
	
	private int power;
	private int maxPower;
	
	public TileEntityTerminal()
	{
		this.power = 0;
		this.maxPower = 500;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		compound.setInteger("Power", this.power);
		compound.setInteger("MaxPower", this.maxPower);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
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
	
}
