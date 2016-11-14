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
		if (bumped == true) {// 부딪혔으면 전 위치로 돌아간다.
			if (xspeed != 0)
				x = xpos;
			if (yspeed != 0)
				y = ypos;
			bumped = false;
		} else {
			xpos = x;// 이전 위치 저장
			ypos = y;
			setX(x + xspeed);
			setY(y + yspeed);
		}
	}

	public void moveX() {
		if (checked == true) {
			if (bumped == true) {// 부딪혔으면 전 위치로 돌아간다.
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
			if (bumped == true) {// 부딪혔으면 전 위치로 돌아간다.
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
