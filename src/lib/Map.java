package lib;

import java.util.ArrayList;

public class Map {
	public int roomsCount;
	public ArrayList<Room> rooms;
	
	public Map()
	{
		this.roomsCount = 0;
		rooms = new ArrayList<Room>();				//current room limit = 10
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

}
