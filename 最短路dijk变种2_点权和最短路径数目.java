package review;

import java.util.Arrays;

/**
 * 迪杰斯特拉最短路变种
 * 			--- 路径花费最小
 * 			--- 点权之和最大
 * 			--- 最短路有几条
 * @author sunyi
 * 
 * 找最短路上点权和最大的且同时记录最短路径数目
 * 		if 距离不同，比较距离，选择近的
 *		if 距离相同，比较点权和，选择大的
 *	
 */
public class 最短路dijk变种2_点权和最短路径数目 {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s到其它点的距离， d[s]=0
	static boolean[] vis = new boolean[maxn]; //标记
	static int[][] G = new int[maxn][maxn];
	static int n, m, s, e;
	
	static int[] weight = new int[maxn]; //点权
	
	static int[] w = new int[maxn];
	static int[] num = new int[maxn]; //最短路径数，表示从s到其他点的最短路径数
	
	static void init() {
		Arrays.fill(d, 0, n, INF);
		Arrays.fill(vis, 0, n, false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) {
					G[i][j]=0;
				}
				else {
					G[i][j]=INF; 
				}
			}
		}
		Arrays.fill(num, 0, n, 0);
		Arrays.fill(w, 0, n, 0);
	}
	
	/**
	 * dijkstra
	 * @param s  起点 从0开始
	 * 
	 * 	第一次肯定选择自己
	 */
	static void dijk(int s) {
		d[s] = 0;
		num[s]=1;
		w[s] = weight[s];
		for (int i = 0; i < n; i++) {
			
			int u = -1, mind = INF;
			
			for (int j = 0; j < n; j++) {
				if(!vis[j] && d[j] < mind) {u=j; mind=d[j];}
			}
			
			if(u==-1) return;
			
			vis[u]=true;
			
			
			for (int v = 0; v < n; v++) {
				if(!vis[v] && G[u][v]!=INF ) {
					if(d[u] + G[u][v] < d[v]) {
						d[v]=d[u]+G[u][v];
						w[v] = w[u] + weight[v];
						num[v] = num[u];  //s到u的数目有num[u]个，此时v的出现能所缩短并且u,v之间有边，所以到v的最短数和u的一样，通过u去到v
					}else if(d[u] + G[u][v] == d[v]){
						if(w[v] < w[u]+weight[v]) {
							w[v] = w[u] + weight[v];
						}
						num[v] += num[u]; 
						//s到u的数目有num[u]个，s到v的数目有num[v]个，u,v之间有边，从s到u再到v和s到v的最短路长度一样，所以到v的最短数累加上u的，加上通过u去到v
					}
				}
			}
		}
	}
	
	static void printd() {
		for (int i = 0; i < n; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	static void printnum() {
		for (int i = 0; i < n; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	static void printw() {
		for (int i = 0; i < n; i++) {
			System.out.print(w[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		n = 5; m = 6; s=0; e=2;
		init();
		
		G[0][1] = G[1][0] = 1;
		G[0][2] = G[2][0] = 2;
		G[0][3] = G[3][0] = 1;
		G[1][2] = G[2][1] = 1;
		G[2][4] = G[4][2] = 1;
		G[3][4] = G[4][3] = 1;
		
		weight[0] = 1;
		weight[1] = 2;
		weight[2] = 1;
		weight[3] = 5;
		weight[4] = 3;
		
		dijk(s);
		
		printd();
		printw();
		printnum();
	}
	
}
