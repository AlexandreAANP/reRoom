package main.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.calcShapes.calcShapes;
import main.calcShapes.calcSquare;
import main.windows.MainWindow;


public class Square extends Shapes{

	private calcShapes calc;
	private Color color;
	public static int counter;
	public int id;
	
	
	public Square(Point p1, Point p2) {
		if(p1.x == p2.x && p1.y == p2.y) return;
		this.calc = setCalcShape(p1, p2);
		this.color = Color.BLUE;
		this.id = Square.counter++;
		saveDraw();
		
	}
	
	
	@Override
	public Color getColor() {
		return this.color;
	}
	
	@Override
	public void setColor(Color c) {
		this.color = c;
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
	
	@Override
	public calcShapes getCalcShape() {
		return this.calc;
	}
	
	@Override
	public calcShapes setCalcShape(Point p1, Point p2) {
		return (calc = new calcSquare(p1,p2));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawRect(calc.getOrigin().x, calc.getOrigin().y, calc.getWidth(), calc.getHeight());
		
	}


	
	
	
	
	
}
