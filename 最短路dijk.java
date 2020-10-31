package review;

import java.util.Arrays;

/**
 * 迪杰斯特拉最短路
 * @author sunyi
 *	Arrays.fill()并不能提高赋值的效率，在函数的内部也是用for循环的方式 实现的
 */
public class 最短路dijk {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s到其它点的距离， d[s]=0
	static boolean[] vis = new boolean[maxn]; //标记
	static int[][] G = new int[maxn][maxn];
	static int n, m, s;
	
	static void init() {
		Arrays.fill(d, 0, n, INF);
		Arrays.fill(vis, 0, n, false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) G[i][j]=0;
				else 
					G[i][j]=INF;
			}
		}
	}
	
	/**
	 * dijkstra
	 * @param s  起点 从0开始
	 * 
	 * 	第一次肯定选择自己
	 */
	static void dijk(int s) {
		d[s] = 0;
		
		for (int i = 0; i < n; i++) {
			
			int u = -1, mind = INF;
			
			for (int j = 0; j < n; j++) {
				if(!vis[j] && d[j] < mind) {u=j; mind=d[j];}
			}
			
			if(u==-1) return;
			
			vis[u]=true;
			
			System.out.println("         访问当前顶点u = " + u + "   距离s = " + mind);
			
			for (int v = 0; v < n; v++) {
				if(!vis[v] && G[u][v]!=INF && d[u] + G[u][v] < d[v]) {
					d[v]=d[u]+G[u][v];
					System.out.println("更新了顶点v = " + v + "   距离s = " + d[v]);
				}
			}
		}
	}
	
	static void printd() {
		for (int i = 0; i < n; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		n = 6; m = 8; s=0;
		init();
		// 有向图
		G[0][1] = 1;
		G[0][3] = 4;
		G[0][4] = 4;
		G[1][3] = 2;
		G[2][5] = 1;
		G[3][2] = 2;
		G[3][4] = 3;
		G[4][5] = 3;
		dijk(s);
		printd();
	}
	
}
