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
	
	// 지점의 x,y 좌표와 부순 벽돌의 개수, 그 곳까지는 가는 데 걸린 시간을 저장하는 클래스
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
	
	// bfs함수
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		// 배열에서 맨 앞의 값이 0 일때는 벽을 하나도 안 부수고 이동한 경우, 1인 경우 벽을 하나 부수고 이동한 경우를 저장한다.
		visited = new boolean[2][N][M];
		q.offer(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			// 목표지점에 도달하면 결과값으 반환한다.
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.time;
			}
			// 사방탐색하여 이동 가능하면 이동한다.
			for (int i = 0; i < 4; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(dx < 0 || dy < 0 || dx >= N || dy >= M || visited[cur.block][dx][dy]) continue;
				if (map[dx][dy] == 0) {
					// 이동하는 지점이 벽이 아니면 벽을 부수지 않고 이동한다.
					q.offer(new Node(dx, dy, cur.block, cur.time + 1));
					visited[cur.block][dx][dy] = true;
				} else if (cur.block == 0) {
					// 만약 이동하는 지점이 벽이고, 지금까지 부순 벽의 개수가 0개면 벽을 부수고 이동한다.
					q.offer(new Node(dx, dy, cur.block + 1, cur.time + 1));
					visited[cur.block][dx][dy] = true;
				}
			}
		}
		// 목표지점에 도달하지 못하면 -1을 반환한다.
		return -1;
	}

}
