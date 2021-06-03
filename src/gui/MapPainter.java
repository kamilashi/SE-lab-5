package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import lib.Map;
import lib.Tuple;
import lib.MapManager;

	 public class MapPainter extends JPanel {
		 
	      /**
		 * 
		 */
		private static final long serialVersionUID = 6890456050991712169L;
		private boolean drawRoomIndexes;
		
		public MapPainter(boolean drawRoomIndexes )
		{
			this.drawRoomIndexes = drawRoomIndexes;
		}

		@Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);     // paint parent's background
	         Color backgroundColor = new Color(240,240,240); 
	         setBackground(backgroundColor);  // set background color for this JPanel
	         Color validCoordinateColor = new Color(173, 216, 230);
	        
	         //Map map = MapStorage.getMap();
	         Map.MapData mapData = MapManager.getMap().getMapData();							//rendering valid coordinates
					for (Tuple tuple :  mapData.getCoordinates())
					{
						int x = tuple.X;
						int y =  tuple.Y;
						g.setColor(validCoordinateColor);
						g.drawLine(x,y,x,y);
					}
	         
	         for (Map.Room room:  MapManager.getMap().rooms) {												//rendering borders
	         g.setColor(Color.BLACK); 
	        
	         g.drawRect(room.x, room.y, room.width, room.length);
	         g.setColor(validCoordinateColor);
	         g.drawLine(room.doorX1, room.doorY1, room.doorX2, room.doorY2); 
	         g.setColor(Color.BLACK); 
	         if(drawRoomIndexes)
	         	{
	        	 g.drawString(room.roomIndex + "",(room.x+(int)(room.width/2)), (room.y+(int)(room.length/2)));
	         	}
	         }
		     
	      }
		
	 }


