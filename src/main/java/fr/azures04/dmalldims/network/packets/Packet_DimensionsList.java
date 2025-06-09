package fr.azures04.dmalldims.network.packets;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class Packet_DimensionsList implements IMessage {

	private Map<Integer, String> dimensionsList;
	
	public Packet_DimensionsList() {
		this.dimensionsList = new HashMap<>();
	}
	
	public Packet_DimensionsList(Map<Integer, String> dimensionsList) {
		this.dimensionsList = dimensionsList;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(dimensionsList.size());
		for (Entry<Integer, String> entry : dimensionsList.entrySet()) {
			buf.writeInt(entry.getKey());
			ByteBufUtils.writeUTF8String(buf, entry.getValue());
		}
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		int size = buf.readInt();
		this.dimensionsList = new HashMap<Integer, String>(size);
		for (int i = 0; i < size; i++) {
			int dimensionId = buf.readInt();
			String dimensionName = ByteBufUtils.readUTF8String(buf);
			dimensionsList.put(dimensionId, dimensionName);
		}
	}
	
	public Map<Integer, String> getDimensionsList() {
		return dimensionsList;
	}

}
