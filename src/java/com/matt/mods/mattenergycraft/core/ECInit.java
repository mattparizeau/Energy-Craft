package com.matt.mods.mattenergycraft.core;

import com.matt.mods.mattenergycraft.blocks.ECBlocks;
import com.matt.mods.mattenergycraft.entity.ECEntity;
import com.matt.mods.mattenergycraft.items.ECItems;
import com.matt.mods.mattenergycraft.tabs.ECTabs;
import com.matt.mods.mattenergycraft.tiles.ECTiles;
import com.matt.mods.mattenergycraft.worldgen.ECWorldGen;

public final class ECInit {
	
	public static final void initEC()
	{
		ECTabs.initTabs();
		ECBlocks.initBlocks();
		ECItems.initItems();
		ECTiles.initTiles();
		ECEntity.initEntities();
		ECWorldGen.initWorldGen();
	}
	
}
