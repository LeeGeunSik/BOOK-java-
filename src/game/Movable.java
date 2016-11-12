package game;

public class Movable extends Map {
	private int xspeed;
	private int yspeed;
	private int speed;
	private int maxSpeed;

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
		setX(getX() + xspeed);
		setY(getY() + yspeed);
	}

}
