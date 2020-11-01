package review;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 防止恢复法，走过的1变成0
 * @author sunyi
 *
 */
public class bfs_块数 {
	
	static int[] X = {1,-1,0,0};
	static int[] Y = {0,0,1,-1};
	
	static int m, n; // mxn的矩阵
	static int[][] G;
	static int cnt; //块数
	
	static class Node {
		int x; int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean[][] inq; //判断(x,y)是否已经入队，防止重复踩
	
	static Queue<Node> q = new LinkedList<Node>();
	
	static boolean check(int nx, int ny) {
		if( nx >= m || nx < 0 || ny >= n || ny < 0 || G[nx][ny]==0 || inq[nx][ny]  ) {
			return false;
		}
		return true;
	}
	
	static void bfs(int x, int y) {
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.remove();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + X[i], ny = cur.y + Y[i];
				if( check(nx, ny) ) {
					q.add(new Node(nx, ny));
					inq[nx][ny]=true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		m = 6; n = 7;
//		G = new int[m][n];
		inq = new boolean[m][n];
		
		G = new int[][]
		     {
				{0,1,1,1,0,0,1},
				{0,0,1,0,0,0,0},
				{0,0,0,0,1,0,0},
				{0,0,0,1,1,1,0},
				{1,1,1,0,1,0,0},
				{1,1,1,1,0,0,0},
			 };
		System.out.println(G.length + " " + G[0].length);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!inq[i][j] && G[i][j]==1) {
					bfs(i, j); //一次bfs结束就代表一个块
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	
}
