package game;

import java.util.ArrayList;

public class CreateObj {
	private ArrayList<Map> allObjects;
	private ArrayList<Movable> movingObjects;
	private ArrayList<Tile> tile;
	Player player;
	Wolf w;

	public ArrayList<Map> getAllObjects() {
		return allObjects;
	}

	public ArrayList<Movable> getMovingObjects() {
		return movingObjects;
	}

	public ArrayList<Tile> getTile() {
		return tile;
	}

	int[][] wallPos = { { 0, 0 }, { 0, 1 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0, 6 }, { 0, 7 }, { 0, 8 }, { 0, 9 },
			{ 0, 10 }, { 0, 11 }, { 0, 12 }, { 0, 13 }, { 0, 14 }, { 0, 15 }, { 0, 16 }, { 0, 17 }, { 0, 18 },
			{ 0, 19 }, { 0, 20 }, { 0, 21 }, { 0, 22 }, { 0, 23 }, { 0, 24 }, { 1, 0 }, { 1, 1 }, { 1, 3 }, { 1, 4 },
			{ 1, 5 }, { 1, 6 }, { 1, 7 }, { 1, 13 }, { 1, 14 }, { 1, 15 }, { 1, 21 }, { 1, 22 }, { 1, 23 }, { 1, 24 },
			{ 2, 0 }, { 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 9 }, { 2, 10 }, { 2, 11 }, { 2, 17 }, { 2, 18 }, { 2, 19 },
			{ 2, 21 }, { 2, 22 }, { 2, 23 }, { 2, 24 }, { 3, 0 }, { 3, 6 }, { 3, 7 }, { 3, 11 }, { 3, 13 }, { 3, 15 },
			{ 3, 17 }, { 3, 18 }, { 3, 23 }, { 3, 24 }, { 4, 0 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 4, 6 }, { 4, 7 },
			{ 4, 8 }, { 4, 9 }, { 4, 11 }, { 4, 13 }, { 4, 15 }, { 4, 20 }, { 4, 21 }, { 4, 23 }, { 4, 24 }, { 5, 0 },
			{ 5, 2 }, { 5, 3 }, { 5, 4 }, { 5, 13 }, { 5, 15 }, { 5, 16 }, { 5, 18 }, { 5, 19 }, { 5, 20 }, { 5, 21 },
			{ 5, 23 }, { 5, 24 }, { 6, 0 }, { 6, 6 }, { 6, 8 }, { 6, 9 }, { 6, 11 }, { 6, 13 }, { 6, 18 }, { 6, 19 },
			{ 6, 23 }, { 6, 24 }, { 7, 0 }, { 7, 1 }, { 7, 2 }, { 7, 3 }, { 7, 4 }, { 7, 6 }, { 7, 8 }, { 7, 9 },
			{ 7, 11 }, { 7, 15 }, { 7, 16 }, { 7, 21 }, { 7, 22 }, { 7, 23 }, { 7, 24 }, { 8, 0 }, { 8, 1 }, { 8, 2 },
			{ 8, 6 }, { 8, 11 }, { 8, 12 }, { 8, 14 }, { 8, 15 }, { 8, 16 }, { 8, 18 }, { 8, 19 }, { 8, 23 }, { 8, 24 },
			{ 9, 0 }, { 9, 1 }, { 9, 2 }, { 9, 4 }, { 9, 5 }, { 9, 6 }, { 9, 7 }, { 9, 8 }, { 9, 12 }, { 9, 14 },
			{ 9, 15 }, { 9, 21 }, { 9, 23 }, { 9, 24 }, { 10, 0 }, { 10, 10 }, { 10, 12 }, { 10, 14 }, { 10, 15 },
			{ 10, 16 }, { 10, 17 }, { 10, 18 }, { 10, 20 }, { 10, 21 }, { 10, 22 }, { 10, 23 }, { 10, 24 }, { 11, 0 },
			{ 11, 1 }, { 11, 2 }, { 11, 4 }, { 11, 5 }, { 11, 6 }, { 11, 8 }, { 11, 10 }, { 11, 20 }, { 11, 23 },
			{ 11, 24 }, { 12, 0 }, { 12, 1 }, { 12, 2 }, { 12, 4 }, { 12, 5 }, { 12, 8 }, { 12, 10 }, { 12, 11 },
			{ 12, 12 }, { 12, 14 }, { 12, 15 }, { 12, 16 }, { 12, 17 }, { 12, 18 }, { 12, 20 }, { 12, 21 }, { 12, 23 },
			{ 12, 24 }, { 13, 0 }, { 13, 7 }, { 13, 8 }, { 13, 14 }, { 13, 23 }, { 13, 24 }, { 14, 0 }, { 14, 1 },
			{ 14, 2 }, { 14, 4 }, { 14, 5 }, { 14, 6 }, { 14, 7 }, { 14, 8 }, { 14, 10 }, { 14, 12 }, { 14, 13 },
			{ 14, 14 }, { 14, 16 }, { 14, 17 }, { 14, 18 }, { 14, 20 }, { 14, 22 }, { 14, 23 }, { 14, 24 }, { 15, 0 },
			{ 15, 1 }, { 15, 10 }, { 15, 17 }, { 15, 20 }, { 15, 22 }, { 16, 0 }, { 16, 1 }, { 16, 2 }, { 16, 4 },
			{ 16, 5 }, { 16, 6 }, { 16, 7 }, { 16, 9 }, { 16, 10 }, { 16, 11 }, { 16, 12 }, { 16, 14 }, { 16, 15 },
			{ 16, 17 }, { 16, 19 }, { 16, 20 }, { 16, 22 }, { 16, 24 }, { 17, 0 }, { 17, 1 }, { 17, 2 }, { 17, 14 },
			{ 17, 15 }, { 17, 19 }, { 17, 20 }, { 17, 24 }, { 18, 0 }, { 18, 1 }, { 18, 2 }, { 18, 3 }, { 18, 4 },
			{ 18, 5 }, { 18, 6 }, { 18, 7 }, { 18, 8 }, { 18, 9 }, { 18, 10 }, { 18, 11 }, { 18, 12 }, { 18, 13 },
			{ 18, 14 }, { 18, 15 }, { 18, 16 }, { 18, 17 }, { 18, 18 }, { 18, 19 }, { 18, 20 }, { 18, 21 }, { 18, 22 },
			{ 18, 23 }, { 18, 24 } };

