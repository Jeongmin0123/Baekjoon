package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2623 {
	public static int N, M;
	// �� �������� ����Ǿ�� �ϴ� ������ ���� �����ϴ� �迭
	public static int[] income;
	// �� �������� �ڱ� �ڿ� ���� �������� ����Ʈ�� �����ϴ� �迭
	public static ArrayList<Integer> edge[];
	// �������� ������ �����ϴ� ArrayList
	public static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new ArrayList[N + 1];
		result = new ArrayList<>();
		income = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[Integer.parseInt(st.nextToken())];
			// �� ���� PD�� ��� ���� ������ �����Ѵ�.
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			// ������ ���� ������ income�� edge�� ��Ģ�� �°� �����Ѵ�.
			for (int j = 0; j < arr.length - 1; j++) {
				edge[arr[j]].add(arr[j + 1]);
				income[arr[j + 1]]++;
			}
		}
		calc();
		StringBuilder sb = new StringBuilder();
		// ��� �������� ������ ������ ��� ������ ����ϰ� �ƴ� ��� 0�� ����Ѵ�.
		if (result.size() == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result.get(i)).append("\n");
			}
		} else {
			sb.append(0);
		}
		System.out.println(sb);
	}

	public static void calc() {
		Queue<Integer> q = new ArrayDeque<>();
		// ���� ������ �������� �ʴ� �������� ��ȣ�� queue�� �ִ´�.
		for (int i = 1; i <= N; i++) {
			if (income[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			// ������ ������ ������ result ����Ʈ�� �ִ´�.
			int cur = q.poll();
			result.add(cur);
			int size = edge[cur].size();
			// ������ ������ ������ ���� �������� ���� ���� ���� 1�� �ٿ��ָ鼭
			// ���� ������ �ʿ��� ���� ���� ���� 0�� �Ǵ� ��� queue�� �߰����ش�.
			for (int i = 0; i < size; i++) {
				int next = edge[cur].get(i);
				income[next]--;
				if (income[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}