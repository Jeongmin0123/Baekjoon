package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13023 {

	// �������� ������ ���� ����, �� ģ�� ���踦 �����ϴ� Ŭ����
	static class Edge {
		int to;
		Edge next;

		public Edge(int to, Edge next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	public static int N, M;
	public static Edge[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// Edge���� ����
		list = new Edge[N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			// �� ����� ģ�������� ��� �������ش�
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			// �Է¹��� Edge���� �������ش�.
			list[n1] = new Edge(n2, list[n1]);
			list[n2] = new Edge(n1, list[n2]);
		}
		// ��� ��忡 ���Ͽ� depth�� �����Ѵ�
		for(int i = 0 ; i < N ; i++) {
			dfs(i,1);
		}
		System.out.println(0);
	}

	// dfs �˰����� �̿��Ͽ� ���������� depth�� 5�� �����ϴ� ��찡 A�� E�� ����� ����̹Ƿ� �� ��� 1�� ����ϰ� ������ �����Ѵ�.
	public static void dfs(int cur, int depth) {
		visited[cur] = true;
		if (depth == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (Edge Edge = list[cur]; Edge != null; Edge = Edge.next) {
			if(!visited[Edge.to]) {
				dfs(Edge.to, depth+1);
			}
		}
		
		visited[cur] = false;
	}

}

