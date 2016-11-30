package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Switch extends UnMovable {
	BufferedImage imgon;
	BufferedImage imgoff;
	public boolean onOff;

	public Switch(int x, int y) {
		// TODO Auto-generated constructor stub
		try {
			imgon = ImageIO.read(new File("on.png"));
			imgoff = ImageIO.read(new File("off.png"));
		} catch (IOException e) {
			System.out.println("스위치그림 불러오기 실패");
		}
		width = 20;
		height = 20;
		onOff = false;
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		if(onOff)
//			g.drawImage(imgon, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
			g.drawString("ssssss", x, y);
		else
//			g.drawImage(imgoff, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
			g.drawString("tttttttttt", x, y);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "switch";
	}
}
