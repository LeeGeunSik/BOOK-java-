package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wolf extends Movable {
	BufferedImage wolf;
	public Wolf(int x, int y) {
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		try{
			wolf= ImageIO.read(new File("wolf.png")); 
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("����׸� �ҷ����� ����");
		}
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(wolf, getX(), getY(), getWidth(), getHeight(), null);
	}
	@Override
	public void move() {//������ �������� �����ϴ� �޼ҵ�
		// TODO Auto-generated method stub
	}

}
