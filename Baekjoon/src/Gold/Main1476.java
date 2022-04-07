package Gold;

import java.util.Scanner;

public class Main1476 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int result = chinese(E, S, M);
		System.out.println(result);
	}
	public static int chinese(int E, int S, int M) {
		int result = E*28*19 + S*15*19 + M*15*28;
		while(result > 15*28*19) {
			result -= 15*28*19;
		}
		return result;
	}
}
