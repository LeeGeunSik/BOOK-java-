package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListner implements KeyListener {

	Movable player;

	public KeyListner(Movable a) {
		// TODO Auto-generated constructor stub
		player = a;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			player.addYspeed(-player.getSpeed());
			break;
		case KeyEvent.VK_DOWN:
			player.addYspeed(player.getSpeed());
			break;
		case KeyEvent.VK_LEFT:
			player.addXspeed(-player.getSpeed());
			break;
		case KeyEvent.VK_RIGHT:
			player.addXspeed(player.getSpeed());
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
			player.addYspeed(player.getSpeed());
			break;
		case KeyEvent.VK_RIGHT:
			player.addYspeed(-player.getSpeed());
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
