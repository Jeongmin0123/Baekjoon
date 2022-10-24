package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14442 {

	// 좌표와 그 좌표까지 가는데 걸린 시간과 부순 벽의 개수를 저장하는 메서드
	static class Node {
		int r;
		int c;
		int time;
		int wall;
		
		public Node(int r, int c, int time, int wall) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.wall = wall;
		}
	}
	
	public static int R,C,K,answer;
	public static char[][] map;
	// 방문처리를 위한 배열을 생성한다.
	// 이때, 방문처리를 부순 벽의 개수마다 다르게 방문처리를 해줘야 하므로 3차원 배열로 생성한다.
	public static boolean[][][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][K+1];
		// 갈 수 없는 경우 -1을 출력해야 하므로 answer 값을 초기화한다.
		answer = -1;
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// bfs탐색을 진행한다.
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.offer(new Node(0,0,1,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 꺼낸 지점의 위치가 목적지면 그때까지 걸린 시간을 반환한다.
			if(cur.r == R-1 && cur.c == C-1) {
				answer = cur.time;
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// 움직인 지점이 배열을 벗어나는 경우 연산을 하지 않는다.
				if(!isValid(dr,dc)) continue;
				// 방문한 지점이 벽인경우
				if(map[dr][dc] == '1') {
					// 방문한 지점이거나, 더 이상 벽을 부술 수 없는 경우 연산을 하지 않는다.
					if(cur.wall >= K || visited[dr][dc][cur.wall+1]) continue;
					// 방문 처리 후, queue에 추가한다.
					visited[dr][dc][cur.wall+1] = true;
					q.offer(new Node(dr,dc,cur.time+1,cur.wall+1));
				// 방문한 지점이 벽이 아닌경우
				} else {
					// 방문했을 경우 연산을 하지 않는다.
					if(visited[dr][dc][cur.wall]) continue;
					// 방문 처리 후, queue에 추가한다.
					visited[dr][dc][cur.wall] = true;
					q.offer(new Node(dr,dc,cur.time+1,cur.wall));
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}

}
