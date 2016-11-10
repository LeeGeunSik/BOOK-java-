package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListner implements KeyListener {

	Movable obj;

	public KeyListner(Movable a) {
		// TODO Auto-generated constructor stub
		obj = a;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			obj.setDirection(Movable.UP);
			obj.setSpeed(20);
			break;
		case KeyEvent.VK_DOWN:
			obj.setDirection(Movable.DOWN);
			obj.setSpeed(20);
			break;
		case KeyEvent.VK_LEFT:
			obj.setDirection(Movable.LEFT);
			obj.setSpeed(20);
			break;
		case KeyEvent.VK_RIGHT:
			obj.setDirection(Movable.RIGHT);
			obj.setSpeed(20);
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		obj.setSpeed(0);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
