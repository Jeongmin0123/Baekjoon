package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {

	// ����� ��ǥ, �ɸ� �ð�, �׸��� ���� ������ �ִ� ������ ������ �����ϴ� Ŭ����
	static class Person {
		int r;
		int c;
		int time;
		int keys;
		
		public Person(int r, int c, int time, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.keys = keys;
		}
	}
	public static int N,M;
	public static char[][] map;
	public static boolean[][][] visited;
	public static Queue<Person> q;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// ������ ������ 6���̹Ƿ� ���� �� �ִ� ���� �迭�� ������ 2�� 6������ 64�̴�.
		// �湮 ó���� ���� ���� �迭�� ���� �ٸ��� �ؾ� �ϹǷ� 3���� �迭�� ����� ����,����,���� �迭�� ������ ������� ũ��� �����Ѵ�.
		visited = new boolean[N][M][64];
		map = new char[N][M];
		q = new ArrayDeque<>();
		// �Է¹ް�, �������� Queue�� �߰��Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == '0') {
					q.offer(new Person(i,j,0,0));
					visited[i][j][0] = true;
				}
			}
		}
		bfs();
	}

	// bfs �Լ�
	public static void bfs() {
		while(!q.isEmpty()) {
			Person cur = q.poll();
			int nowkey = cur.keys;
			// Ż������ �����ϸ� �ɸ� �ð��� ��ȯ�ϰ� �����Ѵ�.
			if(map[cur.r][cur.c] == '1') {
				System.out.println(cur.time);
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// ���� �����ų�, �迭 ���� �����ų� �湮�� �� ������ ���� ������ �����Ѵ�.
				if(!isValid(dr,dc) || map[dr][dc] == '#' || visited[dr][dc][nowkey]) continue;
				// ���踦 ���� ���, ���� ������ �ִ� ���� �迭�� ���� ���踦 �߰��� ��, �湮ó���� �ϰ� �� ������ queue�� �߰��Ѵ�.
				if(map[dr][dc] - 'a' >= 0 && map[dr][dc] - 'a' < 6) {
					int nextkey = (nowkey | (1 << (map[dr][dc] - 'a')));
					if(!visited[dr][dc][nextkey]) {
						visited[dr][dc][nowkey] = true;
						visited[dr][dc][nextkey] = true;
						q.offer(new Person(dr,dc,cur.time + 1, nextkey));
					}
				}
				// ���� ���� ���, ���谡 �ִ� ��쿡 �� ������ �̵��ϰ� �湮ó���� �� �� �� ������ queue�� �߰��Ѵ�.
				else if(map[dr][dc] - 'A' >= 0 && map[dr][dc] - 'A' < 6) {
					int temp = nowkey & (1 << (map[dr][dc] - 'A'));
					if(temp > 0) {
						visited[dr][dc][nowkey] = true;
						q.offer(new Person(dr,dc,cur.time + 1, nowkey));
					}
				}
				// .�� ��� �̵��ϰ� �湮ó���� �Ѵ�.
				else {
					visited[dr][dc][nowkey] = true;
					q.offer(new Person(dr,dc,cur.time+1,nowkey));
				}
			}
		}
		System.out.println(-1);
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) return false;
		return true;
	}
	
}


