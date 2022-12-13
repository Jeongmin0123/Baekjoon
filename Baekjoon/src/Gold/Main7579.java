package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7579 {

	public static int N, M, result;
	public static int[] bites;
	public static int[] prices;
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		bites = new int[N];
		prices = new int[N];
		// N�� 100�����̰� ������ ��뵵 100 �����̹Ƿ� ���� �� �ִ� �ִ����� 10000�̹Ƿ� �̸� ����Ͽ� dp�迭�� �����Ѵ�.
		dp = new int[N][10001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			bites[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		// ���� �ϳ��� ��� �ʱ�ȭ�� ���ش�.
		for(int j = 0 ; j < 10001 ; j++) {
			int bite = bites[0];
			int price = prices[0];
			// ���� ���� �� �����뺸�� ��밡���� ����� ���� ��� �� �� ��Ȱ��ȭ ������ �޸𸮾��� �ʱ�ȭ�Ѵ�.
			if(j >= price) {
				dp[0][j] = bite;
			}
			// �� ���� ���� �������� ��, M ����Ʈ�� Ȯ���ߴٸ� �׶��� ���� result �� ���Ͽ� result�� �ʱ�ȭ�Ѵ�.
			if(dp[0][j] >= M) result = Math.min(result, j);
		}
		for(int i = 1 ; i < N ; i++) {
			int bite = bites[i];
			int price = prices[i];
			for(int j = 0 ; j < 10001 ; j++) {
				// ���� ���� �� �����뺸�� ��밡���� ����� ���� ��� �� �� ��Ȱ��ȭ ������ �޸𸮾��� �ʱ�ȭ�Ѵ�.
				if(j >= price) {
					dp[i][j] = Math.max(dp[i-1][j-price] + bite, dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				// �� ���� ���� �������� ��, M ����Ʈ�� Ȯ���ߴٸ� �׶��� ���� result �� ���Ͽ� result�� �ʱ�ȭ�Ѵ�.
				if(dp[i][j] >= M) result = Math.min(result, j);
			}
		}
		System.out.println(result);
	}

}
