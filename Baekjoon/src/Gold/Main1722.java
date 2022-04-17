package Gold;

import java.util.Scanner;

public class Main1722 {
	// 1~20 ������ ���ڰ� ���Ǿ����� �� �Ǿ����� �Ǵ��ϴ� �迭
	public static boolean[] used = new boolean[21];
	// 0!~20! ������ �����ϴ� �迭
	public static long[] fib = new long[21];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		// 0! ~ 20!�� ����Ͽ� �迭�� �־��ش�.
		fac();
		if(t == 1) {
			long a = sc.nextLong();
			int[] arr = case1(a,n);
			for(int i = 0 ; i < arr.length ; i++) {
				System.out.print(arr[i] + " ");
			}
		} else if(t == 2) {
			int[] arr = new int[n];
			for(int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			long result = case2(arr);
			System.out.println(result);
		}
	}
	// case1 : k��° ������ ��Ÿ���� N���� ���� ��ȯ�ϴ� �޼���
	public static int[] case1(long a, int n) {
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				// ���� j�� ���� ���ڸ� ���� ���ڷ� �Ѿ��.
				if(used[j]) continue;
				// a �� fib[n-1-i]���� ū ��� �� ���� ��� ���� a�� �۰� ������ش�.
				if(fib[n-1-i] < a) {
					a -= fib[n-1-i]; 
				} else {
					// a �� fib[n-1-i]���� �۾��� ��� �迭�� i ��° ���ڰ�
					// j�� �Ǿ�� �ϰ�, �� ��� j�� ��������Ƿ� used[j]�� true�� �ٲ��ش�.
					arr[i] = j;
					used[j] = true;
					// �迭�� i+1 ��° ���ڸ� ����ϱ� ���Ͽ� break �Ѵ�.
					break;
				}
			}
		}
		return arr;
	}
	
	// case2 : �޾ƿ� ������ �� ��° �������� ��ȯ�ϴ� �޼���
	public static long case2(int[] arr) {
		// 1���� N!�����̹Ƿ� ���� ���ڸ� 1�� �����Ѵ�.
		long result = 1;
		for(int i = 0 ; i < arr.length ; i++) {
			// j�� 1���� �迭�� i��° ���ں��� ���� ������ j�� ������� �ʾ����� (arr.length - i - 1)�� ���Ѵ�
			// �� ������ i��° ���ڸ� ���ϴ� ����� arr.length - i - 1�� j�� ���ϴ� ���̱� �����̴�.
			for(int j = 1 ; j < arr[i] ; j++) {
				if(!used[j]) result += fib[arr.length - i - 1];
			}
			used[arr[i]] = true;
		}
		return result;
	}
	// factorial�� ��ȯ�ϴ� �޼���
	public static void fac() {
		fib[0] = 1;
		fib[1] = 1;
		for(int i = 2 ; i < 21 ; i++) {
			fib[i] = fib[i-1]*i;
		}
	}
}