package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Timer implements Runnable {//�����̴� ��ü�� �޾Ƽ� �ð��� ���� �����̰� �ϴ� Ŭ����

	ArrayList<Movable> m;//�����̴� ��ü���� ����Ʈ
	MainGamePanel panel;//�����г�. ��ü���� �����δ��� repaint�� ȣ���ϱ� ����.

	public Timer(ArrayList<Movable> p,MainGamePanel panel) {
		// TODO �����̴� ��ü���� ����Ʈ�� �ް� �����г��� ���۷����� �޴´�.
		this.m = p;
		this.panel= panel;
	}

	@Override
	public void run() {
		// TODO �����ð����� ��ü���� �����̰� �г��� repaint�� ȣ���Ͽ� ȭ���� �����Ѵ�.
		while (true) {
			for (Movable obj : m) {
				obj.move();//��ü�� move�޼ҵ带 ȣ���Ͽ� ������.
			}
			panel.repaint();
			try {
				Thread.sleep(10);//0.01�� �Ͻ�����
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}

}
