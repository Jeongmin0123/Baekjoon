package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1726 {

	static class Node {
		int r;
		int c;
		int time;
		int dir;
		
		public Node(int r, int c, int time, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.dir = dir;
		}
	}
	
	public static int R,C;
	public static int[][] map;
	public static boolean[][][] visited;
	public static Queue<Node> q;
	public static Node end;
	public static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		// 총 4방향의 방향을 가지므로 방향에 따라 방문처리를 다르게 하기 위해 3차원 배열을 사용한다.
		visited = new boolean[R][C][4];
		q = new ArrayDeque<>();
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int dir = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new Node(r,c,0,dir));
		visited[r][c][dir] = true;
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken()) - 1;
		end = new Node(r,c,0,dir);
		bfs();
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 도착지에 도달하고 방향도 같은 경우 값을 출력한다.
			if(cur.c == end.c && cur.r == end.r && cur.dir == end.dir) {
				System.out.println(cur.time);
				return;
			}
			
			// 명령 1 : 1,2,3칸 만큼 이동이므로 for문을 활용한다.
			for(int i = 1 ; i <= 3 ; i++) {
				int dr = cur.r + move[cur.dir][0]*i;
				int dc = cur.c + move[cur.dir][1]*i;
				// 배열의 범위를 벗어난 경우
				if(!isValid(dr,dc)) continue;
				// 움직여서 도착한 지점이 벽이 아닌경우
				if(map[dr][dc] == 0) {
					// 방문하지 않은 지점인 경우 방문처리 후 queue에 추가한다.
					if(!visited[dr][dc][cur.dir]) {
						visited[dr][dc][cur.dir] = true;
						q.offer(new Node(dr,dc,cur.time+1,cur.dir));
					}
				// 움직여서 도착한 지점이 벽인 경우
				} else {
					// 그 뒤의 연산부터는 벽을 뚫고 지나가는 것이므로 연산할 필요가 없다.
					break;
				}
			}
			// 명령 2
			for(int i = 0 ; i < 4 ; i++) {
				// 회전이 필요하고 방문한 적 없는 경우 회전시킨다.
				if(cur.dir != i && !visited[cur.r][cur.c][i]) {
					int add = 1;
					if(cur.dir == 0) {
						if(i == 1) add++;
					} else if(cur.dir == 1) {
						if(i == 0) add++;
					} else if(cur.dir == 2) {
						if(i == 3) add++;
					} else {
						if(i == 2) add++;
					}
					visited[cur.r][cur.c][i] = true;
					q.offer(new Node(cur.r,cur.c,cur.time+add,i));
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
	
}
