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
		int[] beavor = new int[2]; // 비버의 위치
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

	// 비버가 받은 위치로 이동할 수 있는지 판단하는 메서드
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

	// 물이 받은 위치로 이동할 수 있는지 판단하는 메서드
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

	// bfs 함수
	public static void bfs(int[] beavor, List<int[]> water) {
		Queue<int[]> q = new ArrayDeque<>();
		// 맨 처음에 입력받은 물의 위치를 queue에 넣어준다.
		for (int i = 0; i < water.size(); i++) {
			int[] temp = water.get(i);
			visited[temp[0]][temp[1]] = true;
			q.add(temp);
		}
		// 비버의 위치를 queue에 넣어준다
		q.add(beavor);
		// 처음에 있을 수 있는 비버의 위치 수는 1개이므로 1로 지정한다.
		int beavor_count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			// 물 웅덩이의 개수만큼 연산을 반복한다.
			for (int i = 0; i < size - beavor_count; i++) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int dx = cur[0] + dxdy[j][0];
					int dy = cur[1] + dxdy[j][1];
					// 사방에 대하여 이동가능하고 방문한 적 없으면 그 지점을 *로 바꾸고 queue에 추가한다
					if (isValid_Water(dx, dy) && !visited[dx][dy]) {
						visited[dx][dy] = true;
						map[dx][dy] = '*';
						q.add(new int[] { dx, dy });
					}
				}
			}
			int count = 0;
			// 비버가 있을 수 있는 위치의 수만큼 연산을 반복한다.
			for (int a = 0; a < beavor_count; a++) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int dx = cur[0] + dxdy[j][0];
					int dy = cur[1] + dxdy[j][1];
					// 만약 목표지점에 도착하면 시간을 출력하고 종료한다
					if (isValid_Beavor(dx, dy) && map[dx][dy] == 'D') {
						cnt++;
						System.out.println(cnt);
						System.exit(0);
					}
					// 움직일 수 있고 그 지점을 방문한 적 없으면 그 지점을 방문하고 그 지점에 비버를 추가한다.
					// 이후 큐에 추가하고 방문기록을 지운다.
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
		// 불가능 시 출력한다.
		System.out.println("KAKTUS");
	}

}

