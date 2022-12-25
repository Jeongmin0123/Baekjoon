package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {

	public static int N, M;
	// �� ��ȣ���� ����Ǿ�� �ϴ� ��ȣ���� ����Ʈ
	public static ArrayList<ArrayList<Integer>> precedeInput;
	// �� ��ȣ���� ����Ǿ�� �ϴ� ��ȣ���� ����
	public static int[] precedeCount;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		precedeCount = new int[N+1];
		precedeInput = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
			precedeInput.add(new ArrayList<Integer>());
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			// A�������� ���� Ǫ�°� ���� B������ �����ϴ� ���
			// A������ ���� ��ȣ ������ ������Ű��, A������ ���� ��ȣ ����Ʈ�� B�� �߰��Ѵ�.
			precedeCount[after]++;
			precedeInput.get(before).add(after);
		}
		calc();
		System.out.println(sb);
	}

	public static void calc() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// ���� ������ ������ pq�� �߰��Ѵ�.
		for(int i = 1 ; i <= N ; i++) {
			if(precedeCount[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			int size = precedeInput.get(cur).size();
			// �����ȣ�� ������ 1�� ���ҽ�Ű��, �����ȣ ������ 0�̸� pq�� �߰��Ѵ�.
			for(int i = 0 ; i < size ; i++) {
				precedeCount[precedeInput.get(cur).get(i)]--;
				if(precedeCount[precedeInput.get(cur).get(i)] == 0) {
					pq.offer(precedeInput.get(cur).get(i));
				}
			}
		}
	}
}
