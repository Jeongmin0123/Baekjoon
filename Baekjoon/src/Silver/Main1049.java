package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 6�� ������ ���ݿ� ���� ���� �迭�� �����´�.
		int[] six_price = new int[M];
		// 1�� ������ ���ݿ� ���� ���� �迭�� �����´�.
		int[] one_price = new int[M];
		for(int i = 0 ; i < M ; i++) {
			six_price[i] = sc.nextInt();
			one_price[i] = sc.nextInt();
		}
		// ������ �迭�� �ּڰ��� ���ϱ� ���Ͽ� �迭���� �����Ѵ�.
		Arrays.sort(six_price);
		Arrays.sort(one_price);
		int price = Math.min(six_price[0]*(N/6) + Math.min(six_price[0], one_price[0]*(N%6)), one_price[0]*N);
		System.out.println(price);
	}

}
