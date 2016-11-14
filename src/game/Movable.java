package game;

public class Movable extends Map {
	private int xspeed;
	private int yspeed;
	private int speed;
	private int maxSpeed;
	protected int xpos, ypos;
	protected boolean bumped;// 다른 객체와 부딪혔는지 여부.

	public Movable() {
		// TODO Auto-generated constructor stub
		xspeed = 0;
		yspeed = 0;
		speed = 2;
		maxSpeed = 3;
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
			x = xpos;
			y = ypos;
			bumped = false;
		} else {
			xpos = x;// 이전 위치 저장
			ypos = y;
			setX(x+xspeed);
			setY(y+yspeed);
		}
	}
	public void moveX() {
		if (bumped == true) {// 부딪혔으면 전 위치로 돌아간다.
			x = xpos;
			bumped = false;
		} else {
			xpos = x;// 이전 위치 저장
			setX(x+xspeed);
		}
	}
	public void moveY() {
		if (bumped == true) {// 부딪혔으면 전 위치로 돌아간다.
			y = ypos;
			bumped = false;
		} else {
			ypos = y;
			setY(y+yspeed);
		}
		
	}

}
