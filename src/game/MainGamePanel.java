package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainGamePanel extends JPanel implements KeyListener {
	ArrayList<Map> gameObj;
	Player player;

	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		gameObj = new ArrayList<Map>();
		for (int x = 0; x < 800; x = x + Tile.Width)
			for (int y = 0; y < 800; y = y + Tile.Height) {
				gameObj.add(new Tile(x, y));
			}
		addKeyListener(this);
		player = new Player();
		gameObj.add(player);
		Thread t = new Thread(new Timer(player,this));
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
			player.setYspeed(-player.getSpeed());
			break;
		case KeyEvent.VK_DOWN:
			player.setYspeed(player.getSpeed());
			break;
		case KeyEvent.VK_LEFT:
			player.setXspeed(-player.getSpeed());
			break;
		case KeyEvent.VK_RIGHT:
			player.setXspeed(player.getSpeed());
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
