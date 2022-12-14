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
		// 지훈이의 위치를 찾아 queue에 넣고 방문처리를 해준다.
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
		// 불의 위치를 받아와 queue에 넣어준다
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 'F') fire.add(new Node(i,j,0));
			}
		}
		// 지훈이가 움직일 수 없을때까지 반복한다.
		while(true) {
			// 1초마다 불과 지훈이가 1만큼 움직여야 하므로 한 번의 사이클에 각각의 queue의 크기만큼 반복한다.
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
					// 벽이 아니고 방문하지 않은 곳이면 queue에 추가하고, map[i][j] 값을 바꾼 뒤, 방문처리를 해준다.
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
					// 만약 배열의 범위를 벗어난 경우 탈출한 것이므로 탈출 시간을 출력하고 종료한다.
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
			// 더 이상 지훈이가 움직일 수 없는 경우 while문을 종료한다.
			if(size1 == 0) break;
		}
		// 불가능한 경우
		System.out.println("IMPOSSIBLE");
		return;
	}
	// 배열의 범위를 벗어났는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}
