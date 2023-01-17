package main.calcShapes;

import java.awt.Point;

public interface calcShapes {
	Point getOrigin();
	Point getLastPoint();
	int getWidth();
	int getHeight();
	boolean inArea(Point p1);
}
