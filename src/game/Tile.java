package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile extends UnMovable {
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
		g.drawString(""+y/50+","+x/50, x+10, y+10);
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
