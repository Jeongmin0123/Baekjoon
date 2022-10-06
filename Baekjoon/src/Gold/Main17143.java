package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17143 {

	static class Shark {

		int speed;
		int dir;
		int size;

		public Shark(int speed, int dir, int size) {
			super();
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	public static int R, C, M, answer;
	public static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	public static Shark[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		// ����� ������ �����Ѵ�.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new Shark(
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}
		fishingShark();
		System.out.println(answer);
	}
	
	// ���ð� ���� ��, ����� �����ӿ� ���� map�� �ٲ��ش�.
	public static void changeMap() {
		Shark[][] copy = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					sharkMove(copy, map[i][j], i, j);
				}
			}
		}
		map = copy;
	}

	// �� �̵���Ű�� �޼���
	public static void sharkMove(Shark[][] copy, Shark shark, int x, int y) {
		int dir = shark.dir;
		int dx = x + move[dir][0] * shark.speed;
		int dy = y + move[dir][1] * shark.speed;
		// �迭�� ���� ���� ���� ������ ������ �ݺ��Ѵ�.
		// 0�� �������� �����شٰ� �����Ѵ�. ��α� ���� Ȯ��
		while(dx < 0 || dy < 0 || dx >= R || dy >= C) {
			if(dx < 0) {
				dir++;
				dx = Math.abs(dx);
			} else if(dx >= R) {
				dir--;
				int temp=dx-(R-1);
                dx-=temp*2;
			} else if(dy < 0) {
				dir--;
				dy = Math.abs(dy);
			} else {
				dir++;
				int temp=dy-(C-1);
                dy-=temp*2;
			}
		}
		if (copy[dx][dy] == null || copy[dx][dy].size < shark.size) {
			copy[dx][dy] = new Shark(shark.speed, dir, shark.size);
		}
	}
	// �� ���� �޼���, ��ĭ�� ������ �̵��ϸ� �� ���´�.
	public static void fishingShark() {
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				if (map[i][j] != null) {
					answer += map[i][j].size;
					map[i][j] = null;
					break;
				}
			}
			changeMap();
		}

	}

	
}

