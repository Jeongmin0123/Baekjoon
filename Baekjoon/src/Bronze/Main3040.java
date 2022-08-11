package Bronze;

import java.util.Scanner;

public class Main3040 {

	public static int[] arr = new int[9];
	public static int[] result = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
		}
		comb(0,0);
		sc.close();
	}
	
	public static void comb(int cnt, int idx) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7 ; i++) {
				sum += result[i];
			}
			if(sum == 100) {
				for(int i = 0 ; i < 7 ; i++) {
					System.out.println(result[i]);
				}
				return;
			}
			return;
		}
		for(int i = idx ; i < 9 ; i++) {
			result[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
	}

}
