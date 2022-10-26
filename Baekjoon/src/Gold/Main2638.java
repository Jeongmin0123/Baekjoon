package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {

	// 좌표값을 저장하는 class
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int R,C,time;
	public static int[][] map;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 다 녹는데 걸리는 시간
		time = 0;
		while(true) {
			// 녹을게 남은 경우, 녹이고 시간을 증가시킨다.
			if(findRemove()) {
				time++;
			// 녹일게 없는 경우, while문을 빠져나간다.
			} else {
				break;
			}
		}
		System.out.println(time);
	}
	
	// 녹일 치즈를 찾는 메서드
	public static boolean findRemove() {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		// 공기와 접촉한 면의 개수를 저장하는 배열
		int[][] check = new int[R][C];
		q.offer(new Node(0,0));
		visited[0][0] = true;
		// 녹일 치즈가 남아있는지 확인하기 위한 boolean 타입 변수
		boolean canRemove = false;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// 방문했거나, 배열에 포함되지 않으면 다음 연산을 진행한다.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				// 이동한 지점이 공기라면 그 지점을 기준으로 다시 4방탐색을 진행한다.
				if(map[dr][dc] == 0) {
					visited[dr][dc] = true;
					q.offer(new Node(dr,dc));
				// 이동한 지점이 치즈라면, 녹일 수 있는 치즈가 남은 상태이므로 canRemove를 true 바꿔주고
				// 그 지점이 공기와 접촉한 개수를 1 증가시킨다.
				} else if(map[dr][dc] == 1) {
					canRemove = true;
					check[dr][dc]++;
				}
			}
		}
		// 2면 이상 공기와 접촉하는 지점은 치즈를 녹인다.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(check[i][j] >= 2) {
					map[i][j] = 0;
				}
			}
		}
		return canRemove;
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}

}

