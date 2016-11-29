package game;

import java.awt.Graphics;

public class TurningPt extends UnMovable{

	@Override
	public void drawObj(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, width, height);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TurningPt";
	}
}
