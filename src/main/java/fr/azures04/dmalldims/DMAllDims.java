package fr.azures04.dmalldims;

import fr.azures04.dmalldims.utils.DimensionsHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

@Mod(modid = Constants.mod_id, version = Constants.version, name = Constants.mod_name, serverSideOnly = true, acceptableRemoteVersions = "*")
public class DMAllDims {
	
	@EventHandler
	public void onServerStarted(FMLServerStartedEvent event) {
		DimensionsHelper.registerAllDimensions();
	}

}
