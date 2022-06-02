package Gold;

import java.util.Scanner;

public class Main2240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int W = sc.nextInt();
		// �ҿ�ð�, ������ Ƚ���� ���� �迭
		int[][] dp = new int[T+1][W+1];
		for(int i = 1 ; i <= T ; i++) {
			int temp = sc.nextInt();
			for(int j = 0 ; j <= W ; j++) {
				// ������ ���� ���ٸ�, 1�� �Ʒ� �ִ� ���̹Ƿ�
				// �ڵΰ� 1������ �������� 1������ ������ �ִ� �ڵμ��� 1���� �߰��ϰ�
				// 2������ �������� 1������ ������ �ִ� �ڵμ��� �����Ѵ�.
				if(j == 0) {
					if(temp == 1) {
						dp[i][j] = dp[i-1][j] + 1;
					} else {
						dp[i][j] = dp[i-1][j];
					}
					continue;
				}
				// ������ Ƚ���� 2�� ����� 1�� ��ġ�� �ִ� ���̹Ƿ�
				// �ڵΰ� 1������ �������� 1������ �̹� 1�� ������ ���ִ� ����� ���� +1�� ���� �Ͱ� 1������ 2���� �ִٰ� �������� 1������ �� �����
				// �� ū ���� dp[i][j]�� �����Ѵ�.
				// 2������ �������� 1������ �̹� 2�� ������ ���ִ� ����� ���� +1�� ���� �Ͱ� 1������ 1���� �ִٰ� �������� 2������ �� �����
				// �� ū ���� dp[i][j]�� �����Ѵ�.
				if(j % 2 == 0) {
					if(temp == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j] + 1);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);
					}
					// �� ����� �ݴ��̴�.
				} else {
					if(temp == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1,dp[i-1][j]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]+1);
					}
				}
			}
		}
		int answer = 0;
		for(int i = 0 ; i <= W ; i++) {
			answer = Math.max(answer, dp[T][i]);
		}
		System.out.println(answer);
		sc.close();
	}	
}
