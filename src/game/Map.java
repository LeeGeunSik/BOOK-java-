package game;

import java.awt.Graphics;

public class Map {
	private int x, y, width, height, maxX, maxY;
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x >= 0 && x <= maxX)
			this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= 0 && y <= maxY)
			this.y = y;
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
		maxX = 500;
		maxY = 500;
	}

	public void drawObj(Graphics g) {
	}
}
