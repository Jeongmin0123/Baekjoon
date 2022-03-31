package Silver;

import java.util.Scanner;

public class Main6588 {
	// 숫자가 1000000이하이므로 아래와 같은 boolean 타입의 배열을 만들어준다.
	public static boolean[] prime = new boolean[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열에 모든 값에 대하여 소수인지 아닌지에 대한 결과값을 넣어준다
		prime_check();
		while(true) {
			int a = sc.nextInt();
			if(a == 0) break;
			boolean result = false;
			// 만약 골드바흐의 추측이 맞다면, 어떠한 숫자의 중간을 기준으로 한 값은
			// 중간값보다 크고 한 값은 중간값보다 작으므로 for문의 범위를 a/2까지로 한다.
			for(int i = 3 ; i <= a/2 ; i+=2) {
				// i 와 a-i의 합이 a 이므로 두 수가 prime인 경우 결과값을 출력하고
				// 더 이상의 연산은 필요 없으므로 for문을 종료한다.
				if(!prime[i] && !prime[a-i]) {
					System.out.println(a+ " = "+ i +" + " + (a-i));
					result = true;
					break;
				}
			}
			if(!result) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
	// 배열의 값들이 소수인지 아닌지 판단하여 값을 넣어주는 함스
	public static void prime_check() {
		prime[0] = prime[1] = true;
		// 에라토스테네스의 체를 이용한다.
		for(int i = 2 ; i <= Math.sqrt(1000000) ; i++) {
			if(!prime[i]) {
				for(int j = i*i ; j <= 1000000 ; j+= i) {
					prime[j] = true;
				}
			}         
		}
	}

}