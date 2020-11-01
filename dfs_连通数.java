package review;

public class dfs_连通数 {
	static int m, n; // mxn的矩阵
	static int[][] G;
	static boolean[][] vis; //标记
	static int ans = 0x3f3f3f3f; //方案数
	static int color = -1;
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	static boolean check(int x, int y) {
		if(x >= m || x < 0 || y >= n || y < 0 || G[x][y]==0 || vis[x][y]) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 边扩散边染色
	 * @param x
	 * @param y  当前所在位置(x,y)
	 * 
	 */
	static void dfs(int x, int y) {
		
		G[x][y] = color;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + X[i], ny = y + Y[i];
			if( check(nx, ny) ) {
				vis[nx][ny]=true;
				dfs(nx, ny);
				//不用还原,一直扩散就行了
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		m = 6; n = 7;
		
		G = new int[][]
		 		     {
		 				{0,1,1,1,0,0,1},
		 				{0,0,1,0,0,0,0},
		 				{0,0,0,0,1,0,0},
		 				{0,0,0,1,1,1,0},
		 				{1,1,1,0,1,0,0},
		 				{1,1,1,1,0,0,0},
		 			 };
		
		vis = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!vis[i][j] && G[i][j] == 1) {dfs(i, j); color--;}
			}
		}
		
		printG();
		
	}
	
	static void printG() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(G[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
