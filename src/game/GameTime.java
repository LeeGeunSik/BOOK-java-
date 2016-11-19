package game;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class GameTime extends Thread {// �����̴� ��ü�� �޾Ƽ� �ð��� ���� �����̰� �ϴ� Ŭ����

	private ArrayList<Movable> m;// �����̴� ��ü���� ����Ʈ
	private MainGamePanel panel;// �����г�. ��ü���� �����δ��� repaint�� ȣ���ϱ� ����.
	private ArrayList<Map> obj;// ��� ��ü ����Ʈ

	public GameTime(ArrayList<Movable> p, ArrayList<Map> all, MainGamePanel panel) {
		// TODO �����̴� ��ü���� ����Ʈ�� �ް� �����г��� ���۷����� �޴´�.
		this.m = p;
		this.panel = panel;
		this.obj = all;
	}

	@Override
	public void run() {
		// TODO �����ð����� ��ü���� �����̰� �г��� repaint�� ȣ���Ͽ� ȭ���� �����Ѵ�.
		while (true) {
			for (Movable mobj : m) {
				mobj.moveX();// ��ü�� move�޼ҵ带 ȣ���Ͽ� ������.
				check();//��ü���� �浹�ϴ��� �˻�
				mobj.backX();//�浹�ϸ� �ٽ� ����ġ�� �̵�
				mobj.moveY();
				check();
				mobj.backY();
			}
			panel.repaint();
			if(!panel.isFocusOwner())
				panel.requestFocus();
			try {
				Thread.sleep(10);// 0.01�� �Ͻ�����
			} catch (InterruptedException e) {
				// TODO: handle exception
			}

		}
	}

	public void check() {// ��ü���� �浹���θ� �˻��ϴ� �޼ҵ�

		Map a, b;
		for (int i = 0; i < m.size(); i++)
			for (int j = i + 1; j < obj.size(); j++) {// ��� ��ü�� ���� ����.
				a = obj.get(i);
				b = obj.get(j);
				if (a.equals(b)) {
					switch (a.toString()) {
					case "player":// �÷��̾
						if (b.toString() == "wolf"){// ����� ��������
							new JOptionPane().showMessageDialog(null, "���ӿ���");
							panel.gameStop();//�����带 ���δ�.
							
						}
						else if (b.toString() == "wall") {
							Player p;
							p = (Player) a;
							p.bumped = true;
						}
						break;
					case "wolf":
						if (b.toString() == "wall"){
							a.bumped = true;
						}
							break;

					default:
						break;

					}
				}

			}

	}

}