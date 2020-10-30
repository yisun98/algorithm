package review;

public class 搜索旋转数组 {
	static int[] A = {6,7,0,1,3,4,5};
	static int x = 0;
	static int l, r, len;
	public static void main(String[] args) {
		l = 0; r = A.length-1; len = A.length;
		int res = binarySearch();
		System.out.println(res);
	}
	private static int binarySearch() {
		while(l<=r) {
			int mid = (r-l)/2+l;
			if(A[mid]==x) {
				return mid;
			}
		   if(A[mid]<A[len-1]){ //左边有序
				if(x>A[mid] && x<=A[len-1]) { //在
					l = mid+1; //左边有序的没必要找
				}else {
					r = mid;
				}
			}
			else { //右边有序
				if(x>=A[0] && x<=A[mid]) { //在
					r = mid; //右边有序的没必要找
				}else {
					l = mid+1;
				}
			}
		}
		return -1;
	}
}
