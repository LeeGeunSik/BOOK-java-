package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Timer implements Runnable {

	ArrayList<Movable> m;
	MainGamePanel panel;

	public Timer(ArrayList<Movable> p,MainGamePanel panel) {
		// TODO Auto-generated constructor stub
		this.m = p;
		this.panel= panel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			for (Movable obj : m) {
				obj.move();
			}
			panel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}

}
