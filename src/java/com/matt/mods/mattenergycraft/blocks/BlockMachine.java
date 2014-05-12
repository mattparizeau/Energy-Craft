package com.matt.mods.mattenergycraft.blocks;

import com.matt.mods.mattenergycraft.EnergyCraft;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockMachine extends BlockBasic {
	
	private static final String machineTex = EnergyCraft.prefix + "machine";
	
	private IIcon sideIcon;
	private IIcon topIcon;
	private IIcon bottomIcon;
	
	public BlockMachine()
	{
		super(Material.iron);
		this.setHardness(1.5F);
		this.setResistance(3.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon(this.getTextureName());
		this.sideIcon = register.registerIcon(machineTex + "_side");
		this.topIcon = register.registerIcon(machineTex + "_top");
		this.bottomIcon = register.registerIcon(machineTex + "_bottom");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == meta)
		{
			return this.blockIcon;
		} else if (side == 1)
		{
			return this.topIcon;
		} else if (side == 0)
		{
			return this.bottomIcon;
		} else
		{
			return this.sideIcon;
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
	{
		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0 / 360.0F) + 0.5D) & 3;
		
		if (direction == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		} else if (direction == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		} else if (direction == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		} else if (direction == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
	
	public boolean hasGui()
	{
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (this.hasGui())
		{
			if (world.isRemote)
				return true;
			player.openGui(EnergyCraft.instance, 0, world, x, y, z);
			
			return true;
		}
		return false;
	}
	
}
