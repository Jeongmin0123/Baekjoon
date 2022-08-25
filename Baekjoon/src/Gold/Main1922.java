package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1922 {

	public static int[] parents;
	public static boolean[] visited;
	public static int N,M;
	public static int count, sum;
	// a�� ���� ��带 ã�� �Լ�
	public static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	// ������ ���Ұ� 1���� �����ϴ� ���μ� ������ ����� �Լ�
	public static void make() {
		parents = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			parents[i] = i;
		}
	}
	
	// a,b�� ���� ���տ� �ִ��� �Ǵ��Ͽ� ���� ���տ� ������ ���� �������ϰ� ������ false�� ��ȯ�ϴ� �Լ�
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	// ���� ��ġ, ���� ��ġ, ���� �����ϴ� Ŭ����
	static class Edge implements Comparable<Edge> {
		int now;
		int next;
		int value;
		
		public Edge(int now, int next, int value) {
			super();
			this.now = now;
			this.next = next;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
		
		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Edge[] network = new Edge[M];
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			network[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// ���߰� ������ �����Ѵ�.
		Arrays.sort(network);
		make();
		
		for(int i = 0 ; i < M ; i++) {
			// ��� ��带 �� Ž���ϸ� �ߴ��Ѵ�.
			if(count == N - 1) break;
			// ���� ���� ���տ� ������ ��ģ �ڿ� ���߰��� �����ְ� ������ ������ ���� ������ �����Ѵ�.
			if(union(network[i].now, network[i].next)) {
				count++;
				sum += network[i].value;
			}
		}
		
		System.out.println(sum);
	}
}

