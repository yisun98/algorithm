package review;

import java.util.Arrays;

public class 最小生成树prim {
	
	static int maxn = 1000+10;
	static int INF = 0x3f3f3f3f;
	
	static int n, m, s;
	
	static int[][] G = new int[maxn][maxn];
	
	static int[] d = new int[maxn];
	static boolean[] vis = new boolean[maxn];
	
	static int sum; //边权和
	
	static int cnt; //已访问的顶点数量
	
	static void init() {
		Arrays.fill(d, 0, n, INF);
		Arrays.fill(vis, 0, n, false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				G[i][j]=INF;
			}
		}
	}
	
	/**
	 * prim算法
	 * @param s  起点
	 */
	static void prim(int s) {
		d[s] = 0;
		
		for (int i = 0; i < n; i++) {
			int u = -1, mind = INF;
			
			
			for (int j = 0; j < n; j++) {
				if(!vis[j] && d[j] < mind) {u=j; mind=d[j];}
			}
			
			if(u==-1 || cnt==n) return;
			
			vis[u]=true;
			
			sum += d[u];  cnt++;
			
			System.out.println("访问当前顶点u = " + u + "   距离s = " + mind);
			
			for (int v = 0; v < n; v++) {
				if(!vis[v] && G[u][v]!=INF && G[u][v]<d[v]) {
					d[v] = G[u][v];
					System.out.println("	更新了顶点v = " + v + "   距离s = " + d[v]);
				}
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		n = 6;
		m = 10;
		s = 0;
		init();
		//无向图
		G[0][1] = G[1][0] = 4;
		G[0][4] = G[4][0] = 1;
		G[0][5] = G[5][0] = 2;
		G[1][2] = G[2][1] = 6;
		G[1][5] = G[5][1] = 3;
		G[2][3] = G[3][2] = 6;
		G[2][5] = G[5][2] = 5;
		G[3][4] = G[4][3] = 4;
		G[3][5] = G[5][3] = 5;
		G[4][5] = G[5][4] = 3;
		prim(s);
		System.out.println(sum);
	}
	
	
}
