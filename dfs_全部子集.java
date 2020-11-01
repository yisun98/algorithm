package review;

import java.util.ArrayList;

/**
 * N个数的子集生成
 * @author sunyi
 *
 *	选  or 不选，注意边界情况
 */
public class dfs_全部子集 {
	static int[] a;  
	static int n; 
	static int cnt;  //子集个数

	/**
	 * 
	 * @param k 当前处理到第k个数
	 * @param p 保存生成的子集
	 */
	static void dfs(int k, ArrayList<Integer> p) {
		
		if(k==n ) {
			cnt++;
			System.out.println(p);
			return;
		}
		//选和不选的顺序会导致生成的结果不一样
		
		p.add(a[k]);
		dfs(k+1, p);  //选
		p.remove(p.size()-1);
		
		dfs(k+1, p); //不选
		
	}
	
	
	
	public static void main(String[] args) {
		a = new int[] {1, 2, 3}; n = 3; 
		dfs(0, new ArrayList<Integer>());
		System.out.println(cnt);
	}
}
