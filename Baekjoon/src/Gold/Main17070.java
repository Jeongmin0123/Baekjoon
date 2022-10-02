package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070 {

	public static int N, answer;
	public static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0);
		System.out.println(answer);
	}
	
	// 깊이우선 탐색
	public static void dfs(int x, int y, int dir) {
		// 배열의 범위를 벗어나거나, 장애물을 만난 경우
		if(!isValid(x,y) || map[x][y] == 1) return;
		// 대각선으로 이동시켰는데 4칸 중 장애물이 있는 경우
		if(dir == 1 && (map[x-1][y] == 1 || map[x][y-1] == 1)) return;
		// 목표지점에 도달한 경우
		if(x == N-1 && y == N-1) {
			answer++;
			return;
		}
		// 파이프가 가로로 되어있던 경우, 가로나 대각선으로 이동가능하다.
		if(dir == 0) {
			dfs(x+1,y+1,dir+1);
			dfs(x,y+1,dir);
		// 파이프가 대각선으로 되어있던 경우, 모든 방향으로 이동 가능하다.
		} else if(dir == 1) {
			dfs(x,y+1,dir-1);
			dfs(x+1,y+1,dir);
			dfs(x+1,y,dir+1);
		// 파이프가 세로로 되어있던 경우, 대각선과 세로방향으로 이동 가능하다
		}else {
			dfs(x+1,y,dir);
			dfs(x+1,y+1,dir-1);
		}
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}

}
