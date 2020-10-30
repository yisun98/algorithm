package review;
/**
 * 素数比例是log(n)
 * @author sunyi
 *
 */
public class 素数表 {
	static int maxn = 1000;
	static int[] a = new int[maxn]; //存素数
	static int k; 
	static boolean[] isRemoved = new boolean[maxn]; //是否被筛掉，默认没有被筛
	/**
	 * 埃
	 * @param bound  边界
	 */
	static void table(int bound) {
		for (int i = 2; i <= bound; i++) {
			if(!isRemoved[i]) { //没筛掉
				a[k++]=i;
				for (int j = i*i; j <= bound; j+=i) { //倍数筛掉
					isRemoved[j]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		table(100);
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
