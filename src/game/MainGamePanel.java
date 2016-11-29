package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainGamePanel extends JPanel implements KeyListener {
	private CreateObj gameWorld;
	private GameTime gameTime;
	private boolean gameStarted;
	private boolean gamePaused;
	private boolean gameHasStarted;
	MainFrame m;
	BufferedImage img;

	public boolean isGameStarted() {
		return gameStarted;
	}

	public boolean isGamePaused() {
		return gamePaused;
	}

	public MainGamePanel(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("Game_Over.jpg"));
		} catch (IOException e) {
			System.out.println("게임오버 이미지 불러오기 실패");
		}
		m=mainFrame;
		addKeyListener(this);
		setDoubleBuffered(false);

	}

	public void gameStart() {
		if (gameStarted) {//게임이 시작된 상태이면
			gameWorld = new CreateObj();
		} else {//게임을 처음 시작할때 또는 게임이 종료되고 다시시작할때
			gameWorld = new CreateObj();// 게임 월드 생성
			m.timeBar.setValue(11);//다시시작할때 timeBar의 값이 0이기 때문에 화면에 0이 표시된다. 그걸 방지하기 위함.
			gameTime = new GameTime(gameWorld.getMovingObjects(), gameWorld.getAllObjects(), this);
			gameTime.start();
			gameStarted = true;
			gamePaused = false;
		}
		gameHasStarted = true;

	}

	public void gameStop() {
		gameStarted = false;
		gameTime.stop();
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
			if(m.timeBar.getValue()<10){
				arg0.setFont(new Font("고딕", Font.BOLD, 500));
				arg0.drawString(m.timeBar.getValue()+"", 450, 600);
			}
		}
		else if(gameHasStarted){
			arg0.drawImage(img, 0, 0, 1250, 1000, null);
		}			
	}

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
