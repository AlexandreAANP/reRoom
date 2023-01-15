package main;

import main.windows.MainWindow;

public class Main {

	public static void main (String args[]) {
		MainWindow window = MainWindow.get();
		//window.init();
		window.run();
	}
}
