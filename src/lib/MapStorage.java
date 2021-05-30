package lib;

public abstract class MapStorage {
	
	private static Map map;
	
	public static Map getMap()
	{return map;	}
	
	public static void storeMap(Map newMap)
	{map = newMap;	}

}
