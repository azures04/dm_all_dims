package fr.azures04.dmalldims.network;

import fr.azures04.dmalldims.Constants;
import fr.azures04.dmalldims.network.packets.PacketHandler_DimensionsList;
import fr.azures04.dmalldims.network.packets.Packet_DimensionsList;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.mod_id);
	
	public static void registerPackets() {
		INSTANCE.registerMessage(new PacketHandler_DimensionsList(), Packet_DimensionsList.class, 1, Side.CLIENT);
	}
	
}
