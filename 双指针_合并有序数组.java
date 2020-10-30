package review;

import java.util.Arrays;

public class 双指针_合并有序数组 {
	static int[] A = {1, 3, 5, 7, 9, 11};
	static int[] B = {2, 4, 6, 8, 10, 15, 18};
	static int i, j, k; //C的移动下标
	
	static int[] merge() {
		int[] C = new int[A.length+B.length];
		i = 0; j = 0;
		
		while(i<A.length && j<B.length) {
			if(A[i]<=B[j]) {
				C[k++]=A[i++];
			}else {
				C[k++]=B[j++];
			}
		}
		while(i<A.length) {
			C[k++]=A[i++];
		}
		while(j<B.length) {
			C[k++]=B[j++];
		}
		return C;
	}
	
	
	
	public static void main(String[] args) {
		int[] merge = merge();
		System.out.println(Arrays.toString(merge));
	}
	
}
