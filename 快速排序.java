package review;

public class 快速排序 {
	static int[] A = {65, 58, 95, 10, 57, 62, 13, 106};
	
	static int partion(int l, int r) {
		int i = l, j = r, k = A[l]; //哨兵
		while(i < j) {
			while(i<j && A[j]>=k) {
				j--;
			}
			while(i<j && A[i]<=k) {
				i++;
			}
			if (i < j) {int t=A[i]; A[i]=A[j]; A[j]=t;}; 
		}
		// { int t=A[i]; A[i]=A[l]; A[l]=t; };  用这一句，下面两句可以不要了
		A[l] = A[i];
		A[i] = k;
		return i;
	}
	
	static void quickSort(int l, int r) {
		if(l < r) {
			int p = partion(l, r);
			print();
			quickSort(l, p-1);
			quickSort(p+1, r);
		}
	}
	
	public static void main(String[] args) {
		quickSort(0, A.length-1);
		print();
	}
	
	static void print() {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
