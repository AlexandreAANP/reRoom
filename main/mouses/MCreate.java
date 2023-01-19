package main.mouses;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;

import main.calcShapes.calcShapes;
import main.shapes.Shapes;
import main.shapes.Square;
import main.shapes.USquare;
import main.windows.MainWindow;


public class MCreate extends MMouse{
	private static MCreate instance;
	private Point firstPoint;
	private Point actualPoint;
	private int lastButtonPressed;
	private boolean disableDraggedFunction;
	
	private Cursor cursor;
	
	
	public Square square;

	
	
	private boolean isMousePressed;
	
	
	private MCreate () {
		this.cursor = new Cursor(Cursor.DEFAULT_CURSOR);
	}
	
	public static MCreate get() {
		if(instance==null)
			instance = new MCreate();
		return instance;
	}
	
	@Override
	public Cursor getCursor() {
		return this.cursor;
	}
	
	public boolean isMousePressed() {
		return this.isMousePressed;
	};

	
	//TODO MOVE THIS METHOD TO A CLASS THAT WILL CONTROL SHAPES OBJETOS
	public Shapes getTouched(Point p) {
		//Iterator<Shapes> i = MainWindow.get().memory.list.descendingIterator();
		for(int i = MainWindow.get().memory.list.size()-1; i >=0 ; i--) {
			Shapes shape = MainWindow.get().memory.list.get(i);
			if(shape.getCalcShape().inArea(p))
				return shape;
		}
		return null;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Shapes shape = null;
		if((shape = getTouched(e.getPoint()))!=null) {
			this.disableDraggedFunction = true;
			shape.setColor(Color.RED);
			MainWindow.get().changeMouse(MMove.get());
			MainWindow.get().paintComponents(MainWindow.get().getGraphics());
		}
		this.disableDraggedFunction = false;
		//MainWindow.get().changeMouse(MCreate.get());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.isMousePressed = true;
		this.firstPoint = e.getPoint();
		this.lastButtonPressed = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMousePressed = false;
		if(this.lastButtonPressed != e.BUTTON1) return;
		calcShapes drawedSquare = USquare.get().calc;
		if(drawedSquare == null)
			return;
		
		this.square = new Square(this.firstPoint, e.getPoint());
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
			if(!this.disableDraggedFunction && this.lastButtonPressed != e.BUTTON1) return;
			
			if(this.actualPoint!=null && e.getPoint().x!=this.actualPoint.x && e.getPoint().y != this.actualPoint.y) {
				USquare.get().repaint(this.firstPoint, e.getPoint());
				this.actualPoint = e.getPoint();
			}
			this.actualPoint = e.getPoint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

}
