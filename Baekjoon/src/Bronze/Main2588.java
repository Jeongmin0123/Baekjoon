package Bronze;

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		//(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A*(B%10));
		System.out.println(A*((B/10)%10));
		System.out.println(A*(B/100));
		System.out.println(A*B);
		sc.close();
	}

}
