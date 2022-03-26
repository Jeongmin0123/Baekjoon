package Gold;

import java.util.Scanner;

public class Main2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// ��� ����� ������ �迭�� 2���� �迭�� �����Ѵ�.
		// �� ��, 2���� �迭���� ���� ���ڴ� ������ �� ��, �ڿ� ���ڴ� �� ���ڸ� ��� ������ΰ�
		// ��� �����ϸ� �ȴ�.
		long dp[][] = new long[201][201];
		// ���� 0�� i���� ����� ����� ���� ��� ���ڰ� 0�� �Ǵ� 1���� �ۿ� �����Ƿ� dp[0][i]
		// �� ��� 1�� �־��ش�. ���������� ���� i�� 1���� ����� ����� �� ���� 1���� �̹Ƿ�
		// dp[i][1] �� 1�� �־��ش�.
		for(int i = 0 ; i < 201 ; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
		}
		// i��� ���ڸ� 2���� ������ ����� ����� ���� i���� ���� ���� ��, ������ �Ѱ��� ���Ͽ�
		// ���� �� �η��� �з��ϴ� ����� �� �̹Ƿ� i���� �� ���̿� �������� i+1�� ����� ���� ��
		// �� �����Ƿ� dp[i][2]�� i+1 �� �����Ѵ�.
		for(int i = 1 ; i < 201 ; i++) {
			dp[i][2] = i+1;
		}
		for(int i = 3 ; i < 201 ; i++) {
			for(int j = 1 ; j < 201 ; j++) {
				for(int k = 0 ; k <= j ; k++) {
					// j��� ���ڸ� i���� ����� ����� 1���� k��� ���� �������ְ� ������ i-1���� ���ڷ�
					// ���� ���ϴ� ���� j - k�� ���ϴ� ����� ����.
					dp[j][i] += dp[j-k][i-1]%1000000000;
				}
			}
		}
		System.out.println(dp[N][M]%1000000000);
	}
}
		
/*	�ð� �ʰ��� ���ư��� �ʴ� �ڵ�
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

