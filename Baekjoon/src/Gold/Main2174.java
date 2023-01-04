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
		// �������� ����, �������� ������ �Է¹����Ƿ� �׿� ���� Row, Column ���� �������ش�.
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// �κ��� ��ġ�� ������ �����ϴ� �迭
		list = new Robot[N];
		// �κ��� �����̴� ��ǥ��
		map = new int[R][C];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r = R - Integer.parseInt(st.nextToken());
			String temp = st.nextToken();
			int dir = 0;
			// ���� ���⿡ ���� �� ������ ���ڷ� �ٲ��ش�.
			if (temp.equals("N")) {
				dir = 0;
			} else if (temp.equals("E")) {
				dir = 1;
			} else if (temp.equals("S")) {
				dir = 2;
			} else {
				dir = 3;
			}
			// �κ��� ��ġ�� ������ �����Ѵ�.
			list[i] = new Robot(r, c, dir);
			// �κ��� �����̴� ��ǥ�迡 �κ��� ��ġ�� ���� �� �κ��� ��ȣ�� �����Ѵ�.
			map[r][c] = i + 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			// ������ ��ɸ��� ����� �����Ѵ�.
			move(num, command, count);
		}
		System.out.println("OK");
	}

	// ��ɿ� ���� �κ��� ���۽�Ű�� �޼���
	public static void move(int num, String command, int count) {
		// �κ��� ���������� count�� ȸ��
		if (command.equals("R")) {
			Robot robot = list[num - 1];
			int dir = (robot.dir + count) % 4;
			list[num - 1] = new Robot(robot.r, robot.c, dir);
			// �κ��� �������� count�� ȸ��
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
			// �κ��� �̵��� ���̹Ƿ� �κ��� ���� ��ġ�� 0 ����
			map[r][c] = 0;
			int dir = robot.dir;
			for (int i = 0; i < count; i++) {
				r += move[dir][0];
				c += move[dir][1];
				// ���� �ε����� ���
				if (crashedWall(r, c)) {
					System.out.println("Robot " + num + " crashes into the wall");
					System.exit(0);
				}
				// �κ��� �ε����� ���
				if (map[r][c] != 0) {
					System.out.println("Robot " + num + " crashes into robot " + map[r][c]);
					System.exit(0);
				}
			}
			// �κ��̳� ���� �ε����� ������ �� �κ��� ��ġ���� �ٲ��ش�.
			list[num - 1] = new Robot(r, c, dir);
			map[r][c] = num;
		}
	}

	// �迭�� ��� ���� �ε����� ���
	public static boolean crashedWall(int r, int c) {
		if (r < 0 || c < 0 || r >= R || c >= C)
			return true;
		return false;
	}

}