package lib;

import java.awt.Color;

public class MapGenerator {
	
	public MapGenerator()
	
	{
		Map map = new Map();
		map.addRoom(0, 0, 140, 140, 70, 140, 110, 140);
		MapStorage.storeMap(map);
	}

}
