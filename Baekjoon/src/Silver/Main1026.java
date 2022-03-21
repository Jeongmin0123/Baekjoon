package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] A = new int[T];
		int[] B = new int[T];
		for(int i = 0 ; i < T ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < T ; i++) {
			B[i] = sc.nextInt();
		}
		// A 배열과 B 배열을 각각 정렬한다.
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i = 0 ; i < T ; i++) {
			// A 배열의 가장 작은 값과 B 배열의 가장 큰 값을 순서대로 곱하여 더해준다.
			sum += A[i]*B[T-i-1];
		}
		System.out.println(sum);
	}
}
