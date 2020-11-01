package review;

import java.util.Arrays;

public class È«ÅÅÁĞ {
	static int[] a = {0,1,2,3};
	static int n = 4;
	static int cnt;
	static void f(int k) {
		if(k==n) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = k; i < n; i++) {
			{int t = a[i]; a[i] = a[k]; a[k] = t;};
			f(k+1);
			{int t = a[i]; a[i] = a[k]; a[k] = t;};
		}
	}
	
	public static void main(String[] args) {
		f(0);
		System.out.println(cnt);
	}
}
