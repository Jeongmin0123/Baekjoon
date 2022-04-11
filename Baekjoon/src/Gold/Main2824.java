package Gold;

import java.util.Scanner;

public class Main2824 {
	// 9�ڸ����� ��ٸ�, ������ 9�ڸ��� ����ϱ� ������ �ڸ�����
	// ���� long Ÿ���� ���ڸ� �����Ѵ�.
	static final long digit = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr1 = new long[N];
		for(int i = 0 ; i < N ; i++) {
			arr1[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		long[] arr2 = new long[M];
		for(int i = 0 ; i < M ; i++) {
			arr2[i] = sc.nextInt();
		}
		long answer = 1;
		// 1000000000���� ū�� �������� �Ǵ��ϴ� boolean Ÿ���� ����
		boolean digits = false;
		for(int i = 0 ; i < N ; i++) {
			// ���� 1�� ��� ���ڿ͵� �ִ������� 1�̹Ƿ� ���� ����� �ʿ䰡 ����.
			if(arr1[i] == 1) continue;
			for(int j = 0 ; j < M ; j++) {
				if(arr2[j] == 1) continue;
				long gcd = gcd(arr1[i], arr2[j]);
				answer *= gcd;
				if(answer >= digit) {
					answer %= digit;
					digits = true;
				}
				// �迭�� �� ���� �ִ� ������� �ٸ� ��꿡�� �ߺ��Ǹ� �� �Ǳ� ������
				// ������ ���ڵ��� gcd�� �����ش�.
				arr1[i] = arr1[i]/gcd;
				arr2[j] = arr2[j]/gcd;
			}
		}
		// 1000000000���� ū ��쿡�� �� �� �ڸ��� 0�� ä����� �ϹǷ� ä���ְ� ����Ѵ�.
		if(digits) {
			String result = String.format("%09d", answer);
			System.out.println(result);
		} else {
			System.out.println(answer);
		}
	}
	// ��Ŭ���� ȣ������ ���ؼ� GCD(�ִ�����)�� ���ϴ� �޼���
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
