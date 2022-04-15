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
		
		Arrays.sort(money, new Comparator<int[]>() {
			@Override public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1]; 
					} else {
						return o1[0] - o2[0]; 
						} 
				} 
			});
		int result = 0;
		int index = 0;
		while(C>0) {
		}
	}
}
