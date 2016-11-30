package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends UnMovable {

	BufferedImage img;
	public boolean open;
	private int count,imgcount;
	public static final int doorHeight = 20;
	public static final int doorWidth = 20;

	public Door(int x, int y) {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("door.png"));
		} catch (IOException e) {
			System.out.println("문그림 불러오기 실패");
		}
		setX(x);
		setY(y);
		setHeight(50);
		setWidth(50);
		open = false;
		this.x = x;
		this.y = y;
		imgcount = 0;
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		
		if(open&&count<30)
			count++;	
		imgcount = count/10;
		g.drawImage(img, x, y, x+width, y+height,0, 64*imgcount, 64, 64*(imgcount+1), null);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "door";
	}
}
