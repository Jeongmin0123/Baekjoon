package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5557 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 2차원 배열에서 첫 번째 배열값은 이용한 숫자까지의 인덱스, 두 번째 배열은 만든 합에 대한 숫자이다.
		long dp[][] = new long[N][21];
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 0번째 index로 arr[0]을 만드는 방법은 1가지이다.
		dp[0][arr[0]]++;
		for(int i = 1 ; i < N -1 ; i++) {
			for(int j = 0 ; j<21 ; j++ ) {
				// i번째 숫자를 뺐을 때 0보다 크면, 그 전까지의 숫자들로 j-arr[i]를 만드는 경우수를 더해준다.
				// 이 숫자에서 arr[i]를 더하면 결국 j 이므로
				if(j-arr[i] >= 0)
					dp[i][j]+=dp[i-1][j-arr[i]];
				// i번째 숫자를 더했을 때 0보다 크면, 그 전까지의 숫자들로 j+arr[i]를 만드는 경우수를 더해준다.
				// 이 숫자에서 arr[i]를 빼면 결국 j 이므로
				if(j+arr[i] <21)
					dp[i][j]+=dp[i-1][j+arr[i]];
			}
		}
		// N - 1 개의 숫자로 N번째 숫자를 만드는 방법의 수를 구한다.
		System.out.println(dp[N-2][arr[N-1]]);
	}
}