package main.shapes;

import java.awt.Graphics;
import java.awt.Point;

import main.calcShapes.calcShapes;
import main.windows.MainWindow;

public abstract class UShapes {

	MainWindow window = MainWindow.get();
	
	Graphics g = window.getGraphics();
	
	public calcShapes calc = null;
	
	public abstract calcShapes setCalcShape(Point p1, Point p2);
	
	public abstract void draw(Graphics g, calcShapes calc);
	
	public void repaint(Point p1, Point p2) {
		window.paintComponents(g);
		draw(g, setCalcShape(p1,p2));
	}
}
