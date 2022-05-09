package Gold;

import java.util.Scanner;

public class Main12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 각 물건과 그 무게를 저장한다.
		int[][] bag = new int[N+1][2];
		for(int i = 1 ; i < N+1 ; i++) {
			bag[i][0] = sc.nextInt();
			bag[i][1] = sc.nextInt();
		}
		
		int dp[][] = new int[N+1][K+1];
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 1 ; j < K+1 ; j++) {
				// 기본적으로 j무게를 들 때, 가질 수 있는 가치의 합은 전 물건을 j무게 들 때의 값을 넣어준다.
				dp[i][j] = dp[i-1][j];
				// 가방의 무게가 남은 경우에 이전 물건까지만 들 때의 값과 현재 물건을 포함해 들때 중에 더 큰 값을 넣어준다.
				if(j - bag[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bag[i][0]] + bag[i][1]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
