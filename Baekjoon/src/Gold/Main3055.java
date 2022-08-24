package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {

	public static int R, C;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] dxdy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		int[] beavor = new int[2]; // ����� ��ġ
		List<int[]> water = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'S') {
					beavor[0] = i;
					beavor[1] = j;
				} else if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}
			}
		}
		bfs(beavor, water);
	}

	// ����� ���� ��ġ�� �̵��� �� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean isValid_Beavor(int x, int y) {
		if (x < 0 || y < 0 || x >= R || y >= C) {
			return false;
		}
		if (map[x][y] == 'X') {
			return false;
		}
		if (map[x][y] == '*') {
			return false;
		}
		return true;
	}

	// ���� ���� ��ġ�� �̵��� �� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean isValid_Water(int x, int y) {
		if (x < 0 || y < 0 || x >= R || y >= C) {
			return false;
		}
		if (map[x][y] == 'X') {
			return false;
		}
		if (map[x][y] == 'D') {
			return false;
		}
		return true;
	}

	// bfs �Լ�
	public static void bfs(int[] beavor, List<int[]> water) {
		Queue<int[]> q = new ArrayDeque<>();
		// �� ó���� �Է¹��� ���� ��ġ�� queue�� �־��ش�.
		for (int i = 0; i < water.size(); i++) {
			int[] temp = water.get(i);
			visited[temp[0]][temp[1]] = true;
			q.add(temp);
		}
		// ����� ��ġ�� queue�� �־��ش�
		q.add(beavor);
		// ó���� ���� �� �ִ� ����� ��ġ ���� 1���̹Ƿ� 1�� �����Ѵ�.
		int beavor_count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			// �� �������� ������ŭ ������ �ݺ��Ѵ�.
			for (int i = 0; i < size - beavor_count; i++) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int dx = cur[0] + dxdy[j][0];
					int dy = cur[1] + dxdy[j][1];
					// ��濡 ���Ͽ� �̵������ϰ� �湮�� �� ������ �� ������ *�� �ٲٰ� queue�� �߰��Ѵ�
					if (isValid_Water(dx, dy) && !visited[dx][dy]) {
						visited[dx][dy] = true;
						map[dx][dy] = '*';
						q.add(new int[] { dx, dy });
					}
				}
			}
			int count = 0;
			// ����� ���� �� �ִ� ��ġ�� ����ŭ ������ �ݺ��Ѵ�.
			for (int a = 0; a < beavor_count; a++) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int dx = cur[0] + dxdy[j][0];
					int dy = cur[1] + dxdy[j][1];
					// ���� ��ǥ������ �����ϸ� �ð��� ����ϰ� �����Ѵ�
					if (isValid_Beavor(dx, dy) && map[dx][dy] == 'D') {
						cnt++;
						System.out.println(cnt);
						System.exit(0);
					}
					// ������ �� �ְ� �� ������ �湮�� �� ������ �� ������ �湮�ϰ� �� ������ ����� �߰��Ѵ�.
					// ���� ť�� �߰��ϰ� �湮����� �����.
					if (isValid_Beavor(dx, dy) && !visited[dx][dy]) {
						visited[dx][dy] = true;
						map[dx][dy] = 'S';
						q.add(new int[] { dx, dy });
						visited[dx][dy] = false;
						count++;
					}
				}
			}
			beavor_count = count;
			cnt++;
		}
		// �Ұ��� �� ����Ѵ�.
		System.out.println("KAKTUS");
	}

}

