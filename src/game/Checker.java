package game;

import java.util.ArrayList;

public class Checker implements Runnable {

	ArrayList<Map> obj;

	public Checker(ArrayList<Map> obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;// 맵에 존재하는 모든 객체를 가지고 있는 리스트
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			for (int i = 0; i < obj.size(); i++)
				for (int j = i + 1; j < obj.size(); j++) {// 모든 객체를 비교해 본다.
					if (obj.get(i).equals(obj.get(j))) {
						switch (obj.get(i).toString()) {
						case "player":// 플레이어가
							if (obj.get(j).toString() == "wolf")// 늑대와 만났을때
								System.out.println("you die.");
							else if (obj.get(j).toString() == "wall")// 벽과 만났을때
								break;
						case "wolf":
							if (obj.toString() == "turningPt")

								break;

						default:
							break;

						}
					}

				}
		}

	}

}
