package Bronze;

import java.util.Scanner;

public class Main1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sub = new int[N];
		double sum = 0;
		for(int i = 0; i <sub.length; i++) {
			sub[i] = sc.nextInt();
		}
		double M = sub[0];
		for(int i = 0 ; i < sub.length ; i++) {
			if( sub[i] > M) M = sub[i];
		}
		for(int i = 0 ; i < sub.length ; i++) {
			sum += (sub[i]/M)*100;
		}
		System.out.println(sum/sub.length);
		sc.close();
	}
}
