package review;

public class 二进制子集生成法 {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3};
		int n = 3;
		for (int i = 0; i < (1<<n); i++) {   //二进制数     0~7
			for (int j = 0; j < n; j++) {    // 右移j位
				if (  ((i>>j)&1) == 1) {     //相与为1 
					System.out.print(a[j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * [1,2,3]
	 * 		000   []
	 * 		001   [1]
	 * 		010   [2]  右移2次，选择a[1]=2
	 * 			
	 */
	
	
	
}
