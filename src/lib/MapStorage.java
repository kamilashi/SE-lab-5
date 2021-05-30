package lib;

import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;;

public abstract class MapStorage {
	
	private static Map map;
	
	public static Map getMap()
	{return map;	}
	
	public static void storeMap(Map newMap) throws IOException
	{map = newMap;}

	
	public static void saveMap() throws IOException
	{
		String jsonObject = new Gson().toJson(map);
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
}
