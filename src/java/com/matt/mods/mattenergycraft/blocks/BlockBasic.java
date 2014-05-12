package com.matt.mods.mattenergycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mods.mattenergycraft.EnergyCraft;
import com.matt.mods.mattenergycraft.tabs.ECTabs;

public abstract class BlockBasic extends BlockContainer {
	
	public BlockBasic(Material material)
	{
		super(material);
		this.setCreativeTab(ECTabs.main);
	}
	
	@Override
	public Block setBlockTextureName(String name)
	{
		return super.setBlockTextureName(EnergyCraft.prefix + name);
	}
	
}
