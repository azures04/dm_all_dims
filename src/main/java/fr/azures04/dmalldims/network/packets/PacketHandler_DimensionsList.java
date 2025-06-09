package fr.azures04.dmalldims.network.packets;

import org.lwjgl.opengl.Display;

import fr.azures04.dmalldims.utils.DimensionsHelper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketHandler_DimensionsList implements IMessageHandler<Packet_DimensionsList, IMessage> {

	@Override
	public IMessage onMessage(Packet_DimensionsList message, MessageContext ctx) {
		DimensionsHelper.registerAllDimensions(message.getDimensionsList());
		return null;
	}

}
