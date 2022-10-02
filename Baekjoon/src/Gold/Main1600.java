package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {

	// 걸린시간, 좌표, 말으로 움직인 횟수를 저장하는 class
	static class Node {
		int x;
		int y;
		int time;
		int horse;
		
		public Node(int x, int y, int time, int horse) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.horse = horse;
		}
		
	}
	
	public static int K,W,H;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int answer = Integer.MAX_VALUE;
	// 원숭이로서의 움직임
	public static int[][] monkey = {{1,0},{0,1},{-1,0},{0,-1}};
	// 말로써의 움직임
	public static int[][] horse = {{2,1},{1,2},{-2,-1},{-1,2},{-1,-2},{2,-1},{-2,1},{1,-2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());;
		map = new int[H][W];
		// K번까지 말처럼 움직일 수 있으므로 배열의 앞에 두칸은 좌표, 마지막 칸은 말로써 움직인 횟수를 표현한다.
		visited = new boolean[H][W][K+1];
		for(int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0,0,0,0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 목표 지점에 도착한 경우, 최소값을 재지정한다.
			if(cur.x == H-1 && cur.y == W-1) {
				answer = Math.min(answer, cur.time);
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				// 원숭이처럼 움직이는 경우
				int dx = cur.x + monkey[i][0];
				int dy = cur.y + monkey[i][1];
				if(!isValid(dx,dy)) continue;
				if(!visited[dx][dy][cur.horse] && map[dx][dy] == 0) {
					visited[dx][dy][cur.horse] = true;
					q.offer(new Node(dx,dy,cur.time+1,cur.horse));
				}
			}
			// 말로 이동할 수 있는 횟수가 남은 경우에만 말처럼 움직인다.
			if(cur.horse < K) {
				// 말처럼 움직이는 경우
				for(int i = 0 ; i < 8 ; i++) {
					int dx = cur.x + horse[i][0];
					int dy = cur.y + horse[i][1];
					if(!isValid(dx,dy)) continue;
					if(!visited[dx][dy][cur.horse+1] && map[dx][dy] == 0) {
						visited[dx][dy][cur.horse+1] = true;
						q.offer(new Node(dx,dy,cur.time+1,cur.horse+1));
					}
				}
			}
		}
	}
	
	// 배열안에 포함되는지 판단하는 메서드
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= H || y >= W) return false;
		return true;
	}

}

