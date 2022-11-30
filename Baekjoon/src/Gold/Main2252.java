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
		// ������ �л� �տ� �����ؾ� �ϴ� �л����� �����ϴ� �迭
		input = new int[N + 1];
		q = new ArrayDeque<>();
		// �� ������� �ڿ� ���� ������� �����ϴ� ArrayList
		edgelist = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			edgelist.add(new ArrayList<Integer>());
		}
		// ���� ���� ����� �����ϴ� ArrayList
		result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a�л� �ڿ� b�л��� �����ؾ� �ϹǷ� a�л� �ڿ� ���� �л����� ArrayList�� b�� �߰��Ѵ�.
			edgelist.get(a).add(b);
			// b�л� �տ� �����ؾ� �ϴ� �л����� 1 ������Ų��.
			input[b]++;
		}
		for (int i = 1; i <= N; i++) {
			// �ڱ⺸�� �ռ� ����� ���� ��� queue�� �־��ش�.
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

	// ���� ����� �޼���
	public static void sort() {
		while (!q.isEmpty()) {
			// queue�� �� ��� ���̻� ����Ǿ�� �� �л��� �����Ƿ� �����鼭 result�� �־��ش�.
			int cur = q.poll();
			result.add(cur);
			int size = edgelist.get(cur).size();
			// ���� �л� �ڿ� �;ߵǴ� �л����� ���� �л����� 1 ���ҽ�Ű��, ���� ���� �л����� 0�� �Ǹ� queue�� �߰����ش�.
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