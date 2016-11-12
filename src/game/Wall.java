package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends UnMovable{//움직이는 못하는 객체. 벽이다.
	BufferedImage img;
	public Wall(int x, int y) {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("wall.png"));
		} catch (IOException e) {
			System.out.println("벽그림 불러오기 실패");
		}
	}
}
