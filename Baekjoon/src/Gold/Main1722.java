package Gold;

import java.util.Scanner;

public class Main1722 {
	// 1~20 까지의 숫자가 사용되었는지 안 되었는지 판단하는 배열
	public static boolean[] used = new boolean[21];
	// 0!~20! 까지를 저장하는 배열
	public static long[] fib = new long[21];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		// 0! ~ 20!을 계산하여 배열에 넣어준다.
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
	// case1 : k번째 수열을 나타내는 N개의 수를 반환하는 메서드
	public static int[] case1(long a, int n) {
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				// 만약 j가 사용된 숫자면 다음 숫자로 넘어간다.
				if(used[j]) continue;
				// a 가 fib[n-1-i]보다 큰 경우 이 값을 계속 빼서 a를 작게 만들어준다.
				if(fib[n-1-i] < a) {
					a -= fib[n-1-i]; 
				} else {
					// a 가 fib[n-1-i]보다 작아진 경우 배열의 i 번째 숫자가
					// j가 되어야 하고, 이 경우 j를 사용했으므로 used[j]를 true로 바꿔준다.
					arr[i] = j;
					used[j] = true;
					// 배열의 i+1 번째 숫자를 계산하기 위하여 break 한다.
					break;
				}
			}
		}
		return arr;
	}
	
	// case2 : 받아온 수열이 몇 번째 수열인지 반환하는 메서드
	public static long case2(int[] arr) {
		// 1부터 N!까지이므로 시작 숫자를 1로 지정한다.
		long result = 1;
		for(int i = 0 ; i < arr.length ; i++) {
			// j는 1부터 배열의 i번째 숫자보다 작을 때까지 j를 사용하지 않았으면 (arr.length - i - 1)를 더한다
			// 그 이유는 i번째 숫자를 정하는 방법은 arr.length - i - 1에 j를 곱하는 것이기 때문이다.
			for(int j = 1 ; j < arr[i] ; j++) {
				if(!used[j]) result += fib[arr.length - i - 1];
			}
			used[arr[i]] = true;
		}
		return result;
	}
	// factorial를 반환하는 메서드
	public static void fac() {
		fib[0] = 1;
		fib[1] = 1;
		for(int i = 2 ; i < 21 ; i++) {
			fib[i] = fib[i-1]*i;
		}
	}
}