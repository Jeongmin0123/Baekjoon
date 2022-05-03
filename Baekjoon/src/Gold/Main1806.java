package Gold;

import java.util.Scanner;

public class Main1806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] num = new int[N];
		// N의 범위가 10보다 크거나 같고 100000보다 작으므로 변수 answer의 초기값을 100001로 둔다
		// 이후, 연산이 끝났을 때 answer이 100001이면 불가능한 경우이므로 0을 출력한다.
		int answer = 100001;
		for(int i = 0 ; i < N ; i++) {
			num[i] = sc.nextInt();
		}
		// 구간의 앞부터 뒤까지의 합
		int sum = 0;
		// 구간의 시작점
		int start = 0;
		// 구간의 끝나는 점
		int end = 0;
		while(true) {
			// 조건을 만족하는 경우
			if(sum >= S) {
				// 시작점을 한칸 전진시킨다
				sum -= num[start];
				// 저장되어 있는 구간과 조건을 만족하는 구간중 더 작은 값을 저장한다.
				answer = Math.min(answer, (end - start));
				start++;
				// 끝나는 점이 끝 지점에 도달하면 종료한다.
			} else if(end == N) {
				break;
			} else {
				// 조건을 만족하지 못하므로 구간을 늘려준다.
				sum += num[end];
				end++;
			}
		}
		if(answer == 100001) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
		sc.close();
	}

}