package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2252 {

	public static int N, M;
	public static int[] input;
	public static Queue<Integer> q;
	public static ArrayList<Integer> result;
	public static ArrayList<ArrayList<Integer>> edgelist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 각각의 학생 앞에 존재해야 하는 학생수를 저장하는 배열
		input = new int[N + 1];
		q = new ArrayDeque<>();
		// 각 사람마다 뒤에 오는 사람들을 저장하는 ArrayList
		edgelist = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			edgelist.add(new ArrayList<Integer>());
		}
		// 줄을 세운 결과를 저장하는 ArrayList
		result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a학생 뒤에 b학생이 존재해야 하므로 a학생 뒤에 오는 학생들의 ArrayList에 b를 추가한다.
			edgelist.get(a).add(b);
			// b학생 앞에 존재해야 하는 학생수를 1 증가시킨다.
			input[b]++;
		}
		for (int i = 1; i <= N; i++) {
			// 자기보다 앞선 사람이 없는 경우 queue에 넣어준다.
			if (input[i] == 0) {
				q.offer(i);
			}
		}
		sort();
		int size = result.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	// 줄을 세우는 메서드
	public static void sort() {
		while (!q.isEmpty()) {
			// queue에 들어간 경우 더이상 선행되어야 할 학생이 없으므로 꺼내면서 result에 넣어준다.
			int cur = q.poll();
			result.add(cur);
			int size = edgelist.get(cur).size();
			// 현재 학생 뒤에 와야되는 학생들의 선행 학생수를 1 감소시키고, 만약 선행 학생수가 0이 되면 queue에 추가해준다.
			for (int i = 0; i < size; i++) {
				int to = edgelist.get(cur).remove(0);
				input[to]--;
				if (input[to] == 0) {
					q.offer(to);
				}
			}
		}
	}
}