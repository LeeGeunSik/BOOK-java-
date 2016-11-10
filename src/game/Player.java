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
		setX(0);
		setY(0);
		setHeight(60);
		setWidth(60);
		try{
			player = ImageIO.read(new File("lamb.png"));
		} 
		catch(IOException e){
			System.out.println("플레이어 이미지 불러오기 실패");
		}
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(player, getX(), getY(), getWidth(), getHeight(), null);
	}
}
