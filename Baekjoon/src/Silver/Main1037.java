package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] divisor = new int[N];
		for(int i = 0 ; i < N ; i++) {
			// ��¥ ������� �迭�� �޾ƿ´�.
			divisor[i] = sc.nextInt();
		}
		// �迭�� �������ش�
		Arrays.sort(divisor);
		// ���� ū ����� ���� ���� ����� ���� ���� �����̹Ƿ�
		// ���ĵǾ� �ִ� �迭���� ���� ���� ���ڿ� ���� ���� ���ڸ� ���Ͽ� ���� ���Ѵ�.
		System.out.println(divisor[0]*divisor[N-1]);
	}

}
