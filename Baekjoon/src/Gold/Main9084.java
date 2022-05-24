package Gold;

import java.util.Scanner;

public class Main9084 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int N = sc.nextInt();
			int[] coin = new int[N];
			for(int a = 0 ; a < N ; a++) {
				coin[a] = sc.nextInt();
			}
			int obj = sc.nextInt();
			// i���� ����� ����� �����ϴ� �迭
			int[] dp = new int[obj+1];
			dp[0] = 1;
			for(int j = 0 ; j < N ; j++) {
				for(int k = coin[j] ; k <= obj ;  k++) {
					// k ���� ����� ����� k-coin[j]���� coin[j]���� �߰����ִ� �Ͱ� �����Ƿ�
					// �Ʒ��� ���� ���� ����� �� �ִ�.
					dp[k] += dp[k-coin[j]];
				}
			}
			System.out.println(dp[obj]);
		}
		
	}

}
