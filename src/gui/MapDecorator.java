package gui;

import java.awt.Component;

public abstract class MapDecorator extends Component implements IMapPainter{
	protected MapPainter mapPainter;
	
	public MapDecorator(MapPainter painter)
	{
		this.mapPainter = painter;
	}
		
}

