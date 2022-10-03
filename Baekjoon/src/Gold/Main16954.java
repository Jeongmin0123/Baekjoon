package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main16954 {
	// ��ǥ�� �����ϴ� class
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static char[][] map;
	public static int answer = 0;
	// �����¿�, 4�밢������, �׸��� ���ڸ��� �̵� �� 9������ �̵��� �����ϴ� �迭�̴�
	public static int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
			{ 0, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		bfs();
		System.out.println(answer);
	}

	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited;
		// �������� queue�� �־��ش�.
		q.add(new Node(7, 0));
		while (!q.isEmpty()) {
			// ���� ���̿� �ִ� ��ǥ�鸸 �̵������ش�.
			int size = q.size();
			visited = new boolean[8][8];
			for (int a = 0; a < size; a++) {
				Node cur = q.poll();
				// ��ǥ������ ������ ���
				if (cur.x == 0 && cur.y == 7) {
					answer = 1;
					return;
				}
				// ���� �� ��� ������ ���� �ʴ´�.
				if (map[cur.x][cur.y] == '#')
					continue;
				for (int i = 0; i < 9; i++) {
					int dx = cur.x + move[i][0];
					int dy = cur.y + move[i][1];
					if (!isValid(dx, dy))
						continue;
					if (map[dx][dy] == '#')
						continue;
					// �̵��ϴ� ������ ���� �ƴϰ�, �迭 ���� �����ϸ鼭 �湮���� ���� ��� �� �������� �̵��Ѵ�.
					if (!visited[dx][dy]) {
						visited[dx][dy] = true;
						q.add(new Node(dx, dy));
					}
				}
			}
			moveWall();
		}
	}

	// ���� �Ʒ��� ��ĭ�� �̵���Ű�� �޼���
	public static void moveWall() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					map[i][j] = '.';
					// �� ������ ���� �ƴѰ��, ���� �Ʒ��� ��ĭ �̵���Ų��.
					if (i != 7) {
						map[i + 1][j] = '#';
					}
				}
			}
		}
	}

	// ��ǥ�� �迭�� ���� ���� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= 8 || y >= 8)
			return false;
		return true;
	}
}