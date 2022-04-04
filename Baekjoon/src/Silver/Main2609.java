package Silver;

import java.util.Scanner;

public class Main2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(gcd(A,B));
		System.out.println(lcm(A,B));
	}
	// 최대공약수를 구하는 메서드
	public static int gcd(int a, int b) {
		int result = 1;
		for(int i = 1 ; i <= Math.min(a, b) ;i++) {
			if(a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		return result;
	}
	// 최소공배수를 구하는 메서드
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}

}
