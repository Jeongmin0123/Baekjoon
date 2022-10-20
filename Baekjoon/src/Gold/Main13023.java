package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13023 {

	// 시작점과 끝점에 대한 정보, 즉 친구 관계를 저장하는 클래스
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
		// Edge들의 집합
		list = new Edge[N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			// 두 사람이 친구관계인 경우 연결해준다
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			// 입력받은 Edge들을 연결해준다.
			list[n1] = new Edge(n2, list[n1]);
			list[n2] = new Edge(n1, list[n2]);
		}
		// 모든 노드에 대하여 depth를 조사한다
		for(int i = 0 ; i < N ; i++) {
			dfs(i,1);
		}
		System.out.println(0);
	}

	// dfs 알고리즘을 이용하여 시작점에서 depth가 5가 존재하는 경우가 A는 E와 연결된 경우이므로 그 즉시 1을 출력하고 연산을 종료한다.
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

