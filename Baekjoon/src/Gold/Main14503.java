package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {

	// ���Ž���� ���� �迭, �ϵ����� ������ �����Ѵ�.
	public static int[][] XY = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static int[][] map;
	public static boolean[][] visited;
	public static int N, M, answer;
	public static int x, y, dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		answer = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs();
		System.out.println(answer);
	}

	public static void dfs() {
		// �湮ó��
		visited[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			// �������� ȸ����Ų��.
			dir = (dir + 3) % 4;
			int dx = x +XY[dir][0];
			int dy = y +XY[dir][1];
			// ���� ȸ���� ������ û������ �ʾҰ�, ���� �ƴ϶�� �� ��ġ�� �̵��Ѵ�.
			if(map[dx][dy] == 0 && !visited[dx][dy]) {
				answer++;
				x = dx;
				y = dy;
				dfs();
				return;
			}
		}
		// ������� ������ �� ���ٸ� �ڷ� ����.
		int back = (dir+2)%4;
		if(map[x+XY[back][0]][y+XY[back][1]] != 1) {
			x += XY[back][0];
			y += XY[back][1];
			dfs();
			return;
		}
	}
}
