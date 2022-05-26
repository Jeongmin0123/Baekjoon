package Gold;

import java.util.Scanner;

public class Main11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i�� ������ ��, �ִ�� ����� �� �ִ� A���� �����ϴ� �迭
		long[] dp = new long[101];
		for(int i = 1 ; i < dp.length ; i++) {
			// �⺻������ i�� ������ ��, �ִ� ��� ������ A���� i-1�� ���� ���¿��� A�� �ѹ� �� ����ϴ� ����̴�.
			dp[i] = dp[i-1] + 1;
			// ��ü ���� �� �����ϰ� 1ȸ �ٿ������� dp[i] = dp[i-3]*2�� ����.
			// �̶�, jȸ �ٿ������� ��[i] = dp[i-j]*(j-1)��� ���� ���� �� �ִ�.
			// �̶�, i�� 6���� ũ�� Ŭ�����忡 ���� �� 4ȸ �ٿ��ִ� �ͺ��� ���� �� �ٿ��ֱ⸦ �ι� �ݺ��ϴ� ���� �� ũ�Ƿ� j�� ������ 3~5�� �Ѵ�.
			if(i > 6) {
				for(int j = 3 ; j < 6 ; j++) {
					dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
				}
			}
		}
		System.out.println(dp[N]);
	}
}
