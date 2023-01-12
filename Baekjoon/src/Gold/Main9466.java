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
			// �� �ϼ��� ���� �湮 ó�� ����
			team = new boolean[N+1];
			// �ܼ� �湮 ó�� ����
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
		// �̹� Ž���� �����̸� �Լ��� �����Ѵ�.
		if (visited[start]) return;
		// Ž�� �湮 ó��
		visited[start] = true;
		int end = list[start];
		// ���� ������ Ž���� ������ ���
		if(!visited[end]) {
			dfs(end);
		} else {
			// ����Ŭ
			if(!team[end]) {
				count++;
				for(int i = end ; i != start ; i = list[i]) {
					count++;
				}
			}
			// ���� ������ Ž������ ���� ������ ���, ���� ������ Ž���Ѵ�.
		}
		// ������ �Ϸ��ϸ� start ������ ����� �� ����� ������θ� �湮 ó�� ���ش�.
		team[start] = true;
	}
}