	public CreateObj() {
		allObjects = new ArrayList<>();
		movingObjects = new ArrayList<>();
		tile = new ArrayList<>();
		for (int x = 0; x <= 1200; x = x + 50)
			for (int y = 0; y <= 900; y = y + 50) {
				tile.add(new Tile(x, y));// 리스트에 타일 객체 추가
			}
		player = new Player();
		allObjects.add(player);// 플레이어 추가
		movingObjects.add(player);
		w = new Wolf(500, 400);
		allObjects.add(w);
		movingObjects.add(w);
		for (int i = 0; i < wallPos.length; i++)
			allObjects.add(new Wall(wallPos[i][1] * Map.offset, wallPos[i][0] * Map.offset));

	}

	private void readMapData(String fileName) {

	}

	public void playerUp() {// 위로 간다.
		player.setYspeed(-player.getSpeed());
	}

	public void playerUpStop() {// 위로 그만 간다.
		player.addYspeed(player.getSpeed());
	}

	public void playerDown() {// 밑으로 간다.
		player.setYspeed(player.getSpeed());
	}

	public void playerDownStop() {// 밑으로 그만 간다.
		player.addYspeed(-player.getSpeed());
	}

	public void playerLeft() {// 왼쪽으로 간다.
		player.setXspeed(-player.getSpeed());
	}

	public void playerLeftStop() {// 왼쪽으로 그만 간다.
		player.addXspeed(player.getSpeed());
	}

	public void playerRight() {// 오른쪽으로 간다.
		player.setXspeed(player.getSpeed());
	}

	public void playerRightStop() {// 오른쪽으로 그만 간다.
		player.addXspeed(-player.getSpeed());
	}

}
