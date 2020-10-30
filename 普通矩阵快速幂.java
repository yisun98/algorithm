package review;

import review.斐波那契矩阵快速幂.M;

public class 普通矩阵快速幂 {
	
	static long p = 100000007;
	
	static class M {
		long[][] m = new long[2][2];
	}
	
	static M mul(M a, M b) {
		M c = new M();
		int m = a.m.length, n = b.m[0].length, s = b.m.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < s; k++) {
					c.m[i][j] += a.m[i][k] * b.m[k][j] ;
					c.m[i][j] %= p;
				}
			}
		}
		return c;
	}
	
	static M qPow(M a, int b) {
		M res = new M();
		// 单位矩阵
		res.m[0][0] = 1;
		res.m[1][1] = 1;
		
		while(b != 0) {
			if( (b&1) == 1) {
				res = mul(res, a);
			}
			a = mul(a, a);
			b >>= 1;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		M a = new M();
		a.m[0][0]=1;
		a.m[0][1]=1;
		a.m[1][0]=1;
		a.m[1][1]=0;
		M qPow = qPow(a, 7);
		print(qPow);
	}
	
	static void print(M m) {
		 for (int i = 0; i < 2; i++) {
			 for (int j = 0; j < 2; j++) {
				 System.out.print(m.m[i][j] + " ");
			 }
			 System.out.println();
		 }
	}
	
	
	
	
	
}
