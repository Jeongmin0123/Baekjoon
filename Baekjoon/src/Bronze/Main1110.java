package Bronze;

import java.util.Scanner;

public class Main1110 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp = N;
		int count = 0;
		do {
			if(temp < 10) {
				temp = 10*temp + temp;
			} else if((temp%10 + temp/10) >= 10) {
				temp = 10*(temp%10) + (temp%10 + temp/10) - 10;
			} else {
				temp = 10*(temp%10) + (temp%10 + temp/10);
			}
			count++;
		} while(temp != N);
		System.out.println(count);
		sc.close();
	}
}
