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
	// 방문 처리를 위한 배열
	public static boolean[] visited;
	// start 지점으로부터 각각의 숫자를 만드는데 필요한 최소한의 명령어 나열을 저장하는 배열
	public static String[] answer;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 초기값과 최종값 들다 0이상 10000미만이므로 크기가 10000인 배열을 만든다.
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

	// 초기값에서 최종 값까지 가는데 필요한 최소한의 명령어 나열을 구하는 메서드
	public static void bfs(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		// 초기값을 queue에 넣고 방문처리 한다.
		q.offer(start);
		visited[start] = true;
		// queue가 비거나, end를 만든 명령어 나열이 있는 경우 연산을 종료한다.
		while (!q.isEmpty() && !visited[end]) {
			int cur = q.poll();
			// D, S, L, R 연산에 따라 현재 숫자를 계산해준 뒤 그 지점을 방문하지 않은 경우, 방문처리하고 현재 명령어 배열에
			// 방금 처리한 연산의 명령어를 추가한 뒤 queue에 그 지점을 추가한다.
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