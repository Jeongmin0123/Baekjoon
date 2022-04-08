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
	// 중국인의 나머지 정리를 사용한다
	// 15, 28, 19가 서로 서로소이기 때문에
	public static int chinese(int E, int S, int M) {
		int result = E*28*19*13 + S*15*19*17 + M*15*28*10;
		while(result > 15*28*19) {
			result -= 15*28*19;
		}
		return result;
	}
}
