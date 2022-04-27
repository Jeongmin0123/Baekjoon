package Gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main16936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 어떠한 숫자와 그 숫자를 인수분해 했을 때, 3의 개수를 저장한다.
		long[][] arr = new long[N][2];		
		for(int i=0; i<N; i++) {
			arr[i][1] = sc.nextLong();
			long n = arr[i][1];
			while(true) {
				if(n % 3 == 0) {
					arr[i][0]++;
					n /= 3;
				} else {
					break;
				}
			}
		}
		// 3의 지수가 큰 순서대로 정렬하되, 만약 3의 지수가 같으면 작은 숫자가 앞에 오도록 정렬한다.
		Arrays.sort(arr, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					// 0번째 인덱스가 같으면, 1번째 인덱스로 오름차순
					return Long.compare(o1[1], o2[1]);
				}
				else {
					// 0번째 인덱스로 내림차순
					return Long.compare(o2[0], o1[0]);
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i][1]+" ");
		}		
		sc.close();
	}
	

}
