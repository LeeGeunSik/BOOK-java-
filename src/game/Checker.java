package game;

import java.util.ArrayList;

public class Checker implements Runnable {

	ArrayList<Map> obj;

	public Checker(ArrayList<Map> obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;//�ʿ� �����ϴ� ��� ��ü�� ������ �ִ� ����Ʈ
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			for (int i = 0; i < obj.size(); i++)
				for (int j = i + 1; j < obj.size(); j++) {//��� ��ü�� ���� ����.
					if (obj.get(i).equals(obj.get(j)))
						System.out.println("!!!");
				}
		}

	}

}
