package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14002 {
	public static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// arr에는 숫자의 배열을, dp에는 증가하는 부분 수열의 순서를 저장한다.
		int[] dp = new int[N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = 0 ; j <= i ; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		// 증가하는 부분 수열의 길이를 구한다.
		int max = 1;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		int idx = max;
		int[] result = new int[max];
		// 숫자 배열의 뒤부터 idx가 큰 값을 하나씩 추출하여 증가하는 부분 수열에 존재하는 숫자들을 구한다.
		for(int i = N-1 ; i >= 0 ; i--) {
			if(idx == dp[i]) {
				result[idx-1] = arr[i];
				idx--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < result.length ; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}
}