package fr.azures04.dmalldims;

import fr.azures04.dmalldims.handler.EventsHandler;
import fr.azures04.dmalldims.network.NetworkHandler;
import fr.azures04.dmalldims.utils.DimensionsHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Constants.mod_id, version = Constants.version, name = Constants.mod_name)
public class DMAllDims {
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent event) {
		NetworkHandler.registerPackets();
		MinecraftForge.EVENT_BUS.register(new EventsHandler());
	}
	
	@EventHandler
	public void onPostInitialization(FMLPostInitializationEvent event) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			DimensionsHelper.registerAllDimensions();
		}
	}
	
	@EventHandler
	public void onServerStarted(FMLServerStartedEvent event) {
	}
	
}
