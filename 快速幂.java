package review;

public class ¿ìËÙÃÝ {
	static long quickPow(long a, long b, long m) {
		long res = 1;
		while(b!=0) {
			if( (b&1)==1) {
				res = res * a % m;
			}
			a = a * a % m;
			b >>= 1;
		}
		return res % m;
	}
	public static void main(String[] args) {
		long quickPow = quickPow(2, 10, 10000007);
		System.out.println(quickPow);
	}
	
	static long f(long a, long b, int mod) {
		long ans = 1;
		
		while(b != 0) {
			if( (b&1)==1 ) {
				ans =  ( (ans%mod) * (a%mod) ) % mod;
			}
			b >>= 1;
			a = ( (a % mod) * (a % mod) ) % mod;
		}
		
		
		return ans;
	}
}
