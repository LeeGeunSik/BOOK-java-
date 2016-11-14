package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Timer implements Runnable {//�����̴� ��ü�� �޾Ƽ� �ð��� ���� �����̰� �ϴ� Ŭ����

	ArrayList<Movable> m;//�����̴� ��ü���� ����Ʈ
	MainGamePanel panel;//�����г�. ��ü���� �����δ��� repaint�� ȣ���ϱ� ����.
	ArrayList<Map> obj;//��� ��ü ����Ʈ

	public Timer(ArrayList<Movable> p,ArrayList<Map> all,MainGamePanel panel) {
		// TODO �����̴� ��ü���� ����Ʈ�� �ް� �����г��� ���۷����� �޴´�.
		this.m = p;
		this.panel= panel;
		this.obj = all;
	}

	@Override
	public void run() {
		// TODO �����ð����� ��ü���� �����̰� �г��� repaint�� ȣ���Ͽ� ȭ���� �����Ѵ�.
		while (true) {
			for (Movable obj : m) {
				obj.moveX();//��ü�� move�޼ҵ带 ȣ���Ͽ� ������.
				check();
				obj.moveX();
				obj.moveY();
				check();
				obj.moveY();
			}
			panel.repaint();
			try {
				Thread.sleep(10);//0.01�� �Ͻ�����
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	public void check() {//��ü���� �浹���θ� �˻��ϴ� �޼ҵ�

		Map a,b;
		for (int i = 0; i < obj.size(); i++)
			for (int j = i + 1; j < obj.size(); j++) {// ��� ��ü�� ���� ����.
				a=obj.get(i);
				b=obj.get(j);
				if (a.equals(b)) {
					switch (a.toString()) {
					case "player":// �÷��̾
						Player p;
						if (b.toString() == "wolf")// ����� ��������
							System.out.println("you die.");
						else if (b.toString() == "wall") {
							p = (Player) a;
							p.bumped = true;
						}
						break;
					case "wolf":
						if (b.toString() == "turningPt")

							break;

					default:
						break;

					}
				}

			}
	
	}

}
