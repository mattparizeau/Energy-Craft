package com.matt.mods.mattenergycraft.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ECWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16;
		int z = chunkZ * 16;
		
		switch (world.provider.dimensionId)
		{
			case -1:
				generateNether(random, x, z, world);
				break;
			case 0:
				generateSurface(random, x, z, world);
				break;
			case 1:
				generateEnd(random, x, z, world);
				break;
		}
	}
	
	public void generateNether(Random random, int x, int z, World world)
	{
		
	}
	
	public void generateSurface(Random random, int x, int z, World world)
	{
		
	}
	
	public void generateEnd(Random random, int x, int z, World world)
	{
		
	}

	public static final void initWorldGen()
	{
		GameRegistry.registerWorldGenerator(new ECWorldGen(), 0);
	}
	
}
