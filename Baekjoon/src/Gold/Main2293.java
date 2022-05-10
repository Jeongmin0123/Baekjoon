package Gold;

import java.util.Scanner;

public class Main2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// i 원을 만들기 위한 방법을 저장할 배열
		int[] way = new int[K+1];
		// 덧셈에 대한 항등원을 1로 둔다.
		way[0] = 1;
		// 연산 때마다 새로운 동전을 받아온다.
		// 첫 번째 for문 연산에서는 한 가지 동전으로만, 두 번째에서는 2가지, .... n번째에서는 n개의 동전으로 k원을 만든다.
		for(int i = 0 ; i < N ; i++) {
			int coin = sc.nextInt();
			for(int j = 1 ; j <= K ; j++) {
				if(j >= coin) {
					way[j] += way[j - coin];
				}
			}
		}
		System.out.println(way[K]);
	}

}
