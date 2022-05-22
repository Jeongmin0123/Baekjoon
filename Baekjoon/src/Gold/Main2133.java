package Gold;

import java.util.Scanner;

public class Main2133 {
  	public static long[] dp;
  	public static void main(String[] args) {
  		Scanner sc = new Scanner(System.in);
  		int n = sc.nextInt();
  		dp = new long[31];
  		dp[0] = 1;
  		// 3X2 �� ���� �� �ִ� ����
  		dp[2] = 3;
  		// ����� ��ġ�� �ʰ� ���� �� �ִ� unique�� ���
  		int unique = 2;
  		for(int i = 4 ; i <= 30 ; i += 2) {
  			dp[i] = dp[i-2]*dp[2];
  			for(int j = i - 4 ; j >= 0 ; j -= 2) {
  				dp[i] += unique*dp[j];
  			}
  		}
     	System.out.println(dp[n]);
     	sc.close();
  	}
}