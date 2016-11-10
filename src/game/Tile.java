package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile extends UnMovable{

	BufferedImage img;
	public static final int Height = 100;
	public static final int Width = 100;
	public Tile(int x, int y) {
		// TODO Auto-generated constructor stub
		try{
			img = ImageIO.read(new File("brick.png"));
		} 
		catch(IOException e){
			System.out.println("벽돌타일그림 불러오기 실패");
		}
		setX(x);
		setY(y);
		setHeight(Height);
		setWidth(Width);
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
	}
}
