package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019 {

	public static int N;
	// �湮 ó���� ���� �迭
	public static boolean[] visited;
	// start �������κ��� ������ ���ڸ� ����µ� �ʿ��� �ּ����� ��ɾ� ������ �����ϴ� �迭
	public static String[] answer;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// �ʱⰪ�� ������ ��� 0�̻� 10000�̸��̹Ƿ� ũ�Ⱑ 10000�� �迭�� �����.
			visited = new boolean[10000];
			answer = new String[10000];
			Arrays.fill(answer, "");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			bfs(start, end);
			sb.append(answer[end]).append("\n");
		}
		System.out.println(sb);
	}

	// �ʱⰪ���� ���� ������ ���µ� �ʿ��� �ּ����� ��ɾ� ������ ���ϴ� �޼���
	public static void bfs(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		// �ʱⰪ�� queue�� �ְ� �湮ó�� �Ѵ�.
		q.offer(start);
		visited[start] = true;
		// queue�� ��ų�, end�� ���� ��ɾ� ������ �ִ� ��� ������ �����Ѵ�.
		while (!q.isEmpty() && !visited[end]) {
			int cur = q.poll();
			// D, S, L, R ���꿡 ���� ���� ���ڸ� ������� �� �� ������ �湮���� ���� ���, �湮ó���ϰ� ���� ��ɾ� �迭��
			// ��� ó���� ������ ��ɾ �߰��� �� queue�� �� ������ �߰��Ѵ�.
			int D = (cur*2)%10000;
			if(!visited[D]) {
				answer[D] = answer[cur]+"D";
				q.offer(D);
				visited[D] = true;
			}
			int S = (cur == 0)? 9999: cur-1;
			if(!visited[S]) {
				answer[S] = answer[cur]+"S";
				q.offer(S);
				visited[S] = true;
			}
			int L = (cur%1000)*10 + cur/1000;
			if(!visited[L]) {
				answer[L] = answer[cur]+"L";
				q.offer(L);
				visited[L] = true;
			}
			int R = cur/10 + (cur%10)*1000;
			if(!visited[R]) {
				answer[R] = answer[cur]+"R";
				q.offer(R);
				visited[R] = true;
			}
		}
	}
}