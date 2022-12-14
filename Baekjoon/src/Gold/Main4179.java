package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4179 {
	static class Node {
		int r;
		int c;
		int time;
		public Node(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	public static char[][] map;
	public static int R,C;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static Queue<Node> jihoon;
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		jihoon = new ArrayDeque<>();
		visited = new boolean[R][C];
		// �������� ��ġ�� ã�� queue�� �ְ� �湮ó���� ���ش�.
		for(int i = 0 ; i < R ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == 'J') {
					jihoon.add(new Node(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		bfs();
	}
	public static void bfs() {
		Queue<Node> fire = new ArrayDeque<>();
		boolean[][] burn = new boolean[R][C];
		// ���� ��ġ�� �޾ƿ� queue�� �־��ش�
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 'F') fire.add(new Node(i,j,0));
			}
		}
		// �����̰� ������ �� ���������� �ݺ��Ѵ�.
		while(true) {
			// 1�ʸ��� �Ұ� �����̰� 1��ŭ �������� �ϹǷ� �� ���� ����Ŭ�� ������ queue�� ũ�⸸ŭ �ݺ��Ѵ�.
			int size1 = jihoon.size();
			int size2 = fire.size();
			for(int i = 0 ; i < size2 ; i++) {
				Node cur = fire.poll();
				for(int j = 0 ; j < 4 ; j++) {
					int dr = cur.r + move[j][0];
					int dc = cur.c + move[j][1];
					if(!isValid(dr,dc)) {
						continue;
					}
					// ���� �ƴϰ� �湮���� ���� ���̸� queue�� �߰��ϰ�, map[i][j] ���� �ٲ� ��, �湮ó���� ���ش�.
					if(map[dr][dc] != '#' && !burn[dr][dc]) {
						fire.offer(new Node(dr,dc,cur.time+1));
						map[dr][dc] = 'F';
						burn[dr][dc] = true;
					}
				}
			}
			for(int i = 0 ; i < size1 ; i++) {
				Node cur = jihoon.poll();
				for(int j = 0 ; j < 4 ; j++) {
					int dr = cur.r + move[j][0];
					int dc = cur.c + move[j][1];
					// ���� �迭�� ������ ��� ��� Ż���� ���̹Ƿ� Ż�� �ð��� ����ϰ� �����Ѵ�.
					if(!isValid(dr,dc)) {
						System.out.println(cur.time+1);
						System.exit(0);
					}
					if(map[dr][dc] != '#' && map[dr][dc] != 'F' && !visited[dr][dc]) {
						jihoon.offer(new Node(dr,dc,cur.time+1));
						visited[dr][dc] = true;
					}
				}
			}
			// �� �̻� �����̰� ������ �� ���� ��� while���� �����Ѵ�.
			if(size1 == 0) break;
		}
		// �Ұ����� ���
		System.out.println("IMPOSSIBLE");
		return;
	}
	// �迭�� ������ ������� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}
