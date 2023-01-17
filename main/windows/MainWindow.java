package main.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;

import main.mouses.MCreate;
import main.mouses.MMouse;
import main.shapes.Shapes;
import main.shapes.Square;

public class MainWindow extends JFrame implements Runnable{
	private static final long serialVersionUID = 1282528674017875258L;
	
	private static MainWindow instance;
	private int width;
	private int height;
	private String title;
	private MCreate mouse;
	public LinkedList<Shapes> memory;
	
	public Graphics g;
	
	
	private MainWindow() {
		this.width = 1920;
		this.height = 1080;
		this.title = "reRoom_ALPHA";
		this.mouse = MCreate.get();
		this.memory = new LinkedList<>();
	}
	

	public static MainWindow get() {
		if(instance == null)
			instance = new MainWindow();
		return instance;
	}
	
	public void changeMouse(MMouse mouse) {
		this.removeMouseListener(this.getMouseListeners()[0]);
		this.removeMouseMotionListener(this.getMouseMotionListeners()[0]);
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.setCursor(mouse.getCursor());
	}
	
	public void init() {

		this.setTitle(this.title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add mouse listener
		this.addMouseListener(this.mouse);
		this.addMouseMotionListener(this.mouse);
		
		this.setResizable(false);
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setBackground(Color.WHITE);
		
		this.setVisible(true);
		this.pack();
	
	}
	
	public void loop() {
		while(true) {
			
		}
	}
	
	//TODO create a multithread proccess to draw the Squares
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(this.memory.size()==0)
			return;
		for(Shapes s: this.memory) {
			s.repaint();
		}

	}
	
	@Override
	public void run() {
		this.init();
		//this.loop();
	}

}
