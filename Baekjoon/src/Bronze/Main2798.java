package Bronze;

import java.util.Scanner;

public class Main2798 {
	public static void main(String[] args) {
		// scanner를 이용하여 카드 수와 합을 받아온다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// 카드 수만큼의 배열을 선언하여 그 배열에 각각 카드에 쓰여있는 숫자를 받아온다.
		int[] arr = new int[n];
		for(int i = 0;i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 합을 받아오는 함수를 이용하여 결과를 출력한다.
		System.out.println(search(arr, n, m));
		sc.close();
	}
	// M에 최대한 가까운 카트 3장의 합을 출력하는 함수
	public static int search(int[] arr, int n, int m) {
		int result = 0;
		// 첫 번째 카드는 뒤의 카드가 2장 존재하므로 n-2번째 카드까지만 반복문을 실행한다.
		for(int i = 0; i<n-2; i++) {
			// 마찬가지로 두 번째 카드는 앞에 카드가 1장, 뒤에 카드가 1장 존재하므로 2번째부터 n-1번째 카드까지만 반복문을 실행한다.
			for(int j = i+1; j<n-1; j++) {
				// 마지막으로 마지막 카드는 앞에 2장의 카드가 존재하므로 3번째부터 n번째 카드까지만 반복문을 실행한다.
				for(int k = j+1; k<n; k++) {
					// 3개의 카드의 합을 시행마다 temp 변수로 저장한다.
					int temp = arr[i] + arr[j] + arr[k];
					// 만약 temp 변수가 m과 같다면 출력한다.
					if(m == temp) {
						return temp;
					}
					// 만약 temp변수가 result보다 크고 m보다 작으면 result에 저장한 후 시행을 계속한다.
					if(result < temp && temp < m) {
						result = temp;
					}
				}
			}
		}
		return result;
	}
}
