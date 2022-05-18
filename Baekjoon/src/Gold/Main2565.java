package Gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2565 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] vel = new int[n+1][2];
		int[] dp = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			vel[i][0] = sc.nextInt();
			vel[i][1] = sc.nextInt();
		}
		// A�� �������� �������� ����
		Arrays.sort(vel, new Comparator<int[]>() { 			
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0]<b[0]) {
					return -1;
				} else if(a[0]>b[0]) {
					return 1;
				}
				return 0;
			}
         
		});
      
		dp[1] = 1;
		// i��° ������ ��ġ�� ���������� �ϴ� ���� �� �������� �迭�� ���ϴ� ���
		for(int i = 2 ; i <= n ; i++) {
			dp[i] = 1;
			for(int j = 1 ; j < i ; j++) {
				if(vel[i][1] > vel[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max = 0;
		for(int i = 1 ; i <= n ; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(n-max);
	}
}