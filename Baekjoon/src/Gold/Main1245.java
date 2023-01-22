package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1245 {

	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int answer = 0;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static boolean top;
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
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(!visited[i][j]) {
					top = true;
					dfs(i,j);
					if(top) answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0 ; i < 8 ; i++) {
			int dr = r + move[i][0];
			int dc = c + move[i][1];
			if(!isValid(dr,dc)) continue;
			if(map[dr][dc] > map[r][c]) top = false;
			if(!visited[dr][dc] && map[dr][dc] == map[r][c]) dfs(dr,dc);
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}
