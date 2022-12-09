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
	// 각 가수마다 선행되어야 하는 가수의 수를 저장하는 배열
	public static int[] income;
	// 각 가수마다 자기 뒤에 오는 가수들의 리스트를 저장하는 배열
	public static ArrayList<Integer> edge[];
	// 가수들의 순서를 저장하는 ArrayList
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
			// 각 보조 PD의 담당 가수 순서를 저장한다.
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			// 저장한 가수 순서를 income과 edge에 규칙에 맞게 저장한다.
			for (int j = 0; j < arr.length - 1; j++) {
				edge[arr[j]].add(arr[j + 1]);
				income[arr[j + 1]]++;
			}
		}
		calc();
		StringBuilder sb = new StringBuilder();
		// 모든 가수들의 순서가 정해진 경우 순서를 출력하고 아닌 경우 0을 출력한다.
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
		// 선행 가수가 존재하지 않는 가수들의 번호를 queue에 넣는다.
		for (int i = 1; i <= N; i++) {
			if (income[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			// 순서가 정해진 가수는 result 리스트에 넣는다.
			int cur = q.poll();
			result.add(cur);
			int size = edge[cur].size();
			// 순서가 정해진 가수의 후행 가수들의 선행 가수 수를 1씩 줄여주면서
			// 후행 가수의 필요한 선행 가수 수가 0이 되는 경우 queue에 추가해준다.
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