package fr.azures04.dmalldims.utils;

import java.util.HashMap;
import java.util.Map;

import com.swdteam.client.gui.elements.PlanetRenders;
import com.swdteam.common.init.DMDimensions;
import com.swdteam.common.planets.IPlanet;
import com.swdteam.main.config.DMConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionsHelper {
	
	public static void registerAllDimensions() {
		int[] DISABLED_DIMENSIONS = DMConfig.serverSide.DISABLED_DIMENSIONS;
		HashMap<Integer, String> planets = getAllDimensions();
	    for (int i = 0; i < DISABLED_DIMENSIONS.length; i++) {
			int dimensionId = DISABLED_DIMENSIONS[i];
			if (planets.containsKey(dimensionId)) {
				planets.remove(dimensionId);
			}
		}

		for (Integer dimensionId : planets.keySet()) {
			String dimensionName = planets.get(dimensionId);
	    	IPlanet planet = DMDimensions.getPlanetForDimension(dimensionId);
	    	if (planet.getPlanetName().equals("Overworld") && dimensionId != 0) {
	    		DMDimensions.addPlanet(dimensionId, new IPlanet() {
					@Override
					public String getPlanetName() {
						return dimensionName;
					}

					@Override
					public ResourceLocation getPlanetRenderer() {
						return PlanetRenders.TEMPLATE;
					}
	    		});
			}
		}
	}
	
	public static void registerAllDimensions(Map<Integer, String> planets) {
		int[] DISABLED_DIMENSIONS = DMConfig.serverSide.DISABLED_DIMENSIONS;
	    for (int i = 0; i < DISABLED_DIMENSIONS.length; i++) {
			int dimensionId = DISABLED_DIMENSIONS[i];
			if (planets.containsKey(dimensionId)) {
				planets.remove(dimensionId);
			}
		}

		for (Integer dimensionId : planets.keySet()) {
			String dimensionName = planets.get(dimensionId);
	    	IPlanet planet = DMDimensions.getPlanetForDimension(dimensionId);
	    	if (planet.getPlanetName().equals("Overworld") && dimensionId != 0) {
	    		DMDimensions.addPlanet(dimensionId, new IPlanet() {
					@Override
					public String getPlanetName() {
						return dimensionName;
					}

					@Override
					public ResourceLocation getPlanetRenderer() {
						return PlanetRenders.TEMPLATE;
					}
	    		});
			}
		}
	}
	
	public static HashMap<Integer, String> getAllDimensions() {
		HashMap<Integer, String> planets = new HashMap<Integer, String>();
	    for (DimensionType dim : DimensionManager.getRegisteredDimensions().keySet()) {
	    	planets.put(dim.getId(), dim.getName());
	    }
	    return planets;
	}
	
}
