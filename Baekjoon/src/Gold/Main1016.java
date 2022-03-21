package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int size = (int) (max - min + 1);
		/*
		 * 맨 처음에 size를 (int) max로 두고 문제를 풀었다.
		 * 하지만 오류 발생 (java.lang.NegativeArraySizeException)
		 * 이 이유는 부가설명에 추가할 예정
		 */
		boolean check[] = new boolean[size];
		// 숫자의 개수만큼의 크기를 가진 배열을 선언하여 각각의 숫자가 제곱 ㄴㄴ수인지 아닌지를 boolean타입으로 받아올 예정
		Arrays.fill(check, false);
		// 제곱 ㄴㄴ수를 false값으로 받을 예정
		// 에라토스테네스의 체 사용예정
		for(long i = 2; i <= Math.sqrt(max); i++) {
			// 에라토스테네스의 체에 의하여 i는 2부터 루트 max보다 작거나 같은 수까지만 계산한다.
			long start = min % (i*i) == 0 ? min / (i*i) : (min / (i*i)) + 1;
			// min 값이 i^2으로 나눠지면 min / (i*i)을 초기값으로, 아니면 (min / (i*i)) + 1 초기값으로 받는다
			// 나눠지는 경우  min / (i*i) * (i*i) 가 min값이 되지만 나눠지지 않는 경우  min / (i*i) * (i*i)는 min보다 작게된다
			// 따라서  (min / (i*i)) + 1 을 초기값으로 하여 min보다 초기값이 크도록 한다.
			for(long j = start; i*i*j <= max; j++) {
				// 에라토스테네스의 체를 이용하여 i*i*j값들은 제곱수로 나눠지기 때문에 제곱 ㄴㄴ수가 아니므로 true 값으로 바꿔준다.
				check[(int)((i*i*j) - min)] = true;
			}
		}
		int count = 0;
		for(int k = 0; k < size; k++) {
			if(check[k] == false) count++;
		}

		System.out.println(count);
		sc.close();

	}
}
		/*
		 * 시간초과
		 * Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int count = 0;
		for(long i = min ; i <= max ; i++) {
			if(check_num(i)) count++;
		}
		System.out.println(count);
	}
	
	// 어떠한 수가 제곱 ㄴㄴ수인지 판단하는 함수
	public static boolean check_num(long n) {
		for(int j = 2 ; j <= Math.sqrt(n) ; j++) {
			if (n%Math.pow(j, 2) == 0) {
				return false;
			}
		}
		return true;
	}*/


