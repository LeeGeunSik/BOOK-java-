package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends UnMovable {

	BufferedImage img;
	public static final int doorHeight = 20;
	public static final int doorWidth = 20;
	
	public Door(int x, int y) {
		// TODO Auto-generated constructor stub
		try{
			img = ImageIO.read(new File("test.png"));
		} 
		catch(IOException e){
			System.out.println("문그림 불러오기 실패");
		}
		setX(x);
		setY(y);
		setHeight(20);
		setWidth(20);
	}
		
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
	}
}
