package main.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.windows.MainWindow;


public class Square{

	private int width;
	private int height;
	private Point origin;
	//private Point center;
	
	
	
	
	public Square(Point origin, int width, int height) {
		this.width = width;
		this.height = height;
		this.origin = origin;
		saveDraw();
		
	}

	public void saveDraw() {
		MainWindow.get().memory.add(this);
	}
	
	public boolean deleteDraw() {
		MainWindow window = MainWindow.get();
		boolean res = window.memory.remove(this);
		if(res) 
			window.paintComponents(MainWindow.get().getGraphics());
		return res;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(origin.x, origin.y, width, height);
	}
	
	
	
	
	
}
