package Gold;

import java.util.Scanner;

public class Main11058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i번 눌렀을 때, 최대로 출력할 수 있는 A값을 저장하는 배열
		long[] dp = new long[101];
		for(int i = 1 ; i < dp.length ; i++) {
			// 기본적으로 i번 눌렀을 때, 최대 출력 가능한 A값은 i-1번 누른 상태에서 A를 한번 더 출력하는 방법이다.
			dp[i] = dp[i-1] + 1;
			// 전체 선택 후 복사하고 1회 붙여넣으면 dp[i] = dp[i-3]*2와 같다.
			// 이때, j회 붙여녛으면 에[i] = dp[i-j]*(j-1)라는 식을 얻을 수 있다.
			// 이때, i가 6보다 크면 클립보드에 복사 후 4회 붙여넣는 것보다 복사 후 붙여넣기를 두번 반복하는 것이 더 크므로 j의 범위를 3~5로 한다.
			if(i > 6) {
				for(int j = 3 ; j < 6 ; j++) {
					dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
				}
			}
		}
		System.out.println(dp[N]);
	}
}
