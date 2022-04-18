package Gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1715 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// �� Ƚ���� ���� �������� �����ϴ� ī�� �������� ���� ���� �� ī�幭��
		// ���Ͽ� ��ġ�� ���� ����ϴ� ����� ����ؾ� �ϱ� ������
		// PriorityQueue�� ����Ѵ�.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0 ; i < N ; i++) {
			int x = sc.nextInt();
			pq.add(x);
		}
		
		long result = 0;
		while(pq.size() > 1) {
			// ���� ���� ���� ������.
			int a = pq.poll();
			// �� ���� ���� ���� ������.
			int b = pq.poll();
			result += (a + b);
			// ī�� ������ ��ģ �ڿ� �ٽ� �� ī�幭���� ������ ���� queue�� �ִ´�.
			pq.add(a+b);
		}
		
		System.out.println(result);
		sc.close();
	}
	
}
