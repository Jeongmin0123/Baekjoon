package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9251 {

	static char[] a;
	static char[] b;
	// Integer �迭�� ����ϴ� ������ dp���� ���ڰ� �����Ǿ����� Ȯ���Ͽ� ���� �Ǿ��ٸ� ������ ���� �ʾ�
	// ���� ����� ���̱� �����̴�.
	// ���� int �迭�� ����ٸ� 0�� �ڵ����� �� � ��ġ�� ���ڰ� ������ �� 0�� �������� ���� ������
	// ���� ���� ������ Ȯ���� �� ����.
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
