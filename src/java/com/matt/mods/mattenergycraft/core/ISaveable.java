package com.matt.mods.mattenergycraft.core;

import net.minecraft.nbt.NBTTagCompound;

public interface ISaveable {
	
	public void writeToNBT(NBTTagCompound compound);
	public void readFromNBT(NBTTagCompound compound);
	
}
