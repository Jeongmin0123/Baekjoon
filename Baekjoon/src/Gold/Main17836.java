package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17836 {

	public static int[][] map;
	public static boolean sword;
	// 검을 들고 있을때와 안들고 있을 때, 차이를 두기 위해 방문처리를 3차원 배열로 한다.
	public static boolean[][][] visited;
	public static int N,M,T;
	public static int result = Integer.MAX_VALUE;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static class Node {
		int x;
		int y;
		int time;
		boolean sword;
		
		public Node(int x, int y, int time, boolean sword) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.sword = sword;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[2][N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		// 시간내에 들어오면 시간 반환, 아니면 Fail
		if(result <= T) {
			System.out.println(result);
		} else {
			System.out.println("Fail");
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0,0,0,false));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 목표지점에 도착하면 최소 시간을 재정립한다.
			if(cur.x == N-1 && cur.y == M-1) {
				result = Math.min(result, cur.time);
			}
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				// 검을 들고 있을 경우
				if(cur.sword) {
					if(isValid(dx,dy) && !visited[1][dx][dy]) {
						q.offer(new Node(dx,dy,cur.time+1, true));
						visited[1][dx][dy] = true;
					}
				}
				// 검이 없는 경우
				else {
					// 그냥 움직일 수 있는 경우
					if(isValid(dx,dy) && !visited[0][dx][dy] && map[dx][dy] == 0) {
						visited[0][dx][dy] = true;
						q.offer(new Node(dx,dy,cur.time+1,false));
					// 검을 습득하게 되는 경우
					} else if(isValid(dx,dy) && !visited[0][dx][dy] && map[dx][dy] == 2) {
						visited[0][dx][dy] = true;
						q.offer(new Node(dx,dy,cur.time+1,true));
					}
				}
			}
		}
	}
	
	// 배열 범위 내에 존재하는지 확인하는 메서드
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}

}
