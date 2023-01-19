package main.memory;

import java.awt.Graphics;
import java.util.List;

import main.shapes.Shapes;
import main.shapes.Square;

public class ThreadPaint extends Thread{
	
	private List<Shapes> list;
	private Graphics g;
	private static int ID;
	private int id;
	public ThreadPaint(List<Shapes> l, Graphics g) {
		this.list = l;
		this.g = g;
		this.id = ID++;
	}
	

	@Override
	public void run() {
		for(Shapes s : this.list) {
			s.draw(g);
		}
	}

}
