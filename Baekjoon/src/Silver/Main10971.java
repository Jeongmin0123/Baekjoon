package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {

	public static int N;
	public static int[][] map;
	public static boolean[] visited;
	public static int answer = Integer.MAX_VALUE;
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
		
		// 시작점을 모르는 관계로 시작점으로 모든 정을 고려한다.
		for(int i = 0 ; i < N ; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,i,0);
		}
		System.out.println(answer);
	}
	// 최소비용을 구하는 dfs함수
	public static void dfs(int start, int now, int cost) {
		// 모든 지점을 방문했고 그 지점에서 다시 시작지점으로 돌아갈 수 있으면
		// 돌아간 뒤에 그때 드는 비용과 현재 최소비용 중 비교하여 더 작은 값을 최소비용에 저장한다.
		if(AllVisited()) {
			if(map[now][start] != 0) {
				answer = Math.min(answer, cost + map[now][start]);
			}
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cost + map[now][i]);
				visited[i] = false;
			}
		}
	}

	public static boolean AllVisited() {
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	
}

