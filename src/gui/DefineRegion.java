package gui;

import lib.MapManager;

public class DefineRegion extends MapDecorator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7127308169277305066L;

	public DefineRegion(MapPainter mapPainter) {
		super(mapPainter);
		}

	public void repaint( int x, int y, int brushSize)
	{

				MapManager.updateRegionSettings(x, y, brushSize);
				mapPainter.repaint();
			
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		mapPainter.repaint();
	}

	@Override
	public void repaint(int x, int y) {
		// TODO Auto-generated method stub
		mapPainter.repaint();
	}
}
