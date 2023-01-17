package main.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.calcShapes.calcShapes;
import main.calcShapes.calcSquare;


public class USquare extends UShapes{
	private static USquare instance;
	
	private USquare() {
	}
	
	public static USquare get() {
		if(instance == null)
			instance = new USquare();
		return instance;
	}
	
	
	@Override
	public calcShapes setCalcShape(Point p1, Point p2) {
		return (calc = new calcSquare(p1,p2));
	}
	
	@Override
	public void draw(Graphics g, calcShapes calc) {
		g.setColor(Color.BLACK);
		g.drawRect(calc.getOrigin().x, calc.getOrigin().y, calc.getWidth(), calc.getHeight());
		
	}

}
