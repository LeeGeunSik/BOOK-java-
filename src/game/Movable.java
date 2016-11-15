package game;

import java.util.ArrayList;

public class Movable extends Map {
	protected int xspeed,yspeed,speed,maxSpeed;
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


	public void moveX() {
		xpos = x;//이전 위치 저장후 이동
		setX(x + xspeed);

	}

	public void moveY() {
		ypos = y;//이전 위치 저장후 이동
		setY(y + yspeed);
	}

	public void backX() {
		if (bumped) {//부딪혔으면 다시 전위치로 돌아간다.
			setX(xpos);
			bumped = false;
		}
	}

	public void backY() {
		if (bumped) {//부딪혔으면 다시 전위치로 돌아간다.
			setY(ypos);
			bumped = false;
		}
	}
}
