package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1240 {
	// ����� ���� ������ �Ÿ��� �����ϴ� class
	static class Node {
		int to;
		int length;

		public Node(int to, int length) {
			super();
			this.to = to;
			this.length = length;
		}
	}

	public static int N, M;
	public static ArrayList<Node>[] list;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// �� ��忡 ����� ������ �����ϱ� ���� �迭
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, length));
			list[to].add(new Node(from, length));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			calc(from, to);
		}
		System.out.println(sb);
	}

	// �� ��� ������ �ű⸦ ���ϴ� �޼���
	public static void calc(int from, int to) {
		Queue<Node> q = new ArrayDeque<>();
		visited[from] = true;
		for (int i = 0; i < list[from].size(); i++) {
			q.add(list[from].get(i));
		}
		while (!q.isEmpty()) {
			Node start = q.poll();
			// ��ǥ ������ �����ϸ� �� ���� StringBuilder�� �߰��Ѵ�.
			if (start.to == to) {
				sb.append(start.length).append("\n");
				return;
			}
			visited[start.to] = true;
			int size = list[start.to].size();
			for (int i = 0; i < size; i++) {
				Node end = list[start.to].get(i);
				// ���� ������ �湮���� �ʾҴٸ� queue�� �߰��Ѵ�. �� ��, �� ���������� �ɸ��� ���ݱ��� �� �Ÿ� + ���� �������� ���� �Ÿ��̴�.
				if (!visited[end.to]) {
					q.add(new Node(end.to, end.length + start.length));
				}
			}
		}
	}
}