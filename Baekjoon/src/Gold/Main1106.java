package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1106 {
	// 비교값으로 C가 1000보다 작거나 같고 각 도시의 홍보 비용은 100보다 작거나 같으므로
	// 드는 비용의 최대값은 100000이다. 따라서 이것보다 큰 수를 비교군으로 설정하면 된다.
	static final int comparison = 999999999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		// 아래의 배열은 i명을 홍보할 때 드는 최소비용을 넣을 배열이므로
		// 이 때, 우리는 적어도 C명이 궁금하므로 C+1을 배열의 크기로 설정한 뒤에,
		// 각 도시에서 홍보할 수 있는 고객의 수는 100이하이므로 C+101까지 배열의 크기를 늘린다.
		int[] min = new int[C+101];
		Arrays.fill(min, comparison);
		// 0명을 유치하는 비용은 0이다.
		min[0] = 0;
		for(int i = 0 ; i < N ; i++) {
			// 비용
			int cost = sc.nextInt();
			// 비용에 따른 유치인원
			int customer = sc.nextInt();
			// 각각의 경우에서 유치 인원은 customer부터 시작한다.
			for(int j = customer ; j < C+101 ; j++) {
				min[j] = Math.min(min[j], cost + min[j-customer]);
			}
		}
		
		int result = comparison;
		for(int i = C ; i < C+101 ; i++) {
			result = Math.min(min[i], result);
		}
		System.out.println(result);
		sc.close();
	}
}