package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {

	public static int N,L,R;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int time = 0;
	public static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 인구 이동이 가능한 만큼 이동한다.
		while(true) {
			visited = new boolean[N][N];
			flag = false;
			int temp = time;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j]) {
						// 방문하지 않은 지점을 기준으로 너비 우선 탐색을 진행한다.
						bfs(i,j);
					}
				}
			}
			// 인구 이동이 일어난 경우, 다시 인구이동을 진행하고, 아닌 경우 인구이동을 한 횟수를 출력한다.
			if(flag == true) time++;
			if(time == temp) {
				System.out.println(time);
				break;
			}
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		ArrayList<int[]> change = new ArrayList<>();
		change.add(new int[] {r,c});
		int count = 0;
		int sum = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			count++;
			sum += map[cur[0]][cur[1]];
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur[0] + move[i][0];
				int dc = cur[1] + move[i][1];
				// 방문한 적이 없고, 배열 내에 존재하며, 두 지점 사이의 차이가 L명 이상, R명 이하인 경우, 국경을 연다.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				if(Math.abs(map[cur[0]][cur[1]] - map[dr][dc]) >= L && Math.abs(map[cur[0]][cur[1]] - map[dr][dc]) <= R) {
					visited[dr][dc] = true;
					q.offer(new int[] {dr,dc});
					change.add(new int[] {dr,dc});
				}
			}
		}
		// 국경이 열린 지점들의 합을 그 개수로 나눈다.
		int avg = sum/count;
		for(int[] i : change) {
			// 국경이 열린 지점들의 값을 그들의 평균 값으로 바꿔준다.
			map[i[0]][i[1]] = avg;
		}
		if(count > 1) {
			flag = true;
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}

}
