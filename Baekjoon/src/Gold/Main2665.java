package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main2665 {
	
	// 좌표를 저장하는 클래스
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int N;
	public static char[][] map;
	// 각각의 지점까지 도달하는데 부순 벽의 개수를 저장하는 배열
	public static int[][] dp;
	public static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		dp = new int[N][N];
		// 부순 벽의 개수를 Max값으로 초기화해준다.
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		bfs();
		// 도착점까지 가는데 부순 벽의 개수를 출력한다.
		System.out.println(dp[N-1][N-1]);
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		// 시작점을 queue에 넣어주고 dp값을 초기화한다.
		q.offer(new Node(0,0));
		dp[0][0] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 사방을 bfs탐색하면서, 배열의 범위를 벗어나지 않고, 저장된 그 지점까지 가는데 부순 벽의 개수보다 최근 연산의 부순 벽의 개수가 작은 경우
			// dp값을 갱신해주고, 그 지점을 queue에 넣어준다.
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + dir[i][0];
				int dc = cur.c + dir[i][1];
				if(!isValid(dr,dc)) continue;
				if(dp[cur.r][cur.c] < dp[dr][dc]) {
					// 흰방인 경우 이동시 벽을 안부숴도 되므로 이동하기 전 값을 넣어준다.
					if(map[dr][dc] == '1') {
						dp[dr][dc] = dp[cur.r][cur.c];
					} else {
					// 검은방의 경우 이동시 벽을 부숴줘야하므로 이동전 값의 1을 추가한다.
						dp[dr][dc] = dp[cur.r][cur.c]+1;
					}
					q.offer(new Node(dr,dc));
				}
			}
		}
	}
	
	// 배열을 벗어났는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}

}
