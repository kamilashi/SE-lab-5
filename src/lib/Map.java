package lib;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Map {
	public int roomsCount;
	public HashMap< Tuple, Boolean > coordinates;
	public ArrayList<Room> rooms;
	private int lastIndex = 0;
	
	public Map()
	{
		this.roomsCount = 0;
		rooms = new ArrayList<Room>();				//current room limit = 10
		coordinates = new HashMap< Tuple, Boolean>();
	}
	
	public void addRoom(int x, int y, int w, int l, int dX1, int dY1, int dX2, int dY2) 
	{
		if(roomsCount<10)
		{
		Room room = new Room(x,y,w,l,dX1,dY1,dX2,dY2);
		rooms.add(room);
		roomsCount++;
		
		
		}
	}
	
	public void resetMapData() 
	{
		for(Room room : rooms)
		{
			int i,j;
			for ( i = room.x; i<(room.x+room.width); i++)
			{
				for ( j = room.y; j<(room.y+room.length); j++)
				{
					coordinates.put(new Tuple(i,j), true);
					//System.out.println("adding tuple " + i + " , " + j);
				}
			}
			
		}
		
		
	}
	public MapData getMapData()
	{
		if(coordinates.get(new Tuple(0,0))==null)
		{
			resetMapData();
		}
		
		ArrayList<Tuple> coodrs
        = coordinates.keySet().stream().collect(
            Collectors.toCollection(ArrayList::new));
		MapData mapData = new MapData(coodrs);
		return mapData;
	}
	
	public class Room{
		public int x;
		public int y;
		public int width;
		public int length;
		public int roomIndex;
		
		public int doorX1;
		public int doorY1;
		public int doorX2;
		public int doorY2;
		
		public Room(int x, int y, int w, int l, int dX1, int dY1, int dX2, int dY2)	{
			this.x = x;
			this.y = y;
			this.width = w;
			this.length = l;
			this.doorX1 = dX1;
			this.doorY1 = dY1;
			this.doorX2 = dX2;
			this.doorY2 = dY2;
		}
	}
	
	public class MapData
	{
		public ArrayList<Tuple> validCoordinates;
		public MapData(ArrayList<Tuple> objects) {
			validCoordinates = objects;
		}
		public ArrayList<Tuple> getCoordinates() {
			return validCoordinates;
			
		}
	}
	
	public class Tuple{
		public int X;
		public int Y;
		public Tuple(int x, int y) {
			this.X = x;
			this.Y = y;
		}
		
	}

}
