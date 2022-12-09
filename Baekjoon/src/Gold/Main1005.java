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
			// time : �ǹ��� �Ǽ��� �ɸ��� �ð��� �����ϴ� �迭
			time = new int[N + 1];
			// income : �ǹ��� �������� ����Ǿ�� �ϴ� �ǹ��� ���� �����ϴ� �迭
			income = new int[N + 1];
			// dp : �� �ǹ��� ���µ� ���� �ǹ��� ����Ͽ� �ɸ��� �ð��� �����ϴ� �迭
			dp = new int[N + 1];
			// edge : �ǹ��� �������� ����Ǿ�� �ϴ� �ǹ��� ��ȣ�� �����ϴ� �迭
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
			// ��ǥ ����
			end = Integer.parseInt(br.readLine());
			calc();
			sb.append(dp[end]).append("\n");
		}
		System.out.println(sb);

	}

	public static void calc() {
		Queue<Integer> q = new ArrayDeque<>();
		// ��� �ǹ��� ���鼭 ���� �ǹ��� ���� ���, �� �ǹ��� ���µ� �ɸ��� �ð���
		// �ڱ� �ڽ��� ���µ� �ɸ��� �ð��� ����ϸ� �ǰ�, ���� �ǹ��� �����Ƿ� �Ǽ�
		// �����ϱ� ������ queue�� �־��ش�.
		for (int i = 1; i <= N; i++) {
			if (income[i] == 0) {
				dp[i] = time[i];
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			int size = edge[cur].size();
			// ���� �ǹ��� ���µ� �ɸ��� �ð��� ���� �ǹ� ���� �ð����� ����Ͽ� queue�� �־��ش�.
			for (int i = 0; i < size; i++) {
				int next = edge[cur].get(i);
				dp[next] = Math.max(dp[next], dp[cur] + time[next]);
				income[next]--;
				// ���� ����ǹ��� �� �������ٸ� queue�� �߰��Ѵ�.
				if (income[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}