package game;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Timer implements Runnable {// 움직이는 객체를 받아서 시간에 따라 움직이게 하는 클래스

	ArrayList<Movable> m;// 움직이는 객체들의 리스트
	MainGamePanel panel;// 게임패널. 객체들을 움직인다음 repaint를 호출하기 위함.
	ArrayList<Map> obj;// 모든 객체 리스트

	public Timer(ArrayList<Movable> p, ArrayList<Map> all, MainGamePanel panel) {
		// TODO 움직이는 객체들의 리스트를 받고 게임패널의 레퍼런스를 받는다.
		this.m = p;
		this.panel = panel;
		this.obj = all;
	}

	@Override
	public void run() {
		// TODO 일정시간마다 객체들을 움직이고 패널의 repaint를 호출하여 화면을 갱신한다.
		while (true) {
			for (Movable mobj : m) {
				mobj.moveX();// 객체의 move메소드를 호출하여 움직임.
				check();//객체들이 충돌하는지 검사
				mobj.backX();//충돌하면 다시 전위치로 이동
				mobj.moveY();
				check();
				mobj.backY();
			}
			panel.repaint();
			panel.requestFocus();
			try {
				Thread.sleep(10);// 0.01초 일시정지
			} catch (InterruptedException e) {
				// TODO: handle exception
			}

		}
	}

	public void check() {// 객체들의 충돌여부를 검사하는 메소드

		Map a, b;
		for (int i = 0; i < obj.size(); i++)
			for (int j = i + 1; j < obj.size(); j++) {// 모든 객체를 비교해 본다.
				a = obj.get(i);
				b = obj.get(j);
				if (a.equals(b)) {
					switch (a.toString()) {
					case "player":// 플레이어가
						if (b.toString() == "wolf"){// 늑대와 만났을때
							new JOptionPane().showMessageDialog(null, "게임오버");
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
//							System.out.println("늑대와 만남.");
						else if (b.toString() == "wall") {
							Player p;
							p = (Player) a;
							p.bumped = true;
						}
						break;
					case "wolf":
						if (b.toString() == "wall"){
							a.bumped = true;
						}
							break;

					default:
						break;

					}
				}

			}

	}

}
