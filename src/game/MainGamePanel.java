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
			System.out.println("���ӿ��� �̹��� �ҷ����� ����");
		}
		m=mainFrame;
		addKeyListener(this);
		setDoubleBuffered(false);

	}

	public void gameStart() {
		if (gameStarted) {//������ ���۵� �����̸�
			gameWorld = new CreateObj();
		} else {//������ ó�� �����Ҷ� �Ǵ� ������ ����ǰ� �ٽý����Ҷ�
			gameWorld = new CreateObj();// ���� ���� ����
			m.timeBar.setValue(11);//�ٽý����Ҷ� timeBar�� ���� 0�̱� ������ ȭ�鿡 0�� ǥ�õȴ�. �װ� �����ϱ� ����.
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
				t.drawObj(arg0);// ��� Ÿ�� �׸�.
			}
			for (Map map : gameWorld.getAllObjects()) {
				map.drawObj(arg0);// ��� ��ü�׸�
			}
			if(m.timeBar.getValue()<10){
				arg0.setFont(new Font("���", Font.BOLD, 500));
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
