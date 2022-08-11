package Gold;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main1744 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		
		// 양수가 시작되는 idx
		int idx = 0;
		for(int i = 0 ; i < N ; i++) {
			if(arr[i] > 0) {
				idx = i;
				break;
			}
		}
		
		// 마지막 1이 가지는 idx
		int idx_1 = -1;
		for(int i = idx ; i < N ; i++) {
			if(arr[i] == 1) {
				idx_1 = i;
			} else {
				break;
			}
		}
		// 음수와 0의 개수
		int minus = idx;
		
		// 양수의 개수
		int plus = N - idx;
		long result = 0;
		
		// 음수로 최대의 합을 얻으려면 절대값이 큰 것끼리 곱을 해줘야 한다.
		if(minus % 2 == 0) {
			for(int i = 0 ; i < idx - 1 ; i+=2) {
				result += arr[i]*arr[i+1];
			}
		} else {
			for(int i = 0 ; i < idx - 2 ; i+=2) {
				result += arr[i]*arr[i+1];
			}
			result += arr[idx-1];
		}
		
		// 양수로 최대의 합을 얻는 방식은 조금 복잡하다
		// 양수에 1이 포함되어 있는 경우, 예를 들어 1*2보다 1+2가 더 크므로 1일때는 합치지 않고 더해줘야 한다.
		// 따라서 양수에 1이 포함된 경우와 포함되지 않는 경우로 나누어 문제를 해결해야 한다.
		if(idx_1 == -1) {
			if(plus % 2 == 0) {
				for(int i = idx ; i < N - 1 ; i+=2) {
					result += arr[i]*arr[i+1];
				}
			} else {
				for(int i = idx + 1 ; i < N - 1 ; i+=2) {
					result += arr[i]*arr[i+1];
				}
				result += arr[idx];
			}
		} else {
			if((plus - idx_1 + idx - 1) % 2 == 0) {
				for(int i = idx_1 + 1 ; i < N - 1 ; i+=2) {
					result += arr[i]*arr[i+1];
				}
			} else {
				for(int i = idx_1 + 2 ; i < N - 1 ; i+=2) {
					result += arr[i]*arr[i+1];
				}
				result += arr[idx_1+1];
			}
			for(int i = idx ; i < idx_1+1 ; i++) {
				result += 1;
			}
		}
		System.out.println(result);
		sc.close();
	}

}
