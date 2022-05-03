package Gold;

import java.util.Scanner;

public class Main1806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] num = new int[N];
		// N�� ������ 10���� ũ�ų� ���� 100000���� �����Ƿ� ���� answer�� �ʱⰪ�� 100001�� �д�
		// ����, ������ ������ �� answer�� 100001�̸� �Ұ����� ����̹Ƿ� 0�� ����Ѵ�.
		int answer = 100001;
		for(int i = 0 ; i < N ; i++) {
			num[i] = sc.nextInt();
		}
		// ������ �պ��� �ڱ����� ��
		int sum = 0;
		// ������ ������
		int start = 0;
		// ������ ������ ��
		int end = 0;
		while(true) {
			// ������ �����ϴ� ���
			if(sum >= S) {
				// �������� ��ĭ ������Ų��
				sum -= num[start];
				// ����Ǿ� �ִ� ������ ������ �����ϴ� ������ �� ���� ���� �����Ѵ�.
				answer = Math.min(answer, (end - start));
				start++;
				// ������ ���� �� ������ �����ϸ� �����Ѵ�.
			} else if(end == N) {
				break;
			} else {
				// ������ �������� ���ϹǷ� ������ �÷��ش�.
				sum += num[end];
				end++;
			}
		}
		if(answer == 100001) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
		sc.close();
	}

}