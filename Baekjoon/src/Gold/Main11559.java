package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11559 {

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
	
	public static int N,M;
	public static int[][] map;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean[][] used;
	public static int answer = 0;
	public static Queue<Node> cheese;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		used = new boolean[N][M];
		cheese = new ArrayDeque<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 1) {
					int count = 0;
					for(int k = 0 ; k < 4 ; k++) {
						if(map[i+move[k][0]][j+move[k][1]] == 0) {
							count++;
						}
					}
					if(count >= 2) {
						cheese.offer(new Node(i,j,1));
						used[i][j] = true;
						map[i][j] = 0;
					}
				}
			}
		}
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		while(!cheese.isEmpty()) {
			Node cur = cheese.poll();
			if(cur.time > answer) answer = cur.time;
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(!isValid(dx,dy)) continue;
				if(used[dx][dy]) continue;
				if(map[dx][dy] == 1) {
					int count = 0;
					for(int j = 0 ; j < 4 ; j++) {
						if(map[dx+move[j][0]][dy+move[j][1]] == 0) {
							count++;
						}
					}
					if(count >= 2) {
						cheese.offer(new Node(dx,dy,cur.time+1));
						used[dx][dy] = true;
						map[dx][dy] = 0;
					}
				}
			}
		}
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}

}
