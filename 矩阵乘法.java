package review;

public class ¾ØÕó³Ë·¨ {
	static int[][] mul(int[][] a, int[][] b) {
		int m = a.length, n = b[0].length, s = b.length;
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < s; k++) {
					c[i][j] += a[i][k] * b[k][j] ;
				}
			}
		}
		return c;
	}
	public static void main(String[] args) {
		int[][] a = {
				{1,0,-1},
				{1,1,-3},
		}; 
		int[][] b = {
				{0,3},
				{1,2},
				{3,1},
		};
		// 2,3  3,2 = 2,2
		int[][] c = mul(a, b);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
