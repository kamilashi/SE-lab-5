package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

import lib.Map;
import lib.Map.Tuple;
import lib.MapStorage;

	 public class MapPainter extends JPanel {
		 
	      /**
		 * 
		 */
		private static final long serialVersionUID = 6890456050991712169L;
		
		private Map map;
		private BufferedImage canvas;
		
		public MapPainter(Map map)
		{
			
			this.map = map;
			//int width = 250;
	       // int height = 250;
	 
	        // Constructs a BufferedImage of one of the predefined image types.
	        //BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//this.add(canvas);
	         
		}
		
//			public MapPainter()
//				{
//				}

		@Override
	      public void paintComponent(Graphics g) {
	    	  
	         super.paintComponent(g);     // paint parent's background
	         Color backgroundColor = new Color(240,240,240); 
	         setBackground(backgroundColor);  // set background color for this JPanel
	         Color validCoordinateColor = new Color(173, 216, 230);
	 
	         try {Map.MapData mapData = MapStorage.loadSettings();							//printing the valid coordinates
					for (Tuple tuple :  mapData.getCoordinates())
					{
						int x = tuple.X;
						int y =  tuple.Y;
						g.setColor(validCoordinateColor);
						g.drawLine(x,y,x,y);
					}
				} catch (IOException e) {e.printStackTrace();}
	         
	         
	         for (Map.Room room: map.rooms) {												//printing the border
	         g.setColor(Color.BLACK); 
	         g.drawRect(room.x, room.y, room.width, room.length);
	         g.setColor(validCoordinateColor);
	         g.drawLine(room.doorX1, room.doorY1, room.doorX2, room.doorY2);
	         
	         }
		     
	      }

        public void fillCanvas()
        {
        	try {
				Map.MapData mapData = MapStorage.loadSettings();
				for (Tuple tuple :  mapData.getCoordinates())
				{
					System.out.println("loaded tuples : "+ tuple.X + "  ,  " + tuple.Y );
					//canvas.setRGB(tuple.X, tuple.Y, Color.BLUE.getRGB());
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        }
        	
        	
        
	 }


