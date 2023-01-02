package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {

	// 무게와 가치를 저장하는 jewel 클래스
	static class jewel implements Comparable<jewel> {
		int weight;
		int value;
		
		public jewel(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
		// 무게 순으로 오름차순 정렬하되, 같은 경우 가치를 기준으로 내림차순 정렬한다. 
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
		// 가방과 장신구 배열을 각각 정렬한다.
		Arrays.sort(bags);
		Arrays.sort(jewels);
		calc();
		System.out.println(answer);
	}
	
	public static void calc() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int count = 0;
		for(int i = 0 ; i < K ; i++) {
			// 모든 보석을 다 연산하거나, 보석 리스트의 무게가 현재 가방보다 크기 전까지 while문을 반복한다.
			while(count < N && jewels[count].weight <= bags[i]) {
				pq.offer(jewels[count].value);
				count++;
			}
			// while문을 빠져나온 후, 현재 가방에 넣을 수 있는 가장 큰 보석을 넣는다.
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
	}

}
