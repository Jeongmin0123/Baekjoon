package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 6개 묶음의 가격에 대한 값을 배열로 가져온다.
		int[] six_price = new int[M];
		// 1개 낱개의 가격에 대한 값을 배열로 가져온다.
		int[] one_price = new int[M];
		for(int i = 0 ; i < M ; i++) {
			six_price[i] = sc.nextInt();
			one_price[i] = sc.nextInt();
		}
		// 각각의 배열의 최솟값을 구하기 위하여 배열들을 정렬한다.
		Arrays.sort(six_price);
		Arrays.sort(one_price);
		int price = Math.min(six_price[0]*(N/6) + Math.min(six_price[0], one_price[0]*(N%6)), one_price[0]*N);
		System.out.println(price);
	}

}
