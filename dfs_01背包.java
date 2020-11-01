package review;
/**
 * 装 or 不装，注意剪枝，否则就是幂级的复杂度
 * @author sunyi
 *
 */
public class dfs_01背包 {
	static int n; //物品数
	static int[] w, c;   //重量和价值
	static int V; //背包容量
	static int ans; //最大价值
	/**
	 * 
	 * @param k 当前处理到第k个物品
	 * @param C 当前价值
	 * @param W 当前重量
	 */
	static void dfs(int k, int C, int W) {
		if(W>V) {
			return;
		}
		if(k==n) {
			ans = Math.max(ans, C);
			return;
		}
		dfs(k+1, C+c[k], W+w[k]);  //装
		dfs(k+1, C, W); //不装
	}
	
	
	/**
	 * 带剪枝
	 * @param k 当前处理到第k个物品
	 * @param C 当前价值
	 * @param W 当前重量
	 */
	static void dfswithcut(int k, int C, int W) {
		if(k==n) {
			ans = Math.max(ans, C);
			return;
		}
		dfs(k+1, C, W); //不装
		
		if(W+w[k]<=V) { //提前剪
			dfs(k+1, C+c[k], W+w[k]);  //装
		}
	}
	
	
	public static void main(String[] args) {
		n = 5; V = 8;
		w = new int[]{3, 5, 1, 2, 2};
		c = new int[]{4, 5, 2, 1, 3};
//		dfs(0, 0, 0);
//		System.out.println(ans);
		dfswithcut(0, 0, 0);
		System.out.println(ans);
	}
}
