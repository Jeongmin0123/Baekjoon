package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	// 치즈의 좌표를 저장하는 클래스
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static Queue<Node> q;
	public static int remain = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		// 배열에 값을 저장하고, 만약 받아온 값이 치즈라면 치즈의 양을 증가시킨다.
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) remain++;
			}
		}
		// 걸린 시간
		int count = 0;
		while(true) {
			int result = bfs();
			// 만약 남은 치즈가 없다면, 연산을 종료한다.
			if(remain - result == 0) {
				count++;
				break;
			}
			remain -= result;
			count++;
		}
		System.out.println(count);
		System.out.println(remain);
	}
	
	public static int bfs() {
		//(0,0)을 기준으로 너비 우선 탐색을 진행한다.
		q = new ArrayDeque<>();
		visited = new boolean[R][C];
		q.offer(new Node(0,0));
		int remove = 0;
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// 이동한 지점이 방문했거나, 배열 밖이라면 다음 연산을 진행한다.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				// 만약 빈칸이라면, 방문처리 후 그 Queue에 넣어준다.
				if(map[dr][dc] == 0) {
					visited[dr][dc] = true;
					q.offer(new Node(dr,dc));
				// 만약 바깥의 0과 접촉되어 있는 치즈라면 없애주고 방문처리를 한다.
				} else {
					remove++;
					map[dr][dc] = 0;
					visited[dr][dc] = true;
				}
			}
		}
		return remove;
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= R || y >= C) return false;
		return true;
	}
	
}
