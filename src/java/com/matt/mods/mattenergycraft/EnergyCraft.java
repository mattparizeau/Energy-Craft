package com.matt.mods.mattenergycraft;

import com.matt.mods.mattenergycraft.core.ECInit;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EnergyCraft.modid, name = EnergyCraft.name, version = EnergyCraft.version)
public class EnergyCraft {
	public static final String modid = "mattenergycraft";
	public static final String name = "Energy Craft";
	public static final String version = "1.7.2";
	public static final String prefix = modid + ":";
	
	@Instance(modid)
	public static EnergyCraft instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ECInit.preinitEC();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ECInit.initEC();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ECInit.postinitEC();
	}
}
