package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573 {

	// 얼음의 위치를 갖는 클래스
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
		// 빙산의 덩어리 개수
		int count = 0;
		// 만약 덩어리의 개수가 2개보다 작은 경우에만 연산을 진행한다.
		while((count = count()) < 2) {
			// 덩어리가 0개라면 연산을 할 필요가 없으므로 0을 출력하고 종료한다.
			if(count == 0) {
				System.out.println(0);
				System.exit(0);
			}
			// 한 싸이클이 돌 때마다 시간을 1씩 증가시킨다.
			bfs();
			result++;
		}
		System.out.println(result);
	}

	// 빙산의 덩어리 개수를 반환하는 메서드
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
	
	// 빙산이 존재하는 지점을 발견하면 그 위치에서 깊이 우선 탐색을 하여 연결된 모든 빙산을 하나로 인식한다.
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
	
	// 한 싸이클의 빙산을 녹이는 메서드
	public static void bfs() {
		boolean[][] visited = new boolean[N][M];
		// 빙산을 모두 queue에 넣어준다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] != 0) {
					list.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		// queue가 비는 지점이 한 싸이클이므로 큐가 빌 때까지 연산을 계속한다.
		while(!list.isEmpty()) {
			Node cur = list.poll();
			// 녹을 빙산의 양
			int lose = 0;
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(isValid(dx,dy) && map[dx][dy] == 0 && !visited[dx][dy]) {
					lose++;
				}
			}
			// 녹는 양이 현재 빙산의 양보다 크면 빙산을 모두 녹인다.
			if(map[cur.x][cur.y] - lose < 0) {
				map[cur.x][cur.y] = 0;
			} else {
				map[cur.x][cur.y] -= lose;
			}
		}
	}
	
	// 배열의 범위 내에 존재하는지 판단하는 메서드
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
}
