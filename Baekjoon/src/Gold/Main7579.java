package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7579 {

	public static int N, M, result;
	public static int[] bites;
	public static int[] prices;
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		bites = new int[N];
		prices = new int[N];
		// N이 100이하이고 각각의 비용도 100 이하이므로 가질 수 있는 최대비용이 10000이므로 이를 고려하여 dp배열을 생성한다.
		dp = new int[N][10001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			bites[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		// 앱이 하나인 경우 초기화를 해준다.
		for(int j = 0 ; j < 10001 ; j++) {
			int bite = bites[0];
			int price = prices[0];
			// 만약 현재 앱 종료비용보다 사용가능한 비용이 높은 경우 그 때 비활성화 가능한 메모리양을 초기화한다.
			if(j >= price) {
				dp[0][j] = bite;
			}
			// 한 개의 앱을 종료했을 때, M 바이트를 확보했다면 그때의 비용과 result 를 비교하여 result를 초기화한다.
			if(dp[0][j] >= M) result = Math.min(result, j);
		}
		for(int i = 1 ; i < N ; i++) {
			int bite = bites[i];
			int price = prices[i];
			for(int j = 0 ; j < 10001 ; j++) {
				// 만약 현재 앱 종료비용보다 사용가능한 비용이 높은 경우 그 때 비활성화 가능한 메모리양을 초기화한다.
				if(j >= price) {
					dp[i][j] = Math.max(dp[i-1][j-price] + bite, dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				// 한 개의 앱을 종료했을 때, M 바이트를 확보했다면 그때의 비용과 result 를 비교하여 result를 초기화한다.
				if(dp[i][j] >= M) result = Math.min(result, j);
			}
		}
		System.out.println(result);
	}

}
