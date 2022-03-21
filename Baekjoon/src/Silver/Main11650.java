package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main11650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 2차원 좌표이므로 2차원 배열을 생성해준다.
		int[][] arr = new int[N][2];
		for(int i = 0; i < N ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		// 람다식을 이용하여 sort 메서드의 comparator를 오버라이드 하여 정렬을 진행한다.
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0 ; i < N ; i ++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		sc.close();
	}

}
