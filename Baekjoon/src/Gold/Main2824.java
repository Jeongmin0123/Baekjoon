package Gold;

import java.util.Scanner;

public class Main2824 {
	// 9자리보다 길다면, 마지막 9자리만 출력하기 때문에 자릿수를
	// 위한 long 타입의 숫자를 선언한다.
	static final long digit = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr1 = new long[N];
		for(int i = 0 ; i < N ; i++) {
			arr1[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		long[] arr2 = new long[M];
		for(int i = 0 ; i < M ; i++) {
			arr2[i] = sc.nextInt();
		}
		long answer = 1;
		// 1000000000보다 큰지 작은지를 판단하는 boolean 타입의 변수
		boolean digits = false;
		for(int i = 0 ; i < N ; i++) {
			// 숫자 1은 어떠한 숫자와도 최대공약수가 1이므로 굳이 계산할 필요가 없다.
			if(arr1[i] == 1) continue;
			for(int j = 0 ; j < M ; j++) {
				if(arr2[j] == 1) continue;
				long gcd = gcd(arr1[i], arr2[j]);
				answer *= gcd;
				if(answer >= digit) {
					answer %= digit;
					digits = true;
				}
				// 배열의 두 수의 최대 공약수가 다른 계산에서 중복되면 안 되기 때문에
				// 각각의 숫자들을 gcd로 나눠준다.
				arr1[i] = arr1[i]/gcd;
				arr2[j] = arr2[j]/gcd;
			}
		}
		// 1000000000보다 큰 경우에는 빈 앞 자리에 0을 채워줘야 하므로 채워주고 출력한다.
		if(digits) {
			String result = String.format("%09d", answer);
			System.out.println(result);
		} else {
			System.out.println(answer);
		}
	}
	// 유클리드 호제법에 의해서 GCD(최대공약수)를 구하는 메서드
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
