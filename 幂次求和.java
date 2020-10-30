package review;

import java.util.Scanner;
/**
 * 第i个数的第i次幂，然后n个数的结果求和
 * @author sunyi
 *
 */
public class 幂次求和 {
	static long p = 10000019;
	static long ans = 0;
	static long quickPow(long a, long b) {
		long res = 1;
		while(b != 0) {
			if( (b&1) == 1 ) {
				res = res * a % p;
			}
			a = a * a % p;
			b >>= 1;
		}
		return res;
	}
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			long x = sc.nextLong();
			ans += quickPow(x, i);
			ans %= p;
		}
		System.out.println(ans%p);
	}
}
