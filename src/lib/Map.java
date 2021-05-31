package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Map {
	public int roomsCount;
	public static HashMap<String ,Tuple> coordinates;
	public HashMap<String ,Integer[]> coord;
	public ArrayList<Room> rooms;
	private int lastIndex = 0;
	
	public Map()
	{
		this.roomsCount = 0;
		rooms = new ArrayList<>();				//current room limit = 10
		if(coordinates==null)
		{
		coordinates = new HashMap<>();
		}
		coord = new HashMap<>();
		
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
					Tuple tuple = new Tuple(i,j);
					coordinates.put(tuple.toString(),tuple);
					//System.out.println("key " + tuple.toString().toString() + " value " + coordinates.get(tuple.toString()).toString());
				}
			}
		}
		
		
	}
	public MapData getMapData()
	{
		if(coordinates.isEmpty())
		{
			resetMapData();
		}
		
		ArrayList<Tuple> coodrs
        = coordinates.values().stream().collect(
            Collectors.toCollection(ArrayList::new));
		MapData mapData = new MapData(coodrs);
		
		return mapData;
	}
	
	
	public void updateMapData(ArrayList<Tuple> tuples) {
		

		if(coordinates.isEmpty())
		{
			System.out.println("no coordinates yet");
		}
		else
		{
			for (Tuple tuple: tuples)
			{coordinates.put(tuple.toString(),new Tuple(-1,-1));}
		}
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
		public MapData(ArrayList<Tuple> tuples) {
			validCoordinates = tuples;
		}
		public ArrayList<Tuple> getCoordinates() {
			return validCoordinates;
			
		}
	}

	public void setMapData(MapData mapData) {
		ArrayList<Tuple> tuples = mapData.getCoordinates();
		coordinates = null;
		coordinates = new HashMap<>();
		
		for (Tuple tuple : tuples)
		{
			coordinates.put(tuple.toString(), tuple);
		}
		
		System.out.println("Setting loaded coords");
		
	}

	public void deletePoint(int i, int j) {
		Tuple tuple = new Tuple(i,j);
		
		
		Tuple value = coordinates.get(tuple.toString());
		System.out.println("trying to delete point " + value.toString() );

		Iterator<String> iterator = coordinates.keySet().iterator();
		while(iterator.hasNext())
		{
			if(iterator.next() == tuple.toString()){
		        iterator.remove();
		        System.out.println("deleted tuple at "+ i + " , " + j);
		      }
		}
		
		
	}
	
	public void printActivePoints()
	{
		System.out.println("print attempt ");
		for(Tuple tuple: coordinates.values())
		{
			 System.out.println("value: " + tuple.toString());
		}
	}

}
