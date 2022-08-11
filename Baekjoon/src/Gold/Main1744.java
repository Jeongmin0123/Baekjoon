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
		
		// ����� ���۵Ǵ� idx
		int idx = 0;
		for(int i = 0 ; i < N ; i++) {
			if(arr[i] > 0) {
				idx = i;
				break;
			}
		}
		
		// ������ 1�� ������ idx
		int idx_1 = -1;
		for(int i = idx ; i < N ; i++) {
			if(arr[i] == 1) {
				idx_1 = i;
			} else {
				break;
			}
		}
		// ������ 0�� ����
		int minus = idx;
		
		// ����� ����
		int plus = N - idx;
		long result = 0;
		
		// ������ �ִ��� ���� �������� ���밪�� ū �ͳ��� ���� ����� �Ѵ�.
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
		
		// ����� �ִ��� ���� ��� ����� ���� �����ϴ�
		// ����� 1�� ���ԵǾ� �ִ� ���, ���� ��� 1*2���� 1+2�� �� ũ�Ƿ� 1�϶��� ��ġ�� �ʰ� ������� �Ѵ�.
		// ���� ����� 1�� ���Ե� ���� ���Ե��� �ʴ� ���� ������ ������ �ذ��ؾ� �Ѵ�.
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
