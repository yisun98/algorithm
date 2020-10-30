package review;


public class ì³²¨ÄÇÆõ¾ØÕó¿ìËÙÃÝ {
	
	static long p = 100000007;
	
	static class M {
		long[][] m = new long[2][2];
	}
	
	static M mul(M a, M b) {
		M c = new M();
		c.m[0][0] = ( (a.m[0][0]*b.m[0][0])%p + (a.m[0][1]*b.m[1][0])%p ) % p;
		c.m[0][1] = ( (a.m[0][0]*b.m[0][1])%p + (a.m[0][1]*b.m[1][1])%p ) % p;
		c.m[1][0] = ( (a.m[1][0]*b.m[0][0])%p + (a.m[1][1]*b.m[1][0])%p ) % p;
		c.m[1][1] = ( (a.m[1][0]*b.m[0][1])%p + (a.m[1][1]*b.m[1][1])%p ) % p;
		return c;
	}
	
	static M qPow(M a, int b) {
		M res = new M();
		// µ¥Î»¾ØÕó
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
