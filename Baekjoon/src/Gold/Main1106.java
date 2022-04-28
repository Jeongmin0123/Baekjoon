package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1106 {
	// �񱳰����� C�� 1000���� �۰ų� ���� �� ������ ȫ�� ����� 100���� �۰ų� �����Ƿ�
	// ��� ����� �ִ밪�� 100000�̴�. ���� �̰ͺ��� ū ���� �񱳱����� �����ϸ� �ȴ�.
	static final int comparison = 999999999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		// �Ʒ��� �迭�� i���� ȫ���� �� ��� �ּҺ���� ���� �迭�̹Ƿ�
		// �� ��, �츮�� ��� C���� �ñ��ϹǷ� C+1�� �迭�� ũ��� ������ �ڿ�,
		// �� ���ÿ��� ȫ���� �� �ִ� ���� ���� 100�����̹Ƿ� C+101���� �迭�� ũ�⸦ �ø���.
		int[] min = new int[C+101];
		Arrays.fill(min, comparison);
		// 0���� ��ġ�ϴ� ����� 0�̴�.
		min[0] = 0;
		for(int i = 0 ; i < N ; i++) {
			// ���
			int cost = sc.nextInt();
			// ��뿡 ���� ��ġ�ο�
			int customer = sc.nextInt();
			// ������ ��쿡�� ��ġ �ο��� customer���� �����Ѵ�.
			for(int j = customer ; j < C+101 ; j++) {
				min[j] = Math.min(min[j], cost + min[j-customer]);
			}
		}
		
		int result = comparison;
		for(int i = C ; i < C+101 ; i++) {
			result = Math.min(min[i], result);
		}
		System.out.println(result);
		sc.close();
	}
}