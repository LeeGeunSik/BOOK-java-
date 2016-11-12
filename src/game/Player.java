package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Movable {

	BufferedImage player;
	public Player() {
		// TODO Auto-generated constructor stub
		setX(300);
		setY(300);
		setHeight(50);
		setWidth(50);
		try{
			player = ImageIO.read(new File("lamb.png"));//�÷��̾� �̹��� �ҷ�����
		} 
		catch(IOException e){
			System.out.println("�÷��̾� �̹��� �ҷ����� ����");
		}
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(player, getX(), getY(), getWidth(), getHeight(), null);//�ڽ��� �׸��� �޼ҵ� TimerŬ�������� �� �޼ҵ带 ȣ���Ѵ�.
	}
}
