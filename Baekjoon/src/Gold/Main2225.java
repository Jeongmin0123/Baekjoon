package Gold;

import java.util.Scanner;

public class Main2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 계산 결과를 저장할 배열을 2차원 배열로 선언한다.
		// 이 때, 2차원 배열에서 앞의 숫자는 만들어야 될 수, 뒤에 숫자는 그 숫자를 몇개로 만들것인가
		// 라고 생각하면 된다.
		long dp[][] = new long[201][201];
		// 숫자 0을 i개로 만드는 경우의 수는 모든 숫자가 0이 되는 1가지 밖에 없으므로 dp[0][i]
		// 에 모두 1을 넣어준다. 마찬가지로 숫자 i를 1개로 만드는 경우의 수 또한 1가지 이므로
		// dp[i][1] 에 1을 넣어준다.
		for(int i = 0 ; i < 201 ; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
		}
		// i라는 숫자를 2개의 합으로 만드는 경우의 수는 i개의 공이 있을 때, 가림막 한개를 통하여
		// 공을 두 부류로 분류하는 경우의 수 이므로 i개의 공 사이에 가림막이 i+1의 경우의 수로 들어갈
		// 수 있으므로 dp[i][2]에 i+1 을 저장한다.
		for(int i = 1 ; i < 201 ; i++) {
			dp[i][2] = i+1;
		}
		for(int i = 3 ; i < 201 ; i++) {
			for(int j = 1 ; j < 201 ; j++) {
				for(int k = 0 ; k <= j ; k++) {
					// j라는 숫자를 i개로 만드는 방법은 1개를 k라고 임의 지정해주고 나머지 i-1개의 숫자로
					// 원래 원하는 숫자 j - k를 구하는 방법과 같다.
					dp[j][i] += dp[j-k][i-1]%1000000000;
				}
			}
		}
		System.out.println(dp[N][M]%1000000000);
	}
}
		
/*	시간 초과로 돌아가지 않는 코드
 * 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
  		long result = combination(N, M);
		System.out.println(result%1000000000);
		}
			
	public static long combination(long n, long r) {
		long result = 0;
		if(n == 0) return 1;
		if(r == 1) return 1;
		else if(r == 2) {
			return n+1;
		} else {
			for(int i = 0 ; i <= n ; i++) {
				result += combination(n-i, r-1);
			}
			return result;
		}
	}*/

