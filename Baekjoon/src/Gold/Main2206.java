package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {

	public static int N, M, map[][];
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean[][][] visited;
	
	// ������ x,y ��ǥ�� �μ� ������ ����, �� �������� ���� �� �ɸ� �ð��� �����ϴ� Ŭ����
	static class Node {
		int x;
		int y;
		int block;
		int time;

		public Node(int x, int y, int block, int time) {
			super();
			this.x = x;
			this.y = y;
			this.block = block;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		System.out.println(bfs());
	}
	
	// bfs�Լ�
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		// �迭���� �� ���� ���� 0 �϶��� ���� �ϳ��� �� �μ��� �̵��� ���, 1�� ��� ���� �ϳ� �μ��� �̵��� ��츦 �����Ѵ�.
		visited = new boolean[2][N][M];
		q.offer(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			// ��ǥ������ �����ϸ� ������� ��ȯ�Ѵ�.
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.time;
			}
			// ���Ž���Ͽ� �̵� �����ϸ� �̵��Ѵ�.
			for (int i = 0; i < 4; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[cur.block][dx][dy]) continue;
				if (map[dx][dy] == 0) {
					// �̵��ϴ� ������ ���� �ƴϸ� ���� �μ��� �ʰ� �̵��Ѵ�.
					q.offer(new Node(dx, dy, cur.block, cur.time + 1));
					visited[cur.block][dx][dy] = true;
				} else if (cur.block == 0) {
					// ���� �̵��ϴ� ������ ���̰�, ���ݱ��� �μ� ���� ������ 0���� ���� �μ��� �̵��Ѵ�.
					q.offer(new Node(dx, dy, cur.block + 1, cur.time + 1));
					visited[cur.block][dx][dy] = true;
				}
			}
		}
		// ��ǥ������ �������� ���ϸ� -1�� ��ȯ�Ѵ�.
		return -1;
	}

}
