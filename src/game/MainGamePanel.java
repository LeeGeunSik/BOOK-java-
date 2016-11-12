package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainGamePanel extends JPanel implements KeyListener {
	ArrayList<Map> gameObj;// 맵에 존재하는 모든 객체를 모은 리스트
	ArrayList<Movable> movingObj;//움직이는 객체
	Player player;
	Wolf w;
	int[][] wallPos={{}};

	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		gameObj = new ArrayList<Map>();//리스트 생성
		movingObj = new ArrayList<Movable>();
//		for (int x = 0; x <= 1200; x = x + Tile.Width)
//			for (int y = 0; y <= 900; y = y + Tile.Height) {
//				gameObj.add(new Tile(x, y));// 리스트에 타일 객체 추가
//			}
		for (int x = 0; x <= 1200; x = x + 50)
			for (int y = 0; y <= 900; y = y + 50) {
				gameObj.add(new Tile(x, y));// 리스트에 타일 객체 추가
			}
		for (int x[] : wallPos) {
			for (int y : x) {
				gameObj.add(new Wall(x[0], y));
			}
		}
		addKeyListener(this);
		player = new Player();
		gameObj.add(player);// 플레이어 추가
		movingObj.add(player);
		w= new Wolf(50, 50);
		gameObj.add(w);
		movingObj.add(w);
		new Thread(new Timer(movingObj, this)).start();// 시간을 가게 하는 쓰레드 생성 및 시작
		new Thread(new Checker(gameObj)).start();;

	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		for (Map map : gameObj) {
			map.drawObj(arg0);// 모든 객체그림
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			player.setYspeed(-player.getSpeed());//위로간다.
			break;
		case KeyEvent.VK_DOWN:
			player.setYspeed(player.getSpeed());//밑으로 간다.
			break;
		case KeyEvent.VK_LEFT:
			player.setXspeed(-player.getSpeed());//왼쪽으로 간다.
			break;
		case KeyEvent.VK_RIGHT:
			player.setXspeed(player.getSpeed());//오른쪽으로 간다.
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			player.addYspeed(player.getSpeed());
			break;
		case KeyEvent.VK_DOWN:
			player.addYspeed(-player.getSpeed());
			break;
		case KeyEvent.VK_LEFT:
			player.addXspeed(player.getSpeed());
			break;
		case KeyEvent.VK_RIGHT:
			player.addXspeed(-player.getSpeed());
			break;

		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
