package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Movable {

	BufferedImage player;
	public Player() {
		// TODO Auto-generated constructor stub
		setX(100);
		setY(100);
		setHeight(40);
		setWidth(40);
		try{
			player = ImageIO.read(new File("lamb.png"));//플레이어 이미지 불러오기
		} 
		catch(IOException e){
			System.out.println("플레이어 이미지 불러오기 실패");
		}
		setSpeed(2);//플레이어 속도
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(player, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);//자신을 그리는 메소드 Timer클래스에서 이 메소드를 호출한다.
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "player";
	}
}
