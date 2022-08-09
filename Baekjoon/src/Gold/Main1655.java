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
		// �߰����� �������� �տ� ���� ���ڵ�
		PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
		// �߰����� �������� �ڿ� ���� ���ڵ�
		PriorityQueue<Integer> back = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(front.size() == back.size()) { 
				front.add(num);
			} else {
				back.add(num);
			} 
			// ������ ���ڿ��� ���� ū ���� ������ ���ڵ鿡�� ���� ���� ���� ��Ҹ� ���Ͽ� ���� ���ڰ� �� ũ�� ��ġ�� �ٲ۴�.
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
