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
			System.out.println("����Ÿ�ϱ׸� �ҷ����� ����");
		}
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
	}
}
