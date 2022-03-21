package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] divisor = new int[N];
		for(int i = 0 ; i < N ; i++) {
			// 진짜 약수들을 배열에 받아온다.
			divisor[i] = sc.nextInt();
		}
		// 배열을 정렬해준다
		Arrays.sort(divisor);
		// 가장 큰 약수와 가장 작은 약수의 곱이 원래 숫자이므로
		// 정렬되어 있는 배열에서 가장 앞의 숫자와 가장 뒤의 숫자를 곱하여 답을 구한다.
		System.out.println(divisor[0]*divisor[N-1]);
	}

}
