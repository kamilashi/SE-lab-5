package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Map {
	public int roomsCount;
	public static HashMap<String ,Tuple> coordinates;
	public HashMap<String ,Integer[]> coord;
	public ArrayList<Room> rooms;
	
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
		room.roomIndex = roomsCount;
		rooms.add(room);
		roomsCount++;
		
		}
	}
	public Room getRoom(int index)
	{
		for(Room room : rooms) {
			if(room.roomIndex == index)
			{
				return room;
			}
		}
		return null;
	}
	
	public Room getRoom(int x, int y)
	{
		for(Room room : rooms) {
			if((x>room.x && x<(room.x+room.width)) && (y>room.y && y<(room.y+room.length)))
			{
				return room;
			}
		}
		return null;
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
        = coordinates.values().stream().filter(x -> (x.X > 0)).collect(
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

		public boolean isDoor(int x0, int y0) {
			float left = (y0 - doorY1);
			float right = (x0 - doorX1)*( ((float) (doorY2-doorY1))/((float) (doorX2-doorX1)));
			
			System.out.println(left +" ? " + right);
			
			if((y0 - doorY1) == (x0 - doorX1)*( ((float) (doorY2-doorY1))/((float) (doorX2-doorX1))))
			{
				
				return true;
			}
			return false;
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
		
		System.out.println("Setting loaded coordinates");
		
	}

	public void deletePoint(int i, int j) {
		Tuple tuple = new Tuple(i,j);
		
		
		try {
		//Tuple value = coordinates.get(tuple.toString());
		//System.out.println("trying to delete point " + value.toString() );

		coordinates.put(tuple.toString(), new Tuple(-1,-1));
		}catch (Exception e)
		{
			//System.out.println("no match for the key");
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
