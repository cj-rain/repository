package Lifegames;

import java.awt.Graphics;


import javax.swing.JPanel;
/**GameMap */
public class GameMap extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private static final char WORLD_MAP_NONE = 'N';
	private static final char WORLD_MAP_ALIVE = 'A';
	private static final int width = 26;
	private static final int height = 26;
	/** length. */
	private static final int length = 20;
	private static final int wide = 20;
	private static final double rate=0.5;
	public static char[][] nextStatus = new char[length][wide];
	public static char[][] tempStatus = new char[length][wide];
	public static boolean flag=false;

	public static void init() {
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < wide; col++) { // 随机产生一个初始地图
				/*double s = Math.random();
				if (s > rate) {
					nextStatus[row][col] = 'N';
					tempStatus[row][col] = 'N';
				} else {
					nextStatus[row][col] = 'A';
					tempStatus[row][col] = 'A';
				}*/
				if (row > 9 && row < 16 && col > 9 && col < 16) {
					nextStatus[row][col] = 'A';
					tempStatus[row][col] = 'A';
				} else {
					nextStatus[row][col] = 'N';
					tempStatus[row][col] = 'N';
				}

			}
		}
	}

	public static void game_cycle() { // 一个游戏循环
		flag=true;
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < wide; col++) {

				switch (get_neighbor_count(row, col)) {
				case 0:
				case 1:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					nextStatus[row][col] = WORLD_MAP_NONE;
					if (tempStatus[row][col]!=WORLD_MAP_NONE)
						flag=false;
					break;
				case 2:
					nextStatus[row][col] = tempStatus[row][col];
					break;
				case 3:
					nextStatus[row][col] = WORLD_MAP_ALIVE;
					if (tempStatus[row][col]!=WORLD_MAP_ALIVE)
						flag=false;
					break;
				default:
					nextStatus[row][col] = tempStatus[row][col];	
				}
			}
		}
		resetMap();
		if (flag==true)
			System.exit(0);
		
	}
	@Override
	public void paintComponent(Graphics g) { // 为画图函数，被repaint调用
		super.paintComponent(g);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < wide; j++) {
				if (nextStatus[i][j] == WORLD_MAP_ALIVE) {
					g.fillRect(j * width, i * height, width, height);

				} else {
					g.drawRect(j * width, i * height, width, height);
				}
			}
		}
	}

	public static void resetMap() { // 将地图更新
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < wide; col++) {
				tempStatus[row][col] = nextStatus[row][col];
			}
		}
	}

	public static int get_neighbor_count(int row, int col) { // 获得周围的（可更改）
		int count = 0, r = 0, c = 0;

		for (r = row - 1; r <= row + 1; r++) {
			for (c = col - 1; c <= col + 1; c++) {
				if (r < 0 || r >= length || c < 0 || c >= wide) {
					continue;
				}
				if (tempStatus[r][c] == WORLD_MAP_ALIVE) {
					count++; // 注意这里
				}
			}
		}
		if (tempStatus[row][col] == WORLD_MAP_ALIVE) {
			count--;
		}
		return count;
	}

}
