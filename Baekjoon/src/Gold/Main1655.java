package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 중간값을 기준으로 앞에 오는 숫자들
		PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
		// 중간값을 기준으로 뒤에 오는 숫자들
		PriorityQueue<Integer> back = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(front.size() == back.size()) { 
				front.add(num);
			} else {
				back.add(num);
			} 
			// 앞쪽의 숫자에서 가장 큰 값과 뒤쪽의 숫자들에서 가장 작은 값의 대소를 비교하여 앞쪽 숫자가 더 크면 위치를 바꾼다.
			if(!front.isEmpty() && !back.isEmpty()) {
				if(front.peek() > back.peek()) {
					int temp = front.poll();
					front.add(back.poll());
					back.add(temp);
				}
			}
			sb.append(front.peek() + "\n");
		}
		System.out.println(sb);
	}

}
