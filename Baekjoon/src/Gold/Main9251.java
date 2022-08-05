package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9251 {

	static char[] a;
	static char[] b;
	// Integer 배열을 사용하는 이유는 dp내의 숫자가 배정되었는지 확인하여 배정 되었다면 연산을 하지 않아
	// 연산 결과를 줄이기 위함이다.
	// 만약 int 배열로 만든다면 0이 자동으로 들어가 어떤 위치의 숫자가 연산한 뒤 0을 받은건지 아직 연산이
	// 되지 않은 것인지 확인할 수 없다.
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		
		dp = new Integer[a.length][b.length];
		System.out.println(LCS(a.length-1, b.length-1));
	}
	
	static int LCS(int x, int y) {
		if(x == -1 || y == -1) {
			return 0;
		} else {
			if(dp[x][y] == null) {
				if(a[x] == b[y]) {
					dp[x][y] = LCS(x-1,y-1) +1;
				} else {
					dp[x][y] = Math.max(LCS(x-1,y), LCS(x,y-1));
				}
			}
		}
		return dp[x][y];
	}
}
