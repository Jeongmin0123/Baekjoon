package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2174 {
	static class Robot {
		int r;
		int c;
		int dir;

		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // N,E,S,W
	public static Robot[] list;
	public static int R, C, N, M;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 가로축의 길이, 세로축의 순으로 입력받으므로 그에 따라 Row, Column 값을 지정해준다.
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 로봇의 위치와 방향을 저장하는 배열
		list = new Robot[N];
		// 로봇이 움직이는 좌표계
		map = new int[R][C];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r = R - Integer.parseInt(st.nextToken());
			String temp = st.nextToken();
			int dir = 0;
			// 받은 방향에 따라 그 방향을 숫자로 바꿔준다.
			if (temp.equals("N")) {
				dir = 0;
			} else if (temp.equals("E")) {
				dir = 1;
			} else if (temp.equals("S")) {
				dir = 2;
			} else {
				dir = 3;
			}
			// 로봇의 위치와 방향을 저장한다.
			list[i] = new Robot(r, c, dir);
			// 로봇이 움직이는 좌표계에 로봇의 위치에 따라 그 로봇의 번호를 저장한다.
			map[r][c] = i + 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			// 각각의 명령마다 명령을 수항한다.
			move(num, command, count);
		}
		System.out.println("OK");
	}

	// 명령에 따라 로봇을 동작시키는 메서드
	public static void move(int num, String command, int count) {
		// 로봇을 오른쪽으로 count번 회전
		if (command.equals("R")) {
			Robot robot = list[num - 1];
			int dir = (robot.dir + count) % 4;
			list[num - 1] = new Robot(robot.r, robot.c, dir);
			// 로봇을 왼쪽으로 count번 회전
		} else if (command.equals("L")) {
			Robot robot = list[num - 1];
			int dir = robot.dir;
			for (int i = 0; i < count; i++) {
				if (dir == 0)
					dir = 3;
				else
					dir--;
			}
			list[num - 1] = new Robot(robot.r, robot.c, dir);
		} else {
			Robot robot = list[num - 1];
			int r = robot.r;
			int c = robot.c;
			// 로봇이 이동할 것이므로 로봇의 현재 위치에 0 대입
			map[r][c] = 0;
			int dir = robot.dir;
			for (int i = 0; i < count; i++) {
				r += move[dir][0];
				c += move[dir][1];
				// 벽에 부딪히는 경우
				if (crashedWall(r, c)) {
					System.out.println("Robot " + num + " crashes into the wall");
					System.exit(0);
				}
				// 로봇과 부딪히는 경우
				if (map[r][c] != 0) {
					System.out.println("Robot " + num + " crashes into robot " + map[r][c]);
					System.exit(0);
				}
			}
			// 로봇이나 벽에 부딪히지 않으면 그 로봇의 위치값을 바꿔준다.
			list[num - 1] = new Robot(r, c, dir);
			map[r][c] = num;
		}
	}

	// 배열을 벗어나 벽에 부딪히는 경우
	public static boolean crashedWall(int r, int c) {
		if (r < 0 || c < 0 || r >= R || c >= C)
			return true;
		return false;
	}

}