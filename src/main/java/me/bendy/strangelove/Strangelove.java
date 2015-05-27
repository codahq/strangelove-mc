package me.bendy.strangelove;

import me.bendy.strangelove.common.CommonProxy;
import me.bendy.strangelove.constants.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Constants.modid, name = "Bendy Strangelove", version = Constants.version)
public class Strangelove
{
	/**
	 * The instance of your mod that Forge uses.
	 */
	@Instance(value = Constants.modid)
	public static Strangelove instance;

	@SidedProxy(clientSide = "me.bendy.strangelove.client.ClientProxy", serverSide = "me.bendy.strangelove.common.CommonProxy")
	public static CommonProxy proxy;
}
