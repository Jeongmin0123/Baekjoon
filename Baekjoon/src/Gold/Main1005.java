package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1005 {
	public static int N, K, end;
	public static int[] time, income, dp;
	public static ArrayList<Integer> edge[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			// time : 건물당 건설에 걸리는 시간을 저장하는 배열
			time = new int[N + 1];
			// income : 건물을 짓기위해 선행되어야 하는 건물의 수를 저장하는 배열
			income = new int[N + 1];
			// dp : 그 건물을 짓는데 선행 건물을 고려하여 걸리는 시간을 저장하는 배열
			dp = new int[N + 1];
			// edge : 건물을 짓기위해 선행되어야 하는 건물의 번호를 저장하는 배열
			edge = new ArrayList[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				edge[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edge[from].add(to);
				income[to]++;
			}
			// 목표 지점
			end = Integer.parseInt(br.readLine());
			calc();
			sb.append(dp[end]).append("\n");
		}
		System.out.println(sb);

	}

	public static void calc() {
		Queue<Integer> q = new ArrayDeque<>();
		// 모든 건물을 돌면서 선행 건물이 없는 경우, 그 건물을 짓는데 걸리는 시간은
		// 자기 자신을 짓는데 걸리는 시간만 고려하면 되고, 선행 건물이 없으므로 건설
		// 가능하기 때문에 queue에 넣어준다.
		for (int i = 1; i <= N; i++) {
			if (income[i] == 0) {
				dp[i] = time[i];
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			int size = edge[cur].size();
			// 현재 건물을 짓는데 걸리는 시간을 선행 건물 짓는 시간까지 고려하여 queue에 넣어준다.
			for (int i = 0; i < size; i++) {
				int next = edge[cur].get(i);
				dp[next] = Math.max(dp[next], dp[cur] + time[next]);
				income[next]--;
				// 만약 선행건물이 다 지어졌다면 queue에 추가한다.
				if (income[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}