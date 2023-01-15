package main.shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

import main.calcShapes.calcSquare;
import main.windows.MainWindow;

public class USquare {
	private static USquare instance;
	private int width;
	private int height;
	private JFrame window;
	
	
	private USquare() {
		this.width = 0;
		this.height = 0;
		this.window = (JFrame) MainWindow.get();
	}
	
	public static USquare get() {
		if(instance == null)
			instance = new USquare();
		return instance;
	}
	
	public Dimension getDimension(Point first, Point last) {
		System.out.println((last.x - first.x)+ "   "+  (last.y - first.y));
		Dimension d = new Dimension(last.x - first.x, last.y - first.y);
		System.out.println(d.width+"  "+ d.height);
		return new Dimension(last.x - first.x, last.y - first.y);
	}
	
	public void DrawSquare(Point first, Point last) {
		Graphics g = this.window.getGraphics();
		this.window.paintComponents(this.window.getGraphics());
		calcSquare CSquare = new calcSquare(first,last);
		//Drawing
		g.setColor(Color.BLACK);
		g.drawRect(CSquare.getOrigin().x, CSquare.getOrigin().y, CSquare.getWidth(), CSquare.getHeight());
	}

}
