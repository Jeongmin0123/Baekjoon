package Silver;

import java.util.Scanner;

public class Main1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		sum_check(N,L);
	}
	// 수열의 합을 반환하는 함수
	public static void sum_check(int N, int L) {
		// L이 2보다 크고 100보다 작거나 같으므로
		// 첫번째 for문은 L이 2보다 크고 100보다 작거나 같기 때문에 2부터 100까지 수행한다.
		for(int i = L ; i <= 100 ; i++) {
			// 합이 N이면서 길이가 i인 수열의 첫째 항을 a라고 두면
			// a*i + i*(i-1)/2 = N라는 식을 얻을 수 있다.
			// 따라서 a는 a*i + i*(i-1)/2 <= N인 범위까지 증가시켜가며 연산을 진행한다.
			for(int a = 0 ; a*i + i*(i-1)/2 <= N ; a++) {
				// 만약 a*i + i*(i-1)/2 == N일 경우, 우리가 구하는 숫자의 배열이므로
				// print 후에 연산을 종료한다.
				if(a*i + i*(i-1)/2 == N) {
					for(int k = 0 ; k < i ; k++) {
						System.out.print(a+k + " ");
					}
					return;
				} 
					
			}
		}
		// 위 연산에서 걸리지 않은 경우 만족하는 리스트가 없는 경우이므로 -1을 반환한다.
		System.out.println(-1);
	}
}
