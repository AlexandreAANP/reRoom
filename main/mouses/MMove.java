package main.mouses;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.windows.MainWindow;

public class MMove extends MMouse{
	private static MMove instance;
	private Cursor cursor;
	
	private MMove () {
		this.cursor = new Cursor(Cursor.MOVE_CURSOR);
	}
	
	public static MMove get() {
		if(instance == null)
			instance = new MMove();
		return instance;
	}

	
	@Override
	public Cursor getCursor() {
		return this.cursor;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == e.BUTTON3)
			MainWindow.get().changeMouse(MCreate.get());
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
