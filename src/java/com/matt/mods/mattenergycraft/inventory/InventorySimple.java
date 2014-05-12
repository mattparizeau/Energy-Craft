package com.matt.mods.mattenergycraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.matt.mods.mattenergycraft.core.ISaveable;

public class InventorySimple implements IInventory, ISaveable {

	private ItemStack[] inventory;
	private String inventoryName;
	
	public InventorySimple(int slots, String inventoryName)
	{
		this.inventory = new ItemStack[slots];
		this.inventoryName = inventoryName;
	}
	
	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return this.inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		if (this.getStackInSlot(slot) != null)
		{
			ItemStack itemstack;
			if (this.getStackInSlot(slot).stackSize <= amount)
			{
				itemstack = this.getStackInSlot(slot);
				this.setInventorySlotContents(slot, null);
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(slot).splitStack(amount);
				
				if (this.getStackInSlot(slot).stackSize <= 0)
				{
					this.setInventorySlotContents(slot, null);
				}
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if (this.getStackInSlot(slot) != null)
		{
			ItemStack itemstack = this.getStackInSlot(slot);
			this.setInventorySlotContents(slot, null);
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.inventory[slot] = itemstack;
		
		this.markDirty();
	}

	@Override
	public String getInventoryName()
	{
		return this.inventoryName;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public void markDirty()
	{
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory()
	{
		
	}

	@Override
	public void closeInventory()
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < this.inventory.length; i++)
		{
			if (this.inventory[i] != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("Slot", i);
				this.inventory[i].writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		NBTTagList items = compound.getTagList("Items", 10);
		
		for (int i = 0; i < items.tagCount(); i++)
		{
			NBTTagCompound item = items.getCompoundTagAt(i);
			int slot = item.getInteger("Slot");
			ItemStack itemstack = ItemStack.loadItemStackFromNBT(item);
			this.inventory[slot] = itemstack;
		}
	}
	
}
