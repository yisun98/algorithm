package review;

import java.util.Arrays;
import java.util.Comparator;

public class 最小生成树kruskual {
	static int maxn = 1000+10;
	static class Edge {
		int u;
		int v;
		int w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int[] father = new int[maxn];
	

	static Edge[] edges = new Edge[maxn];
	
	static int n, m;
	
	static int sum;

	static int cnt; //已选边的数目
	
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
	
	static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa==fb) {  //会有回路
			return false;
		}
		father[fa] = fb;
		return true;
	}
	
	static void kru() {
		
		for (int i = 0; i < m; i++) { //枚举每条边
			Edge edge = edges[i];
			int u = edge.u; int v = edge.v; int w = edge.w;
			if(union(u, v)) {
				sum += w;
				cnt++;
			}
			if(cnt == n-1) {
				return;
			}
		}
		
	}
	
	public static void main(String[] args) {
		n = 6; m = 9;
		init();
		edges[0] = new Edge(1, 3, 11);
		edges[1] = new Edge(2, 4, 13);
		edges[2] = new Edge(3, 5, 3);
		edges[3] = new Edge(4, 5, 4);
		edges[4] = new Edge(1, 2, 6);
		edges[5] = new Edge(3, 4, 7);
		edges[6] = new Edge(0, 1, 1);
		edges[7] = new Edge(2, 3, 9);
		edges[8] = new Edge(0, 2, 2);
		Arrays.sort(edges, 0, m, new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.w - e2.w; //小的在前
			}
		});
		
		kru();
		System.out.println(sum);
	}
}
