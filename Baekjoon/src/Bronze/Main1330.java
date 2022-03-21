package Bronze;

import java.util.Scanner;

public class Main1330 {

	public static void main(String[] args) {
// 		두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
//		A가 B보다 큰 경우에는 '>'를 출력한다.
//		A가 B보다 작은 경우에는 '<'를 출력한다.
//		A와 B가 같은 경우에는 '=='를 출력한다.
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A > B) System.out.println(">");
		else if (A < B) System.out.println("<");
		else System.out.println("==");
		sc.close();
	}

}
