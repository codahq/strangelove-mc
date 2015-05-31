package me.bendy.strangelove;

import me.bendy.strangelove.common.CommonProxy;
import me.bendy.strangelove.constants.Constants;
import me.bendy.strangelove.items.ItemRocket;
import me.bendy.strangelove.entity.passive.EntityRocket;
import me.bendy.strangelove.items.ItemEntityTest;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Constants.modid, name = "Bendy Strangelove", version = Constants.version)
public class Strangelove {

	ItemRocket itemRocket = new ItemRocket();

	public static Item entityTest = new ItemEntityTest();

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

		registerEntity(EntityRocket.class, Constants.ROCKET);
		GameRegistry.registerItem(entityTest, Constants.ROCKET);
	}

	private void preInit() {
		GameRegistry.registerItem(itemRocket, Constants.ROCKET, Constants.modid);
	}

	/**
	 * Helper method to register custom entities
	 * 
	 * @param entityClass
	 *            The custom entity to be registered
	 * @param name
	 *            The string ID of the entity to be registered
	 * @param makeEgg
	 *            A boolean to determine if a spawn egg for the entity will be created for creative mode
	 */
	public static void registerEntity(Class entityClass, String name) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);

	}
}
