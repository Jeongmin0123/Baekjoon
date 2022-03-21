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
		// A �迭�� B �迭�� ���� �����Ѵ�.
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i = 0 ; i < T ; i++) {
			// A �迭�� ���� ���� ���� B �迭�� ���� ū ���� ������� ���Ͽ� �����ش�.
			sum += A[i]*B[T-i-1];
		}
		System.out.println(sum);
	}
}
