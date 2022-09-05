package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {

	public static int N,M;
	public static int answer = Integer.MIN_VALUE;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	// 이동한 땅의 x좌표,y좌표와 시작점에서 그 점까지 오는데 걸린 시간을 저장하는 클래스
	static class Node {
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 시작점에 따라 가장 먼 땅까지 가는 시간이 다르므로 모든 땅에 대해서 연산한다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 'L') {
					visited = new boolean[N][M];
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	// 시작점을 받아와 그 점에서 가장 먼 곳까지 가는데 걸리는 시간을 계산하는 bfs 메서드
	public static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		// 시작점은 걸리는 시간이 0이다.
		q.offer(new Node(x,y,0));
		// 방문체크
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				// 이동 가능한 지점인지 체크
				if(isValid(dx,dy) && !visited[dx][dy] && map[dx][dy] == 'L') {
					// 이동 가능할 시 그 전지점까지 걸린 시간에 더하기 1을 해준다.
					q.offer(new Node(dx,dy,cur.time+1));
					// 방문체크
					visited[dx][dy] = true;
					// 두 곳간의 최단 거리를 이동하는 시간을 연산
					answer = Math.max(cur.time+1, answer);
				}
			}
		}
	}
	
	// 배열의 범위 내에 존재하는지 판단하는 메서드
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}

}
