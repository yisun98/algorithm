package review;

public class 并查集 {
	static int maxn = 1000+10;
	static int[] father = new int[maxn];
	
	static int n;
	
	static void init() {
		for (int i = 0; i < n; i++) {
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
	
	static int findwithcompress(int x) {
		
		int xx = x;
		
		while(x!=father[x]) {
			x = father[x];
		}
		//路径上的全部指向x
		while(xx!=father[xx]) {
			int z = xx;
			xx = father[xx];
			father[z] = x;
		}
		return x;
	}
}
