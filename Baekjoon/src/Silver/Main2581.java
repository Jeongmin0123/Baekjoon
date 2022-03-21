package Silver;

import java.util.Scanner;

public class Main2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = 0;
		for(int i = M ; i <= N ; i++) {
			int temp_min = 0;
			for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
				if(i%j != 0) {
					temp_min = i;
				} else {
					temp_min = 0;
					break;
				}
			}
			
			sum += temp_min;
			if(min == 0 && temp_min != 0) {
				min = temp_min;
			} else if(min > temp_min && temp_min != 0) {
				min = temp_min;
			}
		}
		if(min != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
		
		sc.close();
	}
}
