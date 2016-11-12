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
			System.out.println("늑대그림 불러오기 실패");
		}
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(wolf, getX(), getY(), getWidth(), getHeight(), null);
	}
	@Override
	public void move() {//늑대의 움직임을 정의하는 메소드
		// TODO Auto-generated method stub
	}

}
