package main.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.util.LinkedList;

import javax.swing.JFrame;


import main.mouses.Mouse01;
import main.shapes.Square;

public class MainWindow extends JFrame implements Runnable{
	private static final long serialVersionUID = 1282528674017875258L;
	
	private static MainWindow instance;
	private int width;
	private int height;
	private String title;
	private Mouse01 mouse;
	public LinkedList<Square> memory;
	
	public Graphics g;
	
	
	private MainWindow() {
		this.width = 1920;
		this.height = 1080;
		this.title = "reRoom_Beta";
		this.mouse = Mouse01.get();
		this.memory = new LinkedList<>();
	}
	

	public static MainWindow get() {
		if(instance == null)
			instance = new MainWindow();
		return instance;
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
		for(Square s: this.memory) {
			s.draw(g);
		}

	}
	
	@Override
	public void run() {
		this.init();
		//this.loop();
	}

}
