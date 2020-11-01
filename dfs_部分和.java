package review;

import java.util.ArrayList;

/**
 * N个数中任意选择几个数，有没有和为sum的方案，如果有，这个方案是什么
 * @author sunyi
 *
 */
public class dfs_部分和 {
	static int[] a;  
	static int n; 
	static int SUM; //和为SUM
	static boolean ans = false; //最终结果，默认没有
	static ArrayList<Integer> p = new ArrayList<Integer>(); //存方案
	

	 /**
	  * 
	  * @param k  当前处理到第k个数字
	  * @param S  当前和还剩余多少到0
	  */
	static void dfs(int k , int S ) {
		
		if(S == 0) {
			ans = true; 
			System.out.println(p);
			return;
		}
		
		if(k==n || S < 0) {
			return;
		}
		
		dfs(k+1, S); //不选
		
		p.add(a[k]);
		dfs(k+1, S-a[k]);  //选
		p.remove(p.size()-1);
	}
	
	
	
	
	
	public static void main(String[] args) {
		a = new int[] {1, 2, 4, 7, 12};   n = 5;   SUM = 13;
		//预期结果 [2,4,7] , [1,12]

		dfs(0, SUM);
//		System.out.println(p);  输入为[]，是因为在完成后要返回到最上层，把加入的全部又删掉了
		System.out.println(ans);
	}
}
