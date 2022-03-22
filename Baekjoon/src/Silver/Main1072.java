package Silver;

import java.util.Scanner;

// 시간초과
public class Main1072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		double result = Y*100.0/X;
		int Z = (int) Math.floor(result);
		int count = 0;
		while(Z >= Math.floor(Y*100.0/X)) {
			if(Z >= 99) {
				count = -1;
				break;
			}
			count++;
			X++;
			Y++;
		}
		System.out.println(count);
	}

}
