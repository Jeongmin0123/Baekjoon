package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
	
	public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		Stack<Integer> check = new Stack<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// stack�� ������� �ʰ� ���� �� index�� �����ϴ� ���ڰ� ���ʿ� �����ϴ� ������ ���ں��� ū ��� ������
		// ���ڸ� ���� ����� �������� ���ڷ� �ٲ��ش�.
		for(int i = 0 ; i < n ; i++) {
			while(!check.isEmpty() && num[check.peek()] < num[i]) {
				num[check.pop()] = num[i];
			}
			check.push(i);
		}
		// stack�� �����ִ� ���ڵ��� �����ʿ� �ڱ� �ڽź��� ū ���ڰ� �����Ƿ� -1�� �������ش�.
		while(!check.isEmpty()) {
			num[check.pop()] = -1;
		}
		
		// �迭�� ����Ͽ� for������ ��� �� �ð��ʰ��� �߻��ϹǷ� StringBuilder�� ����Ѵ�.
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(num[i]).append(' ');
		}
		System.out.println(sb);
	}

}
