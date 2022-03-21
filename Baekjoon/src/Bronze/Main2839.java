package Bronze;

import java.util.Scanner;

public class Main2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = -1;
		Loop1 : for(int i = N/5 ; i>=0 ; i--) {
			Loop2 : for(int j = 0 ; (5*i+3*j) <= N ; j++) {
						if(N == 5*i+3*j) {
							min = i+j;
							break Loop1;
						}
				}
			}
		System.out.println(min);
		sc.close();
	}
}
