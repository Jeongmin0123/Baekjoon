package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1516 {
	public static int N;
	public static int[] time, dp;
	public static int[] precede;
	public static ArrayList<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// ������ �ǹ����� ����Ǿ�� �ϴ� �ǹ��� ������ �����ϴ� �迭
		precede = new int[N];
		// ������ �ǹ��� ���µ� �ɸ��� �ð��� �����ϴ� �迭
		time = new int[N];
		// ������ �ǹ��� ����ǹ��� ������ �ǹ����� ��ȣ�� �����ϴ� �迭
		list = new ArrayList[N];
		// ������ �ǹ����� ���� ������ �ɸ��� �ð����� �����ϴ� �迭
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1)
					break;
				list[temp - 1].add(i);
				precede[i]++;
			}
		}
		calc();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(dp[i] + time[i]).append("\n");
		}
		System.out.println(sb);
	}
	public static void calc() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			if (precede[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			int size = list[now].size();
			for (int i = 0; i < size; i++) {
				int next = list[now].get(i);
				// �ڱ� �ڽ��� �ǹ��� ���� ���� ���� ���� �ɸ� �ð��� ã�ƾ� �Ѵ�.
				dp[next] = Math.max(dp[next], dp[now] + time[now]);
				precede[next]--;
				if (precede[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}