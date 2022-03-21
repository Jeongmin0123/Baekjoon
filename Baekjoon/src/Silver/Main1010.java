package Silver;

import java.util.Scanner;

public class Main1010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] results = new int[T];
		for(int i = 0; i < T ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			double result = 1;
			for(int j = 1 ; j <= A ; j++) {
				result = (double) result*(B+1-j)/j;
			}
			results[i] = (int) result;
		}
		
		for(int i = 0 ; i < T ; i++) {
			System.out.println(results[i]);
		}
		sc.close();
	}

}
