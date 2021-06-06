package program;

import java.io.IOException;

public class MapReceiver {
	
	public MapReceiver() throws IOException
	
	{
		Map map = Map.getInstance();

		//map.addRoom(0, 140, (140+140), 70, -100, -100, -100, -100);
		//map.addRoom(0, 0, 140, 140, 70, 140, 110, 140);
		//map.addRoom(140, 0, 140, 140, (140+30), 140, (140+70), 140);
		
		
		MapManager.storeMap(map);
	}

}
