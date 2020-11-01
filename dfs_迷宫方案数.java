package review;

public class dfs_迷宫方案数 {
	static int m, n; // mxn的矩阵
	static int[][] G;
	static boolean[][] vis; //标记
	static int cnt; //方案数
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	static boolean check(int x, int y) {
		if(x >= m || x < 0 || y >= n || y < 0 || G[x][y]==1 || vis[x][y]) {
			return false;
		}
		return true;
	}
	
	static int sx, sy, ex, ey;
	
	static void dfs(int x, int y) {
		if(x==ex && y==ey) {
			cnt++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + X[i], ny = y + Y[i];
			if( check(nx, ny) ) {
				vis[nx][ny]=true;
				dfs(nx, ny);
				vis[nx][ny]=false;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		m = 5; n = 6;
		
		G = new int[][]{
				{0,1,0,0,0,1}, 
				{0,0,0,1,0,0},
				{1,0,1,0,0,1},
				{1,0,0,1,0,1},
				{1,1,0,0,0,0},
		};
		
		vis = new boolean[m][n];
		
		sx = 0; sy = 0; ex = 4; ey = 5;
		
		vis[sx][sy] = true;
		dfs(sx, sy);
		System.out.println(cnt); //2
	}
	
	
}
