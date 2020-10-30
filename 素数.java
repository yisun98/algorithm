package review;

public class ËØÊı {
	static boolean check(int a) {
		if(a<=1) return false;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if(a%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean check = check(8);
		System.out.println(check);
		boolean check2 = check(3);
		System.out.println(check2);
		
	}
	
	
}
