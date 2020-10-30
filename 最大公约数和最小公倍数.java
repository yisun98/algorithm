package review;

public class 最大公约数和最小公倍数 {
	static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
	static int lcd(int a, int b) {
		return a/gcd(a, b) * b;
	}
	
	public static void main(String[] args) {
		int gcd = gcd(12, 24);
		System.out.println(gcd);
		int lcd = lcd(12, 24);
		System.out.println(lcd);
	}
	
}
