package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainGamePanel extends JPanel implements KeyListener {
	private CreateObj gameWorld;
	private GameTime gameTime;
	private boolean gameStarted;
	private boolean gamePaused;
	JProgressBar timeBar;
	JLabel timeLabel;

	public boolean isGameStarted() {
		return gameStarted;
	}

	public boolean isGamePaused() {
		return gamePaused;
	}

	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		addKeyListener(this);
		setDoubleBuffered(true);
		this.timeLabel = timeLabel;
		this.timeBar = timeBar;

	}

	public void gameStart() {
		if (gameStarted) {
			gameWorld = new CreateObj();
		} else {
			gameWorld = new CreateObj();// 게임 월드 생성
			gameTime = new GameTime(gameWorld.getMovingObjects(), gameWorld.getAllObjects(), this);
			gameTime.start();
			gameStarted = true;
			gamePaused = false;
		}

	}

	public void gameStop() {
		gameTime.stop();
		gameStarted = false;
	}

	public void gamePause() {
		gameTime.suspend();
		gamePaused = true;
	}

	public void gameResume() {
		gameTime.resume();
		gamePaused = false;
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		if (gameStarted) {
			for (Tile t : gameWorld.getTile()) {
				t.drawObj(arg0);// 모든 타일 그림.
			}
			for (Map map : gameWorld.getAllObjects()) {
				map.drawObj(arg0);// 모든 객체그림
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (gameStarted && !gamePaused)
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

			default:
				break;
			}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (gameStarted && !gamePaused)
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
