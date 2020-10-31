package review;
/**
 * dij选中一个距离s最短距离的点u后，更新所有以u为中介点的距离
 * 当更新完成后，不会再去看u这个点 (vis[u]=true)，因为u这个点该更新的已经更新了，所以要从V-S中去找
 * 后面点v的更新都是在以u为中介点更新后新的d数组之后进行更新的
 * 不然下次还是选择u这个点，因为u始终离s最近
 * 
 * floyd不用标记，因为你标记了这个点后，这个点如果作为中介点的话，那就没法用了
 * floyd就是将所有的中介点全部试一遍，枚举所有的点对，能更新就更新，不能换下一个中介点
 * 
 * @author sunyi
 *
 */
public class 最短路floyd {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int n, m;
	
	
	static int[][] d = new int[maxn][maxn];
	
	static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(d[i][k]!=INF && d[k][j]!=INF && d[i][k] + d[k][j] < d[i][j]) {
						 d[i][j] = d[i][k] + d[k][j] ;
					}
				}
			}
		}
	}
}
