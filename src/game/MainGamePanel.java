package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainGamePanel extends JPanel implements KeyListener {
	CreateObj gameWorld;
	Thread gameTime;
	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		gameWorld = new CreateObj();//게임 월드 생성
		addKeyListener(this);		
		gameTime = new Thread(new Timer(gameWorld.getMovingObjects(), gameWorld.getAllObjects(),this));// 시간을 가게 하는 쓰레드 생성 및 시작
		gameTime.start();
		setPreferredSize(new Dimension(50*25,50*19));
		setDoubleBuffered(true);

	}
	public void timeStop() {
		gameTime.stop();
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);//패널이 지워짐.
		for (Tile t : gameWorld.getTile()) {
			t.drawObj(arg0);//모든 타일 그림.
		}
		for (Map map : gameWorld.getAllObjects()) {
			map.drawObj(arg0);// 모든 객체그림
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			gameWorld.playerUp();
			break;
		case KeyEvent.VK_DOWN:
			gameWorld.playerDown();
			break;
		case KeyEvent.VK_LEFT:
			gameWorld.playerLeft();
			break;
		case KeyEvent.VK_RIGHT:
			gameWorld.playerRight();
			break;
		case KeyEvent.VK_SPACE:
			gameTime.suspend();
			break;
		case KeyEvent.VK_CONTROL :
			gameTime.resume();

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			gameWorld.playerUpStop();
			break;
		case KeyEvent.VK_DOWN:
			gameWorld.playerDownStop();
			break;
		case KeyEvent.VK_LEFT:
			gameWorld.playerLeftStop();
			break;
		case KeyEvent.VK_RIGHT:
			gameWorld.playerRightStop();
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
