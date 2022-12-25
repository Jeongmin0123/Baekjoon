package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {

	public static int N, M;
	// 각 번호마다 선행되어야 하는 번호들의 리스트
	public static ArrayList<ArrayList<Integer>> precedeInput;
	// 각 번호마다 선행되어야 하는 번호들의 개수
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
			// A문제보다 먼저 푸는게 좋은 B문제가 존재하는 경우
			// A문제의 선행 번호 개수를 증가시키고, A문제의 선행 번호 리스트에 B를 추가한다.
			precedeCount[after]++;
			precedeInput.get(before).add(after);
		}
		calc();
		System.out.println(sb);
	}

	public static void calc() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 선행 문제가 없으면 pq에 추가한다.
		for(int i = 1 ; i <= N ; i++) {
			if(precedeCount[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			int size = precedeInput.get(cur).size();
			// 선행번호의 개수를 1개 감소시키고, 선행번호 개수가 0이면 pq에 추가한다.
			for(int i = 0 ; i < size ; i++) {
				precedeCount[precedeInput.get(cur).get(i)]--;
				if(precedeCount[precedeInput.get(cur).get(i)] == 0) {
					pq.offer(precedeInput.get(cur).get(i));
				}
			}
		}
	}
}
