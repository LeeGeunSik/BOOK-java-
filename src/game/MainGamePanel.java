package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainGamePanel extends JPanel implements KeyListener {
	ArrayList<Map> gameObj;
	Player p;

	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		gameObj = new ArrayList<Map>();
		for (int x = 0; x < 800; x = x + Tile.Width)
			for (int y = 0; y < 800; y = y + Tile.Height) {
				gameObj.add(new Tile(x, y));
			}
		gameObj.add(new Door(0, 0));
		gameObj.add(new Door(10, 10));
		addKeyListener(this);
		p = new Player();
		gameObj.add(p);
		Thread t = new Thread(new Timer(p,this));
		t.start();

	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		for (Map map : gameObj) {
			map.drawObj(arg0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			p.setDirection(Movable.UP);
			p.setSpeed(5);
			break;
		case KeyEvent.VK_DOWN:
			p.setDirection(Movable.DOWN);
			p.setSpeed(5);
			break;
		case KeyEvent.VK_LEFT:
			p.setDirection(Movable.LEFT);
			p.setSpeed(5);
			break;
		case KeyEvent.VK_RIGHT:
			p.setDirection(Movable.RIGHT);
			p.setSpeed(5);
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		p.setSpeed(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}
