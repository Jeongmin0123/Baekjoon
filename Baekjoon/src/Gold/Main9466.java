package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9466 {
	public static int T, N, count;
	public static int[] list;
	public static boolean[] team;
	public static boolean[] visited;
	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			// 팀 완성을 위한 방문 처리 여부
			team = new boolean[N+1];
			// 단순 방문 처리 여부
			visited = new boolean[N+1];
			list = new int[N+1];
			result = N;
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				dfs(i);
			}
			sb.append(result - count).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int start) {
		// 이미 탐색한 지점이면 함수를 종료한다.
		if (visited[start]) return;
		// 탐색 방문 처리
		visited[start] = true;
		int end = list[start];
		// 다음 지점이 탐색한 지점인 경우
		if(!visited[end]) {
			dfs(end);
		} else {
			// 싸이클
			if(!team[end]) {
				count++;
				for(int i = end ; i != start ; i = list[i]) {
					count++;
				}
			}
			// 다음 지점이 탐색하지 않은 지점인 경우, 다음 지점을 탐색한다.
		}
		// 연산을 완료하면 start 지점의 사람은 팀 만들기 고려여부를 방문 처리 해준다.
		team[start] = true;
	}
}
