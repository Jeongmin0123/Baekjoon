package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int size = (int) (max - min + 1);
		/*
		 * �� ó���� size�� (int) max�� �ΰ� ������ Ǯ����.
		 * ������ ���� �߻� (java.lang.NegativeArraySizeException)
		 * �� ������ �ΰ����� �߰��� ����
		 */
		boolean check[] = new boolean[size];
		// ������ ������ŭ�� ũ�⸦ ���� �迭�� �����Ͽ� ������ ���ڰ� ���� ���������� �ƴ����� booleanŸ������ �޾ƿ� ����
		Arrays.fill(check, false);
		// ���� �������� false������ ���� ����
		// �����佺�׳׽��� ü ��뿹��
		for(long i = 2; i <= Math.sqrt(max); i++) {
			// �����佺�׳׽��� ü�� ���Ͽ� i�� 2���� ��Ʈ max���� �۰ų� ���� �������� ����Ѵ�.
			long start = min % (i*i) == 0 ? min / (i*i) : (min / (i*i)) + 1;
			// min ���� i^2���� �������� min / (i*i)�� �ʱⰪ����, �ƴϸ� (min / (i*i)) + 1 �ʱⰪ���� �޴´�
			// �������� ���  min / (i*i) * (i*i) �� min���� ������ �������� �ʴ� ���  min / (i*i) * (i*i)�� min���� �۰Եȴ�
			// ����  (min / (i*i)) + 1 �� �ʱⰪ���� �Ͽ� min���� �ʱⰪ�� ũ���� �Ѵ�.
			for(long j = start; i*i*j <= max; j++) {
				// �����佺�׳׽��� ü�� �̿��Ͽ� i*i*j������ �������� �������� ������ ���� �������� �ƴϹǷ� true ������ �ٲ��ش�.
				check[(int)((i*i*j) - min)] = true;
			}
		}
		int count = 0;
		for(int k = 0; k < size; k++) {
			if(check[k] == false) count++;
		}

		System.out.println(count);
		sc.close();

	}
}
		/*
		 * �ð��ʰ�
		 * Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int count = 0;
		for(long i = min ; i <= max ; i++) {
			if(check_num(i)) count++;
		}
		System.out.println(count);
	}
	
	// ��� ���� ���� ���������� �Ǵ��ϴ� �Լ�
	public static boolean check_num(long n) {
		for(int j = 2 ; j <= Math.sqrt(n) ; j++) {
			if (n%Math.pow(j, 2) == 0) {
				return false;
			}
		}
		return true;
	}*/


