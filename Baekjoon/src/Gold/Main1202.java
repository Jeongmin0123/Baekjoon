package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {

	// ���Կ� ��ġ�� �����ϴ� jewel Ŭ����
	static class jewel implements Comparable<jewel> {
		int weight;
		int value;
		
		public jewel(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
		// ���� ������ �������� �����ϵ�, ���� ��� ��ġ�� �������� �������� �����Ѵ�. 
		@Override
		public int compareTo(jewel o) {
			if(this.weight == o.weight) {
				return o.value - this.value;
			} else {
				return this.weight - o.weight;
			}
		}
	}

	public static int N,K;
	public static int[] bags;
	public static jewel[] jewels;
	public static long answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bags = new int[K];
		jewels = new jewel[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewels[i] = new jewel(weight, value);
		}
		for(int i = 0 ; i < K ; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		// ����� ��ű� �迭�� ���� �����Ѵ�.
		Arrays.sort(bags);
		Arrays.sort(jewels);
		calc();
		System.out.println(answer);
	}
	
	public static void calc() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int count = 0;
		for(int i = 0 ; i < K ; i++) {
			// ��� ������ �� �����ϰų�, ���� ����Ʈ�� ���԰� ���� ���溸�� ũ�� ������ while���� �ݺ��Ѵ�.
			while(count < N && jewels[count].weight <= bags[i]) {
				pq.offer(jewels[count].value);
				count++;
			}
			// while���� �������� ��, ���� ���濡 ���� �� �ִ� ���� ū ������ �ִ´�.
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
	}

}
