package Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		// 내장함수로써 배열을 오름차순으로 정렬해주는 Arrays.sort 함수를 사용하였다.
		Arrays.sort(arr);
		
		for(int v : arr) {
			System.out.println(v);
		}
		sc.close();
	}
	

}
