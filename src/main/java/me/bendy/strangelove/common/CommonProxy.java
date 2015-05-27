package me.bendy.strangelove.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy
{
	public void registerEntities()
	{

	}

	public MinecraftServer getMCServer()
	{
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	public EntityPlayer getPlayerEntity(MessageContext ctx)
	{
		return ctx.getServerHandler().playerEntity;
	}

	public void registerTextures()
	{

	}
}
