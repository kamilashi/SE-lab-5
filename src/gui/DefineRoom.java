package gui;

import lib.MapManager;

public class DefineRoom extends MapDecorator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2350718075006507704L;

	public DefineRoom(MapPainter painter)
	{
		super(painter);
	
	}

	@Override
	public void repaint(int x, int y) {
		
		MapManager.updateRoomSettings(x, y);
		mapPainter.repaint();
		
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		mapPainter.repaint();
	}

	@Override
	public void repaint(int x, int y, int i) {
		// TODO Auto-generated method stub
		mapPainter.repaint();
	}
}
