package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13023 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	public static int N, M;
	public static Node[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// node들의 집합
		list = new Node[N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			// 입력받은 node들을 연결해준다.
			list[n1] = new Node(n2, list[n1]);
			list[n2] = new Node(n1, list[n2]);
		}
		// 모든 노드에 대하여 depth를 조사한다
		for(int i = 0 ; i < N ; i++) {
			dfs(i,1);
		}
		System.out.println(0);
	}

	// dfs 알고리즘을 이용하여 시작점에서 depth가 5가 존재하는 경우 1을 출력한 뒤 종료하는 메서드
	public static void dfs(int cur, int depth) {
		visited[cur] = true;
		if (depth == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (Node node = list[cur]; node != null; node = node.next) {
			if(!visited[node.to]) {
				dfs(node.to, depth+1);
			}
		}
		
		visited[cur] = false;
	}

}

