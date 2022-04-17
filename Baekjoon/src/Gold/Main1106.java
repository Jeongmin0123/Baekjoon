package Gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1106 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[][] money = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			money[i][0] = sc.nextInt();
			money[i][1] = sc.nextInt();
		}
		int result = 0;		
		double[][] rank = new double[N][2];
		for(int i = 0 ; i < N ; i++) {
			// 1원당 유치할 수 있는 고객수
			rank[i][0] = (double) money[i][1]/ (double)money[i][0];
			// 몇번째 도시인지 저장한다.
			rank[i][1] = i; 
		}
		Arrays.sort(rank, new Comparator<double[]>() {
			@Override public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[0], o2[0]);
				} 
			});
		result = (C/money[(int) rank[N-1][1]][1])*money[(int) rank[N-1][1]][0];
		
		int remain = C%money[(int) rank[N-1][1]][1];
		if(remain == 0) {
			System.out.println(result);
		} else {
			for(int i = 0 ; i < N ; i++) {
				int temp1 = money[i][0];
				int temp2 = money[i][1];
				while(money[i][1] < remain) {
					money[i][0] += temp1;
					money[i][1] += temp2;
				}
			}
			
			int min = money[0][0];
			for(int i = 1 ; i < N ; i++) {
				if(min >= money[i][0]) {
					min = money[i][0];
				}
			}
			result += min;
			System.out.println(result);
		}

	}
}
