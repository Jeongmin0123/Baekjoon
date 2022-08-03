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
		
		// arr���� ������ �迭��, dp���� �����ϴ� �κ� ������ ������ �����Ѵ�.
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
		// �����ϴ� �κ� ������ ���̸� ���Ѵ�.
		int max = 1;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		int idx = max;
		int[] result = new int[max];
		// ���� �迭�� �ں��� idx�� ū ���� �ϳ��� �����Ͽ� �����ϴ� �κ� ������ �����ϴ� ���ڵ��� ���Ѵ�.
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