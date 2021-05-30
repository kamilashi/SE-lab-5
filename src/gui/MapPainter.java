package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

import lib.Map;

	 public class MapPainter extends JPanel {
		 
	      /**
		 * 
		 */
		private static final long serialVersionUID = 6890456050991712169L;
		
		private Map map;
		
		public MapPainter(Map map)
		{
			
			this.map = map;
		}
		
//			public MapPainter()
//				{
//				}

		@Override
	      public void paintComponent(Graphics g) {
	    	  
	         super.paintComponent(g);     // paint parent's background
	         Color backgroundColor = new Color(240,240,240); 
	         setBackground(backgroundColor);  // set background color for this JPanel
	 
	         int roomIndex;
	         
	         for (roomIndex = 0; roomIndex < map.roomsCount; roomIndex++) {
	         g.setColor(Color.BLACK); 
	         g.drawRect(map.rooms[roomIndex].x, map.rooms[roomIndex].y, map.rooms[roomIndex].width,map.rooms[roomIndex].length);
	         g.setColor(backgroundColor);
	         g.drawLine(map.rooms[roomIndex].doorX1, map.rooms[roomIndex].doorY1, map.rooms[roomIndex].doorX2, map.rooms[roomIndex].doorY2);
	         }
	         
		         //g.setColor(Color.BLACK); 
		         //g.drawRect(0,0,140,140);
		         //g.setColor(new Color(240,240,240));
		         //g.drawLine(70,140,110,140);
		     
	      }
	   }


