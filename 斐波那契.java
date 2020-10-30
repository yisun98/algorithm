package review;
/**
 * 	1,1,2,3,5,8,13...
 * 
 * @author sunyi
 *
 */
public class ì³²¨ÄÇÆõ {
	
	static int fib1(int n) {
		if(n==1||n==2) {
			return 1;
		}else {
			return fib1(n-1)+fib1(n-2);
		}
	}
	
	static int fib2(int n) {
		int a = 0, b = 1, c = 0;
		for (int i = 1; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		int fib1 = fib1(7);
		System.out.println(fib1);
		int fib2 = fib2(8);
		System.out.println(fib2);
	}
	
}
