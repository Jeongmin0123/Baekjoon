package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {

	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int max = 0;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// map의 모든 지점을 시작점으로 하여 5가지 모양을 만드는 dfs 탐색을 진행한다.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				visited[i][j] = true;
				dfs(i,j,map[i][j],1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	public static void dfs(int r, int c, int sum, int cnt) {
		// 만약 4개를 이어붙인 테트로미노를 만들면 max 값과 비교하여 더 큰값을 대입해준다.
		if(cnt == 4) {
			max = Math.max(sum, max);
			return;
		}
		// 그 지점을 기준으로 사방탐색을 진행한다.
		for(int i = 0 ; i < 4 ; i++) {
			int dr = r + move[i][0];
			int dc = c + move[i][1];
			// 배열을 벗어나거나 방문처리 된 지점을 만나면 다음 연산을 진행한다.
			if(!isValid(dr,dc) || visited[dr][dc]) continue;
			// 4개의 칸중 2번째칸까지 채운 경우 凸 모양은 2번째 지점에서 한번 더 가지를 뻗어야 하므로 이를 고려한다.
			if(cnt == 2) {
				visited[dr][dc] = true;
				dfs(r,c,sum+map[dr][dc], cnt+1);
				visited[dr][dc] = true;
			}
			// 방문 처리후 다음 dfs탐색을 진행한 뒤 다시 방문 처리를 취소한다.
			visited[dr][dc] = true;
			dfs(dr,dc,sum+map[dr][dc], cnt+1);
			visited[dr][dc] = false;
		}
	}
	// 배열 내부에 존재하는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}
