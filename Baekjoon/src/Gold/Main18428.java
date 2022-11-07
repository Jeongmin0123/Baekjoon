package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18428 {
	
	// 선생님의 좌표를 저장할 클래스
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

	// 비어있는 칸 중에서 장애물을 3칸 설치하는 메서드
	public static void dfs(int cnt) {
		// 장애물을 다 설치한 경우, 그 경우가 감시를 피할 수 있는지 판단한다.
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
		// map을 돌면서 선생님인 경우 queue에 추가한다.
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
			// 선생님의 위치를 기준으로 일정한 방향으로 4방 탐색을 했을 때, 감시를 피할 수 있는 경우 flag를 true로 바꾼다.
			for (int i = 0; i < 4; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				while (true) {
					// 배열밖을 벗어나거나, 다른 선생님, 장애물을 만난 경우 다음 연산을 진행한다.
					if (!isValid(dr, dc) || map[dr][dc].equals("O") || map[dr][dc].equals("T")) break;
					// 학생을 만난 경우 더이상 연산을 진행할 필요가 없기 때문에 return 한다.
					if (map[dr][dc].equals("S")) return;
					dr += move[i][0];
					dc += move[i][1];
				}
			}
		}
		flag = true;
	}

	// 배열을 벗어났는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N)
			return false;
		return true;
	}
}