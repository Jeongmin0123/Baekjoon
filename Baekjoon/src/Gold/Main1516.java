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
		// 각각의 건물마다 선행되어야 하는 건물의 개수를 저장하는 배열
		precede = new int[N];
		// 각각의 건물을 짓는데 걸리는 시간을 저장하는 배열
		time = new int[N];
		// 각각의 건물을 선행건물로 가지는 건물들의 번호를 저장하는 배열
		list = new ArrayList[N];
		// 각각의 건물들을 짓기 전까지 걸리는 시간들을 저장하는 배열
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
				// 자기 자신의 건물을 짓기 전에 가장 오래 걸린 시간을 찾아야 한다.
				dp[next] = Math.max(dp[next], dp[now] + time[now]);
				precede[next]--;
				if (precede[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}