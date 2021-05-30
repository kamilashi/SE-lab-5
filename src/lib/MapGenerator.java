package lib;

import java.awt.Color;

public class MapGenerator {
	
	public MapGenerator()
	
	{
		Map map = new Map();

		map.addRoom(0, 140, 140+140, 70, -100, -100, 140+30, 140);
		map.addRoom(0, 0, 140, 140, 70, 140, 110, 140);
		map.addRoom(140, 0, 140, 140, 140+70, 140, 140+30, 140);
		MapStorage.storeMap(map);
	}

}
