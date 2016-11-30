package game;

import java.awt.Graphics;

public class TurningPt extends UnMovable {

	public TurningPt(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		//g.drawRect(x, y, width, height);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TurningPt";
	}
}
