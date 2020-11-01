package review;

import java.util.ArrayList;

/**
 * N个数选K个数出来，K个数和为X，如果有多种方案，选择平方和最大的一组
 * @author sunyi
 *
 *	选  or 不选，注意边界情况
 */
public class dfs_K数之和为X且保存方案 {
	static int[] a;  
	static int n; 
	static int X; //和为X
	static int K; //K个数
	static ArrayList<Integer> p = new ArrayList<Integer>(); //存过程
	static ArrayList<Integer> r = new ArrayList<Integer>(); //存结果
	static int ans = -1; //最终结果，防止和为0出现
	/**
	 * 
	 * @param k 当前处理到 第 k个数字
	 * @param s 当前已经选择了s个数字
	 * @param S 当前s个数字的和
	 * @param SQ 当前s个数字的平方和
	 */
	static void dfs(int k, int s, int S, int SQ) {
		
		if(s == K && S == X) {
			if(SQ > ans) {
				ans = SQ;
//				System.out.println(p);
			}
//			ans = Math.max(ans, SQ);
			return;
		}
		
		if(k==n || s > K || S > X) {
			return;
		}
		
		dfs(k+1, s, S, SQ); //不选
		
		p.add(a[k]);
		dfs(k+1, s+1, S+a[k], SQ+a[k]*a[k]);  //选
		p.remove(p.size()-1);
	}
	
	/**
	 * 
	 * @param k 当前处理到 第 k个数字
	 * @param s 当前已经选择了s个数字
	 * @param S 当前s个数字的和
	 * @param SQ 当前s个数字的平方和
	 */
	static void dfswithpath(int k, int s, int S, int SQ, ArrayList<Integer> p) {
		
		if(s == K && S == X) {
			if(SQ > ans) {
				ans = SQ;
				r = new ArrayList<Integer>(p);
			}
//			ans = Math.max(ans, SQ);
			return;
		}
		
		if(k==n || s > K || S > X) {
			return;
		}
		
		dfswithpath(k+1, s, S, SQ, p); //不选
		
		p.add(a[k]);
		dfswithpath(k+1, s+1, S+a[k], SQ+a[k]*a[k], p);  //选
		p.remove(p.size()-1);
	}
	
	
	
	public static void main(String[] args) {
		a = new int[] {2, 3, 3, 4}; n = 4; 
		K = 2; X = 6;
		//预期结果  2^2+4^2 > 3^2+3^2   =>    [2,2]
//		dfs(0, 0, 0, 0);
		dfswithpath(0, 0, 0, 0, new ArrayList<Integer>());
		System.out.println(r);
		System.out.println(ans);
	}
}
