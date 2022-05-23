package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5557 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 2���� �迭���� ù ��° �迭���� �̿��� ���ڱ����� �ε���, �� ��° �迭�� ���� �տ� ���� �����̴�.
		long dp[][] = new long[N][21];
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 0��° index�� arr[0]�� ����� ����� 1�����̴�.
		dp[0][arr[0]]++;
		for(int i = 1 ; i < N -1 ; i++) {
			for(int j = 0 ; j<21 ; j++ ) {
				// i��° ���ڸ� ���� �� 0���� ũ��, �� �������� ���ڵ�� j-arr[i]�� ����� ������ �����ش�.
				// �� ���ڿ��� arr[i]�� ���ϸ� �ᱹ j �̹Ƿ�
				if(j-arr[i] >= 0)
					dp[i][j]+=dp[i-1][j-arr[i]];
				// i��° ���ڸ� ������ �� 0���� ũ��, �� �������� ���ڵ�� j+arr[i]�� ����� ������ �����ش�.
				// �� ���ڿ��� arr[i]�� ���� �ᱹ j �̹Ƿ�
				if(j+arr[i] <21)
					dp[i][j]+=dp[i-1][j+arr[i]];
			}
		}
		// N - 1 ���� ���ڷ� N��° ���ڸ� ����� ����� ���� ���Ѵ�.
		System.out.println(dp[N-2][arr[N-1]]);
	}
}