package review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class 双指针_两数之和 {
	static int[] A = {1, 3, 5, 7, 9};
	static int l, r, s = 8;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	static boolean find() {
		l = 0; r = A.length - 1;
		while(l < r) {
			if(A[l]+A[r]==s) {
				return true;
			}else if (A[l]+A[r]>s) {
				r--;
			}else { //A[l]+A[r]<s
				l++;
			}
		}
		return false;
	}
	
	static void find2() {
		l = 0; r = A.length - 1;
		while(l < r) {
			if(A[l]+A[r]==s) {
				map.put(A[l], A[r]);
				r--;l++;
			}else if (A[l]+A[r]>s) {
				r--;
			}else { //A[l]+A[r]<s
				l++;
			}
		}
	}
	
	public static void main(String[] args) {
		boolean res = find();
		System.out.println(res);
		find2();
		System.out.println(map.size());
		
		for (Entry<Integer, Integer> kv : map.entrySet()) {
			System.out.println(kv.getKey() + " " + kv.getValue());
		}
	
	}
	
}
