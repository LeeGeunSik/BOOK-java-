package game;

public class Movable extends Map {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	private int direction;
	private int speed;

	public Movable() {
		// TODO Auto-generated constructor stub
		direction = DOWN;
		speed = 0;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(int direction) {
		if (direction <= RIGHT && direction >= UP)
			this.direction = direction;
	}

	public void move() {
		switch (direction) {
		case UP:
			setY(getY() - speed);
			break;
		case DOWN:
			setY(getY() + speed);
			break;
		case LEFT:
			setX(getX() - speed);
			break;
		case RIGHT:
			setX(getX() + speed);
			break;

		default:
			break;
		}
	}

}
