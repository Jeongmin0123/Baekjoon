package Gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1715 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 비교 횟수가 가장 적으려면 현존하는 카드 묶음에서 가장 작은 두 카드묶음
		// 비교하여 합치는 것을 계속하는 방식을 사용해야 하기 때문에
		// PriorityQueue를 사용한다.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0 ; i < N ; i++) {
			int x = sc.nextInt();
			pq.add(x);
		}
		
		long result = 0;
		while(pq.size() > 1) {
			// 가장 작은 수를 꺼낸다.
			int a = pq.poll();
			// 그 다음 작은 수를 꺼낸다.
			int b = pq.poll();
			result += (a + b);
			// 카드 묶음을 합친 뒤에 다시 그 카드묶음을 연산을 위해 queue에 넣는다.
			pq.add(a+b);
		}
		
		System.out.println(result);
		sc.close();
	}
	
}
