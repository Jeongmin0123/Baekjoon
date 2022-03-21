package Silver;

import java.util.Scanner;

public class Main4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 0이 나올 때까지 계속 진행되는 무한루프를 사용한다.
		while(true) {
			int n = sc.nextInt();
			int count = 0;
			// n과 2n 사이의 숫자 안의 prime에 대한 연산을 진행할 때마다 count가 올라간다.
			for(int i = n+1; i <=2*n ; i++) {
				if(prime_check(i)) {
					count++;
				}
			}
			if(n == 0) break;
			System.out.println(count);
		}
		sc.close();
	}
	// 주어진 숫자가 소수인지, 아닌지를 판단하여 boolean 값을 리턴해주는 함수
	public static boolean prime_check(int n) {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
