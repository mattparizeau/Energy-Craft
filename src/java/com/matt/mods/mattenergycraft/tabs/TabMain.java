package com.matt.mods.mattenergycraft.tabs;

import com.matt.mods.mattenergycraft.blocks.ECBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabMain extends CreativeTabs {
	
	public TabMain(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(ECBlocks.power_cell);
	}
}
