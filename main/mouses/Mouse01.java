package main.mouses;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Point;

import main.shapes.USquare;

public class Mouse01 implements MouseListener, MouseMotionListener{
	private static Mouse01 instance;
	private Point firstPoint;
	private Point lastPoint;
	private Point actualPoint;

	private boolean isMousePressed;
	
	
	private Mouse01 () {
		
	}
	
	public static Mouse01 get() {
		if(instance==null)
			instance = new Mouse01();
		return instance;
	}
	
	public boolean isMousePressed() {
		return this.isMousePressed;
	};

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.isMousePressed = true;
		this.firstPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMousePressed = false;
		this.lastPoint = e.getPoint();
		
		System.out.println("("+this.firstPoint.x+", "+this.firstPoint.y+")"
						+" ("+this.lastPoint.x + ", " + this.lastPoint.y + ")");
		//USquare.get().DrawSquare(this.firstPoint, this.lastPoint);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.actualPoint!=null && e.getPoint().x!=this.actualPoint.x && e.getPoint().y != this.actualPoint.y) {
			USquare.get().DrawSquare(this.firstPoint, e.getPoint());
			this.actualPoint = e.getPoint();
		}
		this.actualPoint = e.getPoint();
			
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

}
