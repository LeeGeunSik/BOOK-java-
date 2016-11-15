package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Random;

import javax.imageio.ImageIO;

public class Wolf extends Movable {
	BufferedImage wolf;
	Random r;

	public Wolf(int x, int y) {
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		setHeight(45);
		setWidth(45);
		r = new Random();//������ �������� �ٲ��ֱ� ���� ������ü
		try {
			wolf = ImageIO.read(new File("wolf.png"));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("����׸� �ҷ����� ����");
		}
		changeDirection();//ó�� ���� ����
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(wolf, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
	}
	@Override
	public void backX() {
		// TODO Auto-generated method stub
		if (bumped) {//�ε������� �ٽ� ����ġ�� ���ư���.
			setX(xpos);
			changeDirection();//�׸��� ������ �ٲ��ش�.
			bumped = false;
		}
	}
	@Override
	public void backY() {
		// TODO Auto-generated method stub
		if (bumped) {//�ε������� �ٽ� ����ġ�� ���ư���.
			setY(ypos);
			changeDirection();//�׸��� ������ �ٲ��ش�.
			bumped = false;
		}
		
	}
	private void changeDirection() {//������ ������ �ٲ��ִ� �޼ҵ�
		switch (r.nextInt(4)) {//0~3�� �������� ����
		case 0:
			xspeed = 2;
			yspeed = 0;
			break;
		case 1:
			xspeed = -2;
			yspeed = 0;
			break;
		case 2:
			xspeed = 0;
			yspeed = 2;
			break;

		default:
			xspeed = 0;
			yspeed = -2;
			break;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "wolf";
	}
}
