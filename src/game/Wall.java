package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends UnMovable{//�����̴� ���ϴ� ��ü. ���̴�.
	BufferedImage img;
	public Wall(int x, int y) {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("wall.png"));
		} catch (IOException e) {
			System.out.println("���׸� �ҷ����� ����");
		}
	}
}
