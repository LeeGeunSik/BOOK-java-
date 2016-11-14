package game;

public class Movable extends Map {
	private int xspeed;
	private int yspeed;
	private int speed;
	private int maxSpeed;
	protected int xpos, ypos;
	protected boolean bumped;// �ٸ� ��ü�� �ε������� ����.

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
		if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
			x = xpos;
			y = ypos;
			bumped = false;
		} else {
			xpos = x;// ���� ��ġ ����
			ypos = y;
			setX(x+xspeed);
			setY(y+yspeed);
		}
	}
	public void moveX() {
		if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
			x = xpos;
			bumped = false;
		} else {
			xpos = x;// ���� ��ġ ����
			setX(x+xspeed);
		}
	}
	public void moveY() {
		if (bumped == true) {// �ε������� �� ��ġ�� ���ư���.
			y = ypos;
			bumped = false;
		} else {
			ypos = y;
			setY(y+yspeed);
		}
		
	}

}
