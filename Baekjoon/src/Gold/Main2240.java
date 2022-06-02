package Gold;

import java.util.Scanner;

public class Main2240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int W = sc.nextInt();
		// 소요시간, 움직인 횟수에 대한 배열
		int[][] dp = new int[T+1][W+1];
		for(int i = 1 ; i <= T ; i++) {
			int temp = sc.nextInt();
			for(int j = 0 ; j <= W ; j++) {
				// 움직인 적이 없다면, 1번 아래 있는 것이므로
				// 자두가 1번에서 떨어지면 1초전에 가지고 있던 자두수에 1개를 추가하고
				// 2번에서 떨어지면 1초전에 가지고 있던 자두수를 유지한다.
				if(j == 0) {
					if(temp == 1) {
						dp[i][j] = dp[i-1][j] + 1;
					} else {
						dp[i][j] = dp[i-1][j];
					}
					continue;
				}
				// 움직인 횟수가 2의 배수면 1번 위치에 있는 것이므로
				// 자두가 1번에서 떨어지면 1초전에 이미 1번 나무로 와있던 경우의 수에 +1을 해준 것과 1초전에 2번에 있다가 움직여서 1번으로 온 경우중
				// 더 큰 값을 dp[i][j]에 대입한다.
				// 2번에서 떨어지면 1초전에 이미 2번 나무로 와있던 경우의 수에 +1을 해준 것과 1초전에 1번에 있다가 움직여서 2번으로 온 경우중
				// 더 큰 값을 dp[i][j]에 대입한다.
				if(j % 2 == 0) {
					if(temp == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j] + 1);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);
					}
					// 위 경우의 반대이다.
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
