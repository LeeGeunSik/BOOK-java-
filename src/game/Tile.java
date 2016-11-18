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
		try {
			img = ImageIO.read(new File("Grass.jpg"));
		} catch (IOException e) {
			System.out.println("벽돌타일그림 불러오기 실패");
		}
		setX(x);
		setY(y);
	}

	@Override
	public void drawObj(Graphics g) {
		 g.drawImage(img, (int)x, (int)y, (int)getWidth(), (int)getHeight(), null);
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
