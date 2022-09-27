package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573 {

	// ������ ��ġ�� ���� Ŭ����
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static int result = 0;
	public static int N,M;
	public static int[][] map;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean[][] visited;
	public static Queue<Node> list = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ������ ��� ����
		int count = 0;
		// ���� ����� ������ 2������ ���� ��쿡�� ������ �����Ѵ�.
		while((count = count()) < 2) {
			// ����� 0����� ������ �� �ʿ䰡 �����Ƿ� 0�� ����ϰ� �����Ѵ�.
			if(count == 0) {
				System.out.println(0);
				System.exit(0);
			}
			// �� ����Ŭ�� �� ������ �ð��� 1�� ������Ų��.
			bfs();
			result++;
		}
		System.out.println(result);
	}

	// ������ ��� ������ ��ȯ�ϴ� �޼���
	public static int count() {
		int count = 0;
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		return count;
	}
	
	// ������ �����ϴ� ������ �߰��ϸ� �� ��ġ���� ���� �켱 Ž���� �Ͽ� ����� ��� ������ �ϳ��� �ν��Ѵ�.
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			if(isValid(dx,dy) && map[dx][dy] != 0 && !visited[dx][dy]) {
				dfs(dx,dy);
			}
		}
	}
	
	// �� ����Ŭ�� ������ ���̴� �޼���
	public static void bfs() {
		boolean[][] visited = new boolean[N][M];
		// ������ ��� queue�� �־��ش�.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] != 0) {
					list.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		// queue�� ��� ������ �� ����Ŭ�̹Ƿ� ť�� �� ������ ������ ����Ѵ�.
		while(!list.isEmpty()) {
			Node cur = list.poll();
			// ���� ������ ��
			int lose = 0;
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(isValid(dx,dy) && map[dx][dy] == 0 && !visited[dx][dy]) {
					lose++;
				}
			}
			// ��� ���� ���� ������ �纸�� ũ�� ������ ��� ���δ�.
			if(map[cur.x][cur.y] - lose < 0) {
				map[cur.x][cur.y] = 0;
			} else {
				map[cur.x][cur.y] -= lose;
			}
		}
	}
	
	// �迭�� ���� ���� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
}
