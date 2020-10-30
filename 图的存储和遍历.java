package review;

import java.util.LinkedList;
import java.util.Queue;

public class 图的存储和遍历 {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[][] G = new int[maxn][maxn]; //邻接矩阵
	static boolean[] visited = new boolean[maxn]; //标记
	static int n, m; 
	
	/**
	 * 遍历图(单连通图)
	 * @param u 起点
	 */
	static void dfs(int u) {
		visited[u]=true;
		System.out.println(u);
		for (int v = 0; v < n; v++) {
			if(G[u][v]!=INF&&!visited[v]) {
				dfs(v);
			}
		}
	}
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] inq = new boolean[maxn];
	
	/**
	 * 遍历图(单连通图) 
	 * @param s 起点
	 */
	static void bfs(int s) {
		q.add(s);
		inq[s] = true;
		System.out.println(s);
		while (!q.isEmpty()) {
			int u = q.remove();
			for (int v = 0; v < n; v++) {
				if(G[u][v]!=INF&&!inq[v]) {
					q.add(v);
					inq[v]=true;
					System.out.println(v);
				}
			}
		}
	}
	
	static void dfsAll(int u) {
		for (int i = 0; i < n; i++) {
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		n = 5; m = 5;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j) G[i][j]=0;
				else G[i][j]=INF;
			}
		}
		//编号从0开始
		G[0][1] = G[1][0] = 1;
		G[0][2] = G[2][0] = 1;
		G[0][4] = G[4][0] = 1;
		G[1][3] = G[3][1] = 1;
		G[2][4] = G[4][2] = 1;
//		dfs(1);
		bfs(1);
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(G[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
