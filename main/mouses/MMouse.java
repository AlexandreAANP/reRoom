package main.mouses;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class MMouse implements MouseMotionListener, MouseListener {
	
	public abstract Cursor getCursor();

	@Override
	public abstract void mouseClicked(MouseEvent e);

	@Override
	public abstract void mousePressed(MouseEvent e);

	@Override
	public abstract void mouseReleased(MouseEvent e);

	@Override
	public abstract void mouseEntered(MouseEvent e);

	@Override
	public abstract void mouseExited(MouseEvent e);

	@Override
	public abstract void mouseDragged(MouseEvent e);

	@Override
	public abstract void mouseMoved(MouseEvent e);

}
