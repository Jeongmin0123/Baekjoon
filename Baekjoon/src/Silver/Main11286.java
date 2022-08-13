package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			int temp = Integer.parseInt(br.readLine());
			// 0보다 크면 양수 queue에 작으면 음수 queue에 넣어준다
			if(temp > 0) {
				plus.add(temp);
			} else if(temp < 0) {
				minus.add(temp);
			} else {
				if(plus.isEmpty() && minus.isEmpty()) {
					sb.append(0);
				} else if(plus.isEmpty()) {
					sb.append(minus.poll());
				} else if(minus.isEmpty()) {
					sb.append(plus.poll());
				} else {
					if(Math.abs(plus.peek()) < Math.abs(minus.peek())) {
						sb.append(plus.poll());
					} else {
						sb.append(minus.poll());
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
