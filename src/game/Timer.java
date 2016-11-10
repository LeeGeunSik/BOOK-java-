package game;

public class Timer implements Runnable {

	Player p;
	MainGamePanel g;

	public Timer(Player p,MainGamePanel g) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.g= g;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			p.move();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			g.repaint();
		}
	}

}
