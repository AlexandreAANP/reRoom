package main.memory;

import java.util.ArrayList;


import main.shapes.Shapes;
import main.windows.MainWindow;

public class MemoryList{

	private int maxThreads;
	public int counter;
	private int[] nThreads;
	
	public ArrayList<Shapes> list;
	
	public MemoryList(){
		this.maxThreads = 10;
		this.list = new ArrayList<Shapes>();
	}
	
	public static void main(String args[]) {
		MemoryList m = new MemoryList();
		m.counter = 1048;
		m.maxThreads = 20;
		m.calcThreads();
	}
	
	public int[] calcThreads() {
		if(this.counter < this.maxThreads) return null;
		
		int[] nThreads = new int[this.maxThreads];
		int size = this.counter;
		int perThreads = size/this.maxThreads;
		int miss = size - perThreads * this.maxThreads;
		
		for(int i = 0; i < this.maxThreads; i++) {
			if(miss >0)
				nThreads[i] = perThreads + 1;
			else
				nThreads[i] = perThreads;
			miss--;
		}
		return nThreads;
	}
	
	public void add(Shapes s) {
		this.list.add(s);
		this.counter++;
		this.nThreads = this.calcThreads();
	}
	
	public boolean remove(Shapes s) {
		boolean res = this.list.remove(s);
		this.counter--;
		this.nThreads = this.calcThreads();
		return res;
	}
	
	public void repaintAll() {
		//test time
		long start = System.nanoTime();
		//position, index of array refereces a Thread
		if(this.nThreads!=null) {
			int j =0;
			for(int sizelist: this.nThreads) {
				new ThreadPaint(
						new ArrayList<>(this.list.subList(j, j+sizelist)),
						MainWindow.get().getGraphics()).start();
				j += sizelist;
			}
		}else {
			for(Shapes s: this.list)
				s.repaint();
		}
		long end = System.nanoTime();
		System.out.println("NanoTIMING->"+(end-start));
		
	}
}
