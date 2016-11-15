package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Map extends Rectangle{
	static final int offset = 50;
	private int maxX;
	private int maxY;
	protected boolean bumped, checked;// �ٸ� ��ü�� �ε������� ����.


	public void setX(int x) {
		if (x >= 0 && x <= maxX)// �ִ� x���� ���� ���Ѵ�.
			this.x = x;
		else if (x <= 0)
			this.x = 0;
		else
			this.x = maxX;
	}

	public void setY(int y) {
		if (y >= 0 && y <= maxY)// �ִ� y���� ���� ���Ѵ�.
			this.y = y;
		else if (y <= 0)
			this.y = 0;
		else
			this.y = maxY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Map() {
		// TODO Auto-generated constructor stub
		maxX = 1200;
		maxY = 900;
		width = offset;
		height = offset;
	}

	public void drawObj(Graphics g) {
//		g.drawRect(x, y, width, height);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Map m = (Map)obj;
		return intersects(m);
	}
}
