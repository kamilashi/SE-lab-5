package lib;

public class Tuple{
	public Integer X;
	public Integer Y;
	public Tuple(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	@Override
	public String toString()
	{
		return new String(X + ","+Y);
	}
	
}
