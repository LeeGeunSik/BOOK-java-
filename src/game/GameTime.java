package game;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class GameTime extends Thread {// 움직이는 객체를 받아서 시간에 따라 움직이게 하는 클래스

	private ArrayList<Movable> m;// 움직이는 객체들의 리스트
	private MainGamePanel panel;// 게임패널. 객체들을 움직인다음 repaint를 호출하기 위함.
	private ArrayList<Map> obj;// 모든 객체 리스트

	public GameTime(ArrayList<Movable> p, ArrayList<Map> all, MainGamePanel panel) {
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
				check();// 객체들이 충돌하는지 검사
				mobj.backX();// 충돌하면 다시 전위치로 이동
				mobj.moveY();
				check();
				mobj.backY();
			}
			panel.repaint();
			if (!panel.isFocusOwner())
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
		for (int i = 0; i < m.size(); i++)
			for (int j = i + 1; j < obj.size(); j++) {// 모든 객체를 비교해 본다.
				a = obj.get(i);
				b = obj.get(j);
				if (a.equals(b)) {
					switch (a.toString()) {
					case "player":// 플레이어가
						if (b.toString() == "wolf") {// 늑대와 만났을때
							panel.gameStop();
						} else if (b.toString() == "wall") {
							Player p;
							p = (Player) a;
							p.bumped = true;
						} else if (b.toString() == "switch") {
							Switch s;
							s = (Switch) b;
							s.onOff = true;
						} else if (b.toString() == "door") {
							Door d;
							d= (Door)b;
							if(d.open){
								new JOptionPane().showMessageDialog(null, "게임 승리!!");
								panel.gameStop();
							}
							else{
								Player p;
								p = (Player) a;
								p.bumped = true;
							}
						}
						break;
					case "wolf":
						if (b.toString() == "wall") {
							a.bumped = true;
						} else if (b.toString() == "TurningPt") {
							if (a.x == b.x && a.y == b.y) {
								Wolf w;
								w = (Wolf) a;
								w.turn();
							}
						}
						break;

					default:
						break;

					}
				}
			}
		Switch s=null;
		Door d=null;
		for (Map map : obj) {
			if (map.toString() == "switch")
				s = (Switch) map;
			if (map.toString() == "door")
				d = (Door) map;
		}
		if (s.onOff)
			d.open = true;
	}
	
}
