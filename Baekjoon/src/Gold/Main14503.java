package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14503 {

	public static int[][] dxdy = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static int M, N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] wall = new int[3];
	public static int answer = Integer.MIN_VALUE;
	public static ArrayList<int[]> virus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// �ʿ��� ������ �Է¹޴´�.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}
		Comb(0, 0);
		System.out.println(answer);
	}

	// ����ִ� ĭ �߿��� ���� ���� 3ĭ�� ���� �ڿ� bfs�Լ��� �����ִ� �޼���
	public static void Comb(int cnt, int idx) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = idx; i < N * M; i++) {
			if (map[i / M][i % M] == 0) {
				wall[cnt] = i;
				Comb(cnt + 1, i + 1);
			}
		}
	}

	public static void bfs() {
		// �� ���� �湮�ߴ��� Ȯ���ϴ� �迭
		visited = new boolean[N][M];
		// map �迭�� �����Ѵ�.
		int[][] checkMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				checkMap[i][j] = map[i][j];
			}
		}
		// ���Ƿ� ������ ���� �߰��Ѵ�.
		for (int i = 0; i < 3; i++) {
			checkMap[wall[i] / M][wall[i] % M] = 1;
		}
		// queue �� �����ϰ� �� queue�� ���̷����� ��ġ�� �߰��Ѵ�.
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}
		// queue�� �̿��Ͽ� bfs �Լ��� �����Ѵ�.
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			visited[cur[0]][cur[1]] = true;
			for (int i = 0; i < 4; i++) {
				int x = cur[0] + dxdy[i][0];
				int y = cur[1] + dxdy[i][1];
				// ���Ž���� ���� ���� �ְ�, �湮���� �ʾ����� ���̷����� ������.
				if (isValid(x, y, checkMap) && !visited[x][y]) {
					checkMap[x][y] = 2;
					visited[x][y] = true;
					q.add(new int[] { x, y });
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (checkMap[i][j] == 0) {
					sum++;
				}
			}
		}
		answer = Math.max(sum, answer);
	}

	// ���̷����� �̵��� �� �ִ��� ���ο� ���� �Ǵ��ϴ� �Լ�
	public static boolean isValid(int x, int y, int[][] checkMap) {
		if (x < 0 || y < 0 || x >= N || y >= M || checkMap[x][y] == 1)
			return false;
		return true;
	}

}
