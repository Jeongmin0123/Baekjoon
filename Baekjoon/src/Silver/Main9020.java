package Silver;

import java.util.Scanner;

public class Main9020 {

	public static void main(String[] args) {
		// Scanner를 이용하여 숫자를 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int n = sc.nextInt();
			prime_part(n);
		}
		sc.close();
	}
	public static void prime_part(int n) {
		// a, b는 숫자를 받아 이 숫자가 소수인지 아닌지를 판단하기 위해 필요한 변수
		int a; int b;
		// r1, r2 : 소수 partition 숫자를 저장하기 위한 변수
		int r1 = 0; int r2 = 0;
		for(int i = 2; i <= n/2; i++) {
			a = i; b = n - a;
			if(prime_check(a) && prime_check(b)) {
				r1 = a; r2 = b;
			}
		}
		System.out.println(r1 + " " + r2);
	}
	// 주어진 숫자가 소수인지 아닌지를 판단하는 함수
	public static boolean prime_check(int n) {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
