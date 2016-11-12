package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Timer implements Runnable {//움직이는 객체를 받아서 시간에 따라 움직이게 하는 클래스

	ArrayList<Movable> m;//움직이는 객체들의 리스트
	MainGamePanel panel;//게임패널. 객체들을 움직인다음 repaint를 호출하기 위함.

	public Timer(ArrayList<Movable> p,MainGamePanel panel) {
		// TODO 움직이는 객체들의 리스트를 받고 게임패널의 레퍼런스를 받는다.
		this.m = p;
		this.panel= panel;
	}

	@Override
	public void run() {
		// TODO 일정시간마다 객체들을 움직이고 패널의 repaint를 호출하여 화면을 갱신한다.
		while (true) {
			for (Movable obj : m) {
				obj.move();//객체의 move메소드를 호출하여 움직임.
			}
			panel.repaint();
			try {
				Thread.sleep(10);//0.01초 일시정지
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}

}
