package main.calcShapes;

import java.awt.Point;

public class calcSquare implements calcShapes{
	private Point firstP;
	private Point lastP;
	private int width;
	private int height;
	
	
	public calcSquare (Point p1, Point p2) {
		this.firstP = p1;
		this.lastP = p2;
		this.width = p2.x - p1.x;
		this.height = p2.y - p1.y;
	}
	
	
	@Override
	public Point getOrigin() {
		System.out.println(this.width+" "+this.height);
		//Q1
		if(this.width > 0 && this.height < 0)
			return new Point(this.firstP.x, this.lastP.y);
		//Q2
		if(this.width < 0 && this.height < 0)
			return this.lastP;
		//Q3
		if(this.width < 0 && this.height > 0)
			return new Point(this.lastP.x, this.firstP.y);
		//Q4
		return this.firstP;
	}

	@Override
	public int getWidth() {
		if(this.width<0)
			return this.width*-1;
		return this.width;
	}

	@Override
	public int getHeight() {
		if(this.height<0)
			return this.height*-1;
		return this.height;
	}

}
