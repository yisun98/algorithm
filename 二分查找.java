package review;

 
public class ¶ş·Ö²éÕÒ {
	static int[] A = {1,2,3,4,5,6,7,8,9};
	static int l, r;
	public static void main(String[] args) {
		int res = binarySearch(10);
		System.out.println(res);
	}
	private static int binarySearch(int x) {
		l = 0; r = A.length-1;
		while (l<=r) {
			int mid = (r-l) / 2 + l;
			if(A[mid]==x) {
				return mid;
			}else if (A[mid]<x) {
				l=mid+1;
			}else { // A[mid]>x
				r=mid-1;
			}
		}
		return -1;
	}
}
