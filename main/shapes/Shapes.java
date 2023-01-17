package main.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.calcShapes.calcShapes;
import main.windows.MainWindow;

public abstract class Shapes {
MainWindow window = MainWindow.get();
	
	Graphics g = window.getGraphics();
	
	public abstract calcShapes getCalcShape();
	
	public abstract Color getColor();
	public abstract void setColor(Color c);
	public abstract calcShapes setCalcShape(Point p1, Point p2);
	
	public abstract void draw(Graphics g);
	
	public void repaint() {
		draw(g);
	}
}
