package Gold;

import java.util.Scanner;

public class Main12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// �� ���ǰ� �� ���Ը� �����Ѵ�.
		int[][] bag = new int[N+1][2];
		for(int i = 1 ; i < N+1 ; i++) {
			bag[i][0] = sc.nextInt();
			bag[i][1] = sc.nextInt();
		}
		
		int dp[][] = new int[N+1][K+1];
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 1 ; j < K+1 ; j++) {
				// �⺻������ j���Ը� �� ��, ���� �� �ִ� ��ġ�� ���� �� ������ j���� �� ���� ���� �־��ش�.
				dp[i][j] = dp[i-1][j];
				// ������ ���԰� ���� ��쿡 ���� ���Ǳ����� �� ���� ���� ���� ������ ������ �鶧 �߿� �� ū ���� �־��ش�.
				if(j - bag[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bag[i][0]] + bag[i][1]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
