package game;

import java.util.ArrayList;

public class Movable extends Map {
	private int xspeed;
	private int yspeed;
	private int speed;
	private int maxSpeed;
	protected int xpos, ypos;
	

	public Movable() {
		// TODO Auto-generated constructor stub
		xspeed = 0;
		yspeed = 0;
		speed = 2;
		maxSpeed = 3;
		bumped = false;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed <= maxSpeed)
			this.speed = speed;
	}

	public int getXspeed() {
		return xspeed;
	}

	public void addXspeed(int xspeed) {
		if (this.xspeed + xspeed <= maxSpeed)
			this.xspeed += xspeed;
		else
			this.xspeed = maxSpeed;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void addYspeed(int yspeed) {
		if (this.yspeed + yspeed <= maxSpeed)
			this.yspeed += yspeed;
		else
			this.yspeed = maxSpeed;
	}

	public void setXspeed(int xspeed) {
		if (xspeed <= maxSpeed)
			this.xspeed = xspeed;
		else
			this.xspeed = maxSpeed;
	}

	public void setYspeed(int yspeed) {
		if (yspeed <= maxSpeed)
			this.yspeed = yspeed;
		else
			this.yspeed = maxSpeed;
	}

	public void move() {
		if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
			if (xspeed != 0)
				x = xpos;
			if (yspeed != 0)
				y = ypos;
			bumped = false;
		} else {
			xpos = x;// ���� ��ġ ����
			ypos = y;
			setX(x + xspeed);
			setY(y + yspeed);
		}
	}

	public void moveX() {
		if (checked == true) {
			if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
				setX(x-xspeed);
				bumped = false;
				checked = false;
			}
			else
				checked = false;
		} else {
			setX(x + xspeed);
		}

	}

	public void moveY() {
		if (checked == true) {
			if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
				setY(y-yspeed);
				bumped = false;
				checked = false;
			}
			else
				checked = false;
		} else {
			setY(y + yspeed);
		}
	}
}
