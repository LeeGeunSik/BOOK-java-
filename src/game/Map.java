package game;

import java.awt.Graphics;

public class Map {
	protected int x;
	protected int y;
	static final int offset = 50;
	private int width;
	private int height;
	private int maxX;
	private int maxY;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x >= 0 && x <= maxX)// 최대 x값을 넘지 못한다.
			this.x = x;
		else if (x <= 0)
			this.x = 0;
		else
			this.x = maxX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= 0 && y <= maxY)// 최대 y값을 넘지 못한다.
			this.y = y;
		else if (y <= 0)
			this.y = 0;
		else
			this.y = maxY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
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
		g.drawRect(x, y, width, height);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Map m = (Map)obj;
		if(Math.abs(m.x-this.x)<width&&Math.abs(m.y-this.y)<height)
			return true;
		return false;
	}
}
