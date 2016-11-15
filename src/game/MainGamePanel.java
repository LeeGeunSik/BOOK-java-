package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainGamePanel extends JPanel implements KeyListener {
	ArrayList<Map> gameObj;// 맵에 존재하는 모든 객체를 모은 리스트
	ArrayList<Movable> movingObj;//움직이는 객체
	ArrayList<Tile> tile;//타일만 모아두는 리스트.
	Player player;
	Wolf w;
	int[][] wallPos={{0,0},{0,2},{0,3},{0,4},{0,5},{0,6},{0,12},{0,13},{0,14},{0,15},{0,21},{0,22},{0,23},
			{1,0},{1,2},{1,3},{1,8},{1,9},{1,10},{1,17},{1,18},{1,19},{1,21},{1,22},{1,23},
			{2,5},{2,6},{2,10},{2,12},{2,13},{2,14},{2,15},{2,17},{2,18},{2,23},
			{3,1},{3,2},{3,3},{3,5},{3,6},{3,7},{3,8},{3,10},{3,12},{3,13},{3,14},{3,15},{3,20},{3,21},{3,23},
			{4,1},{4,2},{4,3},{4,12},{4,13},{4,14},{4,15},{4,16},{4,18},{4,19},{4,20},{4,21},{4,23},
			{5,5},{5,6},{5,7},{5,8},{5,10},{5,12},{5,13},{5,14},{5,15},{5,16},{5,18},{5,19},{5,20},{5,23},
			{6,0},{6,1},{6,2},{6,3},{6,5},{6,6},{6,7},{6,8},{6,10},{6,14},{6,15},{6,18},{6,19},{6,22},{6,23},
			{7,0},{7,1},{7,5},{7,6},{7,7},{7,8},{7,10},{7,11},{7,12},{7,14},{7,15},{7,17},{7,18},{7,19},{7,21},{7,22},{7,23},
			{8,0},{8,1},{8,3},{8,4},{8,5},{8,6},{8,7},{8,12},{8,14},{8,15},{8,21},{8,22},{8,23},
			{9,9},{9,10},{9,12},{9,14},{9,15},{9,16},{9,17},{9,18},{9,20},{9,21},{9,22},{9,23},
			{10,0},{10,2},{10,3},{10,4},{10,5},{10,7},{10,9},{10,10},{10,15},{10,20},{10,21},{10,22},{10,23},
			{11,0},{11,4},{11,7},{11,9},{11,10},{11,11},{11,13},{11,17},{11,18},{11,20},{11,21},{11,22},
			{12,0},{12,1},{12,2},{12,4},{12,6},{12,7},{12,9},{12,13},{12,14},{12,15},{12,16},{12,17},{12,22},
			{13,0},{13,1},{13,2},{13,4},{13,6},{13,7},{13,11},{13,12},{13,13},{13,16},{13,17},{13,18},{13,19},{13,20},
			{14,6},{14,7},{14,9},{14,15},{14,16},{14,17},{14,18},{14,19},{14,22},{14,23},
			{15,0},{15,1},{15,3},{15,4},{15,5},{15,6},{15,7},{15,9},{15,10},{15,11},{15,12},{15,14},{15,15},{15,16},{15,17},{15,18},{15,19},{15,21},{15,22},{15,23},
			{16,0},{16,9},{16,10},{16,11},{16,12},{16,15},{16,16},{16,17},{16,18},{16,19},{16,21},
			{17,0},{17,1},{17,3},{17,4},{17,5},{17,6},{17,8},{17,9},{17,10},{17,11},{17,12},{17,13},{17,15},{17,16},{17,17},{17,18},{17,19},{17,23}};

	public MainGamePanel() {
		// TODO Auto-generated constructor stub
		gameObj = new ArrayList<Map>();//리스트 생성
		movingObj = new ArrayList<Movable>();
		tile = new ArrayList<Tile>();
		for (int x = 0; x <= 1200; x = x + 50)
			for (int y = 0; y <= 900; y = y + 50) {
				tile.add(new Tile(x, y));// 리스트에 타일 객체 추가
			}
		player = new Player();
		gameObj.add(player);// 플레이어 추가
		movingObj.add(player);
		addKeyListener(this);		
		w= new Wolf(500, 400);
		gameObj.add(w);
		movingObj.add(w);
		for(int i=0;i<wallPos.length;i++)
			gameObj.add(new Wall(wallPos[i][1]*Map.offset, wallPos[i][0]*Map.offset));
		new Thread(new Timer(movingObj, gameObj,this)).start();// 시간을 가게 하는 쓰레드 생성 및 시작
		setDoubleBuffered(true);

	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		for (Tile t : tile) {
			t.drawObj(arg0);
		}
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
