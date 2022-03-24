package Silver;

import java.util.Scanner;

public class Main1072 {
	/*// 시간초과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		double result = Y*100.0/X;
		int Z = (int) Math.floor(result);
		int count = 0;
		while(Z >= Math.floor(Y*100.0/X)) {
			if(Z >= 99) {
				count = -1;
				break;
			}
			count++;
			X++;
			Y++;
		}
		System.out.println(count);
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		long Y = sc.nextLong();
		long Z = (Y*100)/X;
		// Z가 99보다 크거나 같으면 아무리 횟수를 많이해도 100프로 그 이상이 될 수 없으므로 -1을 출력
		if(Z>=99) {
			System.out.println(-1);
		} else {
			// Y값의 범위가 0부터 X까지 이므로 시작값음 0 끝값을 1000000000로 둔다.
			long start = 0;
			long mid = 0;
			long end = 1000000000;
			// 시작점이 끝값보다 큰 지점까지만 계산수행
			while(start <= end) {
				// 중간값을 시작과 끝값의 중간으로 잡는다.
				mid = (start+end)/2;
				if(Z < 100*(Y+mid)/(X+mid)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			// 최소값을 출력해야 하므로 start를 출력한다.
			System.out.println(start);
		}
	}

}
