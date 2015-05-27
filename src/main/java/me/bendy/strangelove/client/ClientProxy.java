package me.bendy.strangelove.client;

import java.util.ArrayList;

import me.bendy.strangelove.common.CommonProxy;
import me.bendy.strangelove.constants.Constants;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy
{

	@Override
	public void registerEntities()
	{
		RenderManager renderer = Minecraft.getMinecraft().getRenderManager();
		RenderItem renderitem = Minecraft.getMinecraft().getRenderItem();

	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx)
	{
		if (ctx.side.isClient())
		{
			return Minecraft.getMinecraft().thePlayer;
		}
		return super.getPlayerEntity(ctx);
	}

	@Override
	public void registerTextures()
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

	}

}
