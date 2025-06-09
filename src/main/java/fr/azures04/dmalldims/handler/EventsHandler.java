package fr.azures04.dmalldims.handler;

import fr.azures04.dmalldims.network.NetworkHandler;
import fr.azures04.dmalldims.network.packets.Packet_DimensionsList;
import fr.azures04.dmalldims.utils.DimensionsHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@EventBusSubscriber
public class EventsHandler {

	@SubscribeEvent
	public static void onPlayerConnectedEvent(PlayerLoggedInEvent event) {
		NetworkHandler.INSTANCE.sendTo(new Packet_DimensionsList(DimensionsHelper.getAllDimensions()), (EntityPlayerMP) event.player);
	}
	
}
