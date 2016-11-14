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
		setX(100);
		setY(100);
		setHeight(40);
		setWidth(40);
		try{
			player = ImageIO.read(new File("lamb.png"));//�÷��̾� �̹��� �ҷ�����
		} 
		catch(IOException e){
			System.out.println("�÷��̾� �̹��� �ҷ����� ����");
		}
		setSpeed(2);//�÷��̾� �ӵ�
	}
	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		super.drawObj(g);
		g.drawImage(player, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);//�ڽ��� �׸��� �޼ҵ� TimerŬ�������� �� �޼ҵ带 ȣ���Ѵ�.
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "player";
	}
}
