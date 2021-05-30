package lib;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import lib.Map.MapData;

import com.google.gson.*;;

public abstract class MapStorage {
	
	private static Map currentMap;
	
	public static Map getMap()
	{return currentMap;	}
	
	public static void storeMap(Map newMap) throws IOException
	{currentMap = newMap;}

	
	public static void saveSettings() throws IOException
	{
		String jsonObject = new Gson().toJson(currentMap.getMapData());
		FileWriter file = new FileWriter(Paths.get("src//maps//map.json").toString()); 
			try {
	            file.write(jsonObject);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	 
	        } finally {
	 
	            try {
	                file.flush();
	                file.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	public static MapData loadSettings() throws IOException
	{
		String jsonObject = new String(Files.readAllBytes(Paths.get("src//maps//map.json")));
		MapData mapData = new Gson().fromJson(jsonObject, MapData.class);
		return mapData;
	}
	
	public static void resetMap() {
		map.resetMapData();
	}
	
}
