package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main16954 {
	// 좌표를 저장하는 class
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
	// 상하좌우, 4대각선방향, 그리고 제자리로 이동 총 9가지의 이동을 저장하는 배열이다
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
		// 시작점을 queue에 넣어준다.
		q.add(new Node(7, 0));
		while (!q.isEmpty()) {
			// 같은 깊이에 있는 좌표들만 이동시켜준다.
			int size = q.size();
			visited = new boolean[8][8];
			for (int a = 0; a < size; a++) {
				Node cur = q.poll();
				// 목표지점에 도달한 경우
				if (cur.x == 0 && cur.y == 7) {
					answer = 1;
					return;
				}
				// 벽에 깔린 경우 연산을 하지 않는다.
				if (map[cur.x][cur.y] == '#')
					continue;
				for (int i = 0; i < 9; i++) {
					int dx = cur.x + move[i][0];
					int dy = cur.y + move[i][1];
					if (!isValid(dx, dy))
						continue;
					if (map[dx][dy] == '#')
						continue;
					// 이동하는 지점이 벽이 아니고, 배열 내에 존재하면서 방문하지 않은 경우 그 지점으로 이동한다.
					if (!visited[dx][dy]) {
						visited[dx][dy] = true;
						q.add(new Node(dx, dy));
					}
				}
			}
			moveWall();
		}
	}

	// 벽을 아래로 한칸씩 이동시키는 메서드
	public static void moveWall() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					map[i][j] = '.';
					// 맨 마지막 줄이 아닌경우, 벽을 아래로 한칸 이동시킨다.
					if (i != 7) {
						map[i + 1][j] = '#';
					}
				}
			}
		}
	}

	// 좌표가 배열의 범위 내에 존재하는지 판단하는 메서드
	public static boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= 8 || y >= 8)
			return false;
		return true;
	}
}