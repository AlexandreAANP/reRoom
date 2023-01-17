package main.calcShapes;

import java.awt.Point;

public class calcSquare implements calcShapes{
	private Point firstP;
	private Point lastP;
	private Point origin;
	private int width;
	private int height;
	
	
	public calcSquare (Point p1, Point p2) {
		this.firstP = p1;
		this.lastP = p2;
		this.width = p2.x - p1.x;
		this.height = p2.y - p1.y;
		this.origin =calcOrigin();
		
	}
	
	public Point calcOrigin() {
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
	public Point getOrigin() {
		return this.origin;
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

	@Override
	public Point getLastPoint() {
		return this.lastP;
	}
	
	
	@Override
	public boolean inArea(Point p1) {
		int Ox = getOrigin().x;
		int Oy = getOrigin().y;
		return (p1.x >=Ox && p1.x <= Ox + getWidth()) && (p1.y >=Oy && p1.y <= Oy + getHeight());
	}

}
