package review;

import java.util.Arrays;

/**
 * 迪杰斯特拉最短路变种
 * 			--- 路径花费最小
 * 			--- 点权之和最大
 * 			--- 最短路有几条
 * @author sunyi
 * 
 * 找最短路上花费最少的
 * 		if 距离不同，比较距离，选择近的
 *		if 距离相同，比较花费，选择省的
 *	对于cost的初始化
 *		可以初始化为0，也可以初始化为INF
 *	INF很好解释，默认两点间都是无穷的花费，同时也默认出发点到其他各点的最少花费也是无穷的
 *  0，题目中输入几条边，相应的就会输入几个权重
 *  		输入结束后，0 也是无关紧要的，因为cost[i][j]为0的同时是没有边存在的，也就是没有边的G[i][j]就是INF，就不会进入到更新，因为第一条件无法通过G[u][v]!=INF
 *  			c[v] = c[u] + cost[u][v] 能更新的必定是u v之间有边的，而u v之间边的权重在输入的时候肯定给定了，不会出现为0带来的更新问题
 */
public class 最短路dijk变种1_花费 {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s到其它点的距离， d[s]=0
	static boolean[] vis = new boolean[maxn]; //标记
	static int[][] G = new int[maxn][maxn];
	static int n, m, s, e; //起点和终点
	
	static int[][] cost = new int[maxn][maxn]; //花费
	
	static int[] c = new int[maxn]; //s到其它点的最少花费
	
	
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
		Arrays.fill(c, 0, n, INF);
	}
	
	/**
	 * dijkstra
	 * @param s  起点 从0开始
	 * 
	 * 	第一次肯定选择自己
	 */
	static void dijk(int s) {
		d[s] = 0;
		c[s]=0;
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
						c[v] = c[u] + cost[u][v];
					}else if(d[u] + G[u][v] == d[v]){
						c[v] = c[u] + cost[u][v];
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
	
	static void printc() {
		for (int i = 0; i < n; i++) {
			System.out.print(c[i] + " ");
		}
	}
	
	
	public static void main(String[] args) {
		n = 4; m = 5; s=0; e=3;
		init();
		
		G[0][1] = G[1][0] = 1;
		G[1][3] = G[3][1] = 2;
		G[0][3] = G[3][0] = 4;
		G[0][2] = G[2][0] = 2;
		G[2][3] = G[3][2] = 1;
		
		cost[0][1] = cost[1][0] = 20;
		cost[1][3] = cost[3][1] = 30;
		cost[0][3] = cost[3][0] = 10;
		cost[0][2] = cost[2][0] = 20;
		cost[2][3] = cost[3][2] = 20;
		
		
		dijk(s);
		printd();
		
		System.out.println(d[e] + " " + c[e]);
	}
	
}
