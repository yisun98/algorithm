package review;

public class 并查集_好朋友 {
	static int maxn = 1000+10;
	static int[] father = new int[maxn];
	
	
	static void init() {
		for (int i = 1; i <= n; i++) {
			father[i] = i;
		}
	}
	
	static int find(int x) {
		while(x!=father[x]) {
			x = father[x];
		}
		return x;
	}
	
	static void union(int a, int b) {
		int fa = find(a), fb = find(b);
		if(fa != fb) {
			father[fa]=fb;
		}
	}
	
	static boolean[] isRoot = new boolean[maxn];
	
	static int n, m; //n个人，m个关系
	
	static int cnt; //集合个数
	
	public static void main(String[] args) {
		n=7; m=5;
		init();
		//序号从1开始
		union(1, 2);
		union(2, 3);
		union(3, 1);
		union(1, 4);
		union(5, 6);
		
		//标记
		for (int i = 1; i <= n; i++) {
			int x = find(i);
			isRoot[x] = true;
		}
		
		for (int i = 1; i <= n; i++) {
			if(isRoot[i]) {
				System.out.println("r " + i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	
	
}
