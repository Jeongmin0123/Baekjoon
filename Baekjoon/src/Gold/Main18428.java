package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18428 {
	
	// �������� ��ǥ�� ������ Ŭ����
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static int N;
	public static String[][] map;
	public static int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
			}
		}
		flag = false;
		dfs(0);
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	// ����ִ� ĭ �߿��� ��ֹ��� 3ĭ ��ġ�ϴ� �޼���
	public static void dfs(int cnt) {
		// ��ֹ��� �� ��ġ�� ���, �� ��찡 ���ø� ���� �� �ִ��� �Ǵ��Ѵ�.
		if (cnt == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("X")) {
					map[i][j] = "O";
					dfs(cnt + 1);
					map[i][j] = "X";
				}
			}
		}
	}

	public static void bfs() {
		// map�� ���鼭 �������� ��� queue�� �߰��Ѵ�.
		Queue<Node> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("T")) {
					q.offer(new Node(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			// �������� ��ġ�� �������� ������ �������� 4�� Ž���� ���� ��, ���ø� ���� �� �ִ� ��� flag�� true�� �ٲ۴�.
			for (int i = 0; i < 4; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				while (true) {
					// �迭���� ����ų�, �ٸ� ������, ��ֹ��� ���� ��� ���� ������ �����Ѵ�.
					if (!isValid(dr, dc) || map[dr][dc].equals("O") || map[dr][dc].equals("T")) break;
					// �л��� ���� ��� ���̻� ������ ������ �ʿ䰡 ���� ������ return �Ѵ�.
					if (map[dr][dc].equals("S")) return;
					dr += move[i][0];
					dc += move[i][1];
				}
			}
		}
		flag = true;
	}

	// �迭�� ������� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N)
			return false;
		return true;
	}
}