package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile extends UnMovable {
	public static final int Height = 100;
	public static final int Width = 100;
	BufferedImage img;

	public Tile(int x, int y) {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("brick.png"));
		} catch (IOException e) {
			System.out.println("벽돌타일그림 불러오기 실패");
		}
		setX(x);
		setY(y);
		// setHeight(Height);
		// setWidth(Width);
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		// g.drawImage(img, getX(), getY(), Width, Height, null);
		g.drawRect((int)x, (int)y, (int)getWidth(), (int)getHeight());
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
