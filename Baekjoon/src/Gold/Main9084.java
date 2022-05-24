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
			// i원을 만드는 방법을 저장하는 배열
			int[] dp = new int[obj+1];
			dp[0] = 1;
			for(int j = 0 ; j < N ; j++) {
				for(int k = coin[j] ; k <= obj ;  k++) {
					// k 원을 만드는 방법은 k-coin[j]에서 coin[j]원을 추가해주는 것과 같으므로
					// 아래와 같은 식을 사용할 수 있다.
					dp[k] += dp[k-coin[j]];
				}
			}
			System.out.println(dp[obj]);
		}
		
	}

}
