package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Switch extends UnMovable{
	BufferedImage img;
	public Switch() {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("brick.png"));
		} catch (IOException e) {
			System.out.println("스위치그림 불러오기 실패");
		}
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
	}
}
