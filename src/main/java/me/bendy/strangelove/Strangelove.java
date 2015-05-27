package me.bendy.strangelove;

import me.bendy.strangelove.common.CommonProxy;
import me.bendy.strangelove.constants.Constants;
import me.bendy.strangelove.items.ItemRocket;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Constants.modid, name = "Bendy Strangelove", version = Constants.version)
public class Strangelove {

	ItemRocket itemRocket = new ItemRocket();

	/**
	 * The instance of your mod that Forge uses.
	 */
	@Instance(value = Constants.modid)
	public static Strangelove instance;

	@SidedProxy(clientSide = "me.bendy.strangelove.client.ClientProxy", serverSide = "me.bendy.strangelove.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		preInit();
	}

	private void preInit() {
		GameRegistry.registerItem(itemRocket, Constants.ROCKET, Constants.modid);
	}
}
