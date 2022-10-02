package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070_dp {

	public static int N;
	public static int[][] map;
	public static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0] = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 1 ; j < N ; j++) {
				if(map[i][j] == 1) continue;
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][1];
				if(i == 0) continue;
				dp[i][j][2] += dp[i-1][j][1] + dp[i-1][j][2];
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				dp[i][j][1] += dp[i-1][j-1][0] + dp[i-1][j-1][2] + dp[i-1][j-1][1];
			}
		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}

}
