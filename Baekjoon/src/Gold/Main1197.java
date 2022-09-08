package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1197 {

	// �� ������ ����ġ�� �����ϴ� class, ���Ľ� ����ġ�� �������� ���ĵǵ��� �Ѵ�.
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	// �� ������ ����Ǿ� �ִ��� �Ǵ��ϱ� ���� �迭
	public static int[] parents;
	// ������ ������ ����
	public static int V,E;
	// ������ ������ �����ϴ� �迭
	public static Edge[] edgelist;
	
	// �� ������ ����Ǿ��ִ��� Ȯ���ϱ� ���� �迭 ����
	public static void make () {
		parents = new int[V];
		for(int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
	
	// ��� ������ �θ��带 ã�� �޼���
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// �� ��尡 ����Ǿ� ���� ������ �� ��带 �����Ű�� �޼���
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgelist = new Edge[E];
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ������ �������� 1�̹Ƿ� 1�� ���ش�.
			edgelist[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		make();
		Arrays.sort(edgelist);
		int sum = 0;
		int count = 0;
		// ���� ������ �Ǿ����� ������ �����ϰ�, �� ����ġ�� ������� �����ش�.
		for(Edge edge : edgelist) {
			if(union(edge.from,edge.to)) {
				sum += edge.weight;
				count++;
				// V���� ������ �� ����Ǿ����� �����Ѵ�.
				if(count == V-1) break;
			}
		}
		System.out.println(sum);
	}

}
