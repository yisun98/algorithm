package review;

import java.util.LinkedList;
import java.util.Queue;

import review.bfs_块数.Node;

public class bfs_迷宫最少步数 {
	static int m, n; // mxn的矩阵
	static int[][] G;
	static boolean[][] inq; //标记
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	static boolean check(int x, int y) {
		if(x >= m || x < 0 || y >= n || y < 0 || G[x][y]==1 || inq[x][y]) {
			return false;
		}
		return true;
	}
	
	static int sx, sy, ex, ey;
	
	static class Node {
		int x; int y; int step;
		public Node(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	
	static Queue<Node> q = new LinkedList<Node>();
	
	static void bfs(int sx, int sy, int init_step) {
		q.add(new Node(sx, sy, init_step));
		inq[sx][sy]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.remove();
			int x = cur.x, y = cur.y, step = cur.step;
			if(x == ex && y == ey) {
				System.out.println(step);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + X[i], ny = y + Y[i];
				if( check(nx, ny) ) {
					q.add(new Node(nx, ny, step+1));
					inq[nx][ny]=true;
				}
			}
		}
		
	}
	
public static void main(String[] args) {
		
		m = 5; n = 4;
		
		G = new int[][]{
				{0,0,1,0}, 
				{0,0,0,0},
				{0,0,1,0}, 
				{0,1,0,0},
				{0,0,0,1},
		};
		
		inq = new boolean[m][n];
		
		sx = 0; sy = 0; ex = 3; ey = 2;
		
		bfs(sx, sy, 0);
		
	}
	
	
	
	
	
}
