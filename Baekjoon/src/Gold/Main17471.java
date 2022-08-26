package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17471 {

	// ������ ����
	public static int N;
	// ������ ���������� �α�
	public static int[] person;
	// ������ �������� ����� ������ �����Ѵ�.
	public static ArrayList<ArrayList<Integer>> list;
	// ������ �������� �湮�Ǿ����� Ȯ���ϴ� �迭
	public static boolean[] visited;
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� ���� �ʱ�ȭ �� �Ҵ�
		N = Integer.parseInt(br.readLine());
		person = new int[N];
		visited = new boolean[N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// ������ ���������� �ο� ����
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		// ������ �������� ����� ���� ����
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				list.get(i).add(to);
			}
		}
		subset(0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	// �� ���ű��� ������ �κ����� �޼���
	public static void subset(int idx) {
		if (idx == N) {
			// A ���ű��� ���ԵǴ� ������ index���� �����ϴ� �迭
			ArrayList<Integer> Aidx = new ArrayList<>();
			// B ���ű��� ���ԵǴ� ������ index���� �����ϴ� �迭
			ArrayList<Integer> Bidx = new ArrayList<>();
			// �κ����� �޼��忡 ��� �Ǿ����� A, �ƴϸ� B ���ű��� �� ������ �����Ѵ�.
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					Aidx.add(i);
				} else {
					Bidx.add(i);
				}
			}
			// �� ���ű��� ��� �ϳ��� ������ �����ؾ� �Ѵ�.
			if (Aidx.size() == 0 || Bidx.size() == 0)
				return;
			// �� ���ű��� �����鿡 ���� �� ���ű��� ����Ǿ��ִ��� Ȯ���ϴ� �޼���
			cal(Aidx, Bidx);
			return;
		}
		visited[idx] = true;
		subset(idx + 1);
		visited[idx] = false;
		subset(idx + 1);
	}

	// �� ���ű��� �����鿡 ���� �� ���ű��� ����Ǿ��ִ��� Ȯ���ϴ� �޼���
	public static void cal(ArrayList<Integer> Aidx, ArrayList<Integer> Bidx) {
		// A ���ű��� ��� ����Ǿ� �ִ��� Ȯ���Ѵ�.
		Queue<Integer> Aq = new ArrayDeque<>();
		// ��� ������ ���Ǿ����� �����ϴ� �迭
		boolean[] used = new boolean[N];
		// A ������ ���������� ���Ƿ� ���� �ڿ� queue�� �־��ش�.
		Aq.offer(Aidx.get(0));
		used[Aidx.get(0)] = true;
		// A ���ű����� ����� ������ ����
		int Acnt = 1;
		while (!Aq.isEmpty()) {
			// queue�� ����� ���� ����.
			int Acur = Aq.poll();
			for (int i = 0; i < list.get(Acur).size(); i++) {
				// ���� ������ ����� �������� A ���ű��� �����ϸ鼭 ���� �� ���� ������ ���ǥ���ϰ� queue�� ������ �� A ���ű����� ����� ������
				// ������ �÷��ش�.
				if (visited[list.get(Acur).get(i)] && !used[list.get(Acur).get(i)]) {
					used[list.get(Acur).get(i)] = true;
					Acnt++;
					Aq.offer(list.get(Acur).get(i));
				}
			}
		}

		// B ���ű��� ��� ����Ǿ� �ִ��� Ȯ���Ѵ�.
		Queue<Integer> Bq = new ArrayDeque<>();
		// ��� ������ ���Ǿ����� �����ϴ� �迭
		used = new boolean[N];
		// B ������ ���������� ���Ƿ� ���� �ڿ� queue�� �־��ش�.
		Bq.offer(Bidx.get(0));
		used[Bidx.get(0)] = true;
		// B ���ű����� ����� ������ ����
		int Bcnt = 1;
		while (!Bq.isEmpty()) {
			// queue�� ����� ���� ����.
			int Bcur = Bq.poll();
			for (int i = 0; i < list.get(Bcur).size(); i++) {
				// ���� ������ ����� �������� A ���ű��� �����ϸ鼭 ���� �� ���� ������ ���ǥ���ϰ� queue�� ������ �� A ���ű����� ����� ������
				// ������ �÷��ش�.
				if (!visited[list.get(Bcur).get(i)] && !used[list.get(Bcur).get(i)]) {
					used[list.get(Bcur).get(i)] = true;
					Bcnt++;
					Bq.offer(list.get(Bcur).get(i));
				}
			}
		}
		
		// �� ���ű����� ����� ������ ������ ���ű��� �����ϴ� ������ ������ ������ �� ���ű��� ���Ե� �α��� �ջ��� �ڿ� �� ���ű��� �α� ������ �ּҰ��� �����Ѵ�.
		if (Acnt == Aidx.size() && Bcnt == Bidx.size()) {
			int Asum = 0;
			int Bsum = 0;
			for (int i = 0; i < Aidx.size(); i++) {
				Asum += person[Aidx.get(i)];
			}
			for (int i = 0; i < Bidx.size(); i++) {
				Bsum += person[Bidx.get(i)];
			}
			answer = Math.min(answer, Math.abs(Asum - Bsum));
		}
	}

}
