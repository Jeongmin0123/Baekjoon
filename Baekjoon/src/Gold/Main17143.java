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
		// 상어의 정보를 저장한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new Shark(
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}
		fishingShark();
		System.out.println(answer);
	}
	
	// 낚시가 끝난 뒤, 상어의 움직임에 따라 map을 바꿔준다.
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

	// 상어를 이동시키는 메서드
	public static void sharkMove(Shark[][] copy, Shark shark, int x, int y) {
		int dir = shark.dir;
		int dx = x + move[dir][0] * shark.speed;
		int dy = y + move[dir][1] * shark.speed;
		// 배열의 범위 내로 들어올 때까지 연산을 반복한다.
		// 0을 기준으로 접어준다고 생각한다. 블로그 설명 확인
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
	// 상어를 낚는 메서드, 한칸씩 옆으로 이동하며 상어를 낚는다.
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

