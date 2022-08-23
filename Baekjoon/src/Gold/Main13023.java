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
		// node���� ����
		list = new Node[N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			// �Է¹��� node���� �������ش�.
			list[n1] = new Node(n2, list[n1]);
			list[n2] = new Node(n1, list[n2]);
		}
		// ��� ��忡 ���Ͽ� depth�� �����Ѵ�
		for(int i = 0 ; i < N ; i++) {
			dfs(i,1);
		}
		System.out.println(0);
	}

	// dfs �˰����� �̿��Ͽ� ���������� depth�� 5�� �����ϴ� ��� 1�� ����� �� �����ϴ� �޼���
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

