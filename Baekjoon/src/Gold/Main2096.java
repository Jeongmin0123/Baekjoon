package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2096 {

	public static int[][] maxdp;
	public static int[][] mindp;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maxdp = new int[N][3];
		mindp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 입력받은 값을 maxdp와 mindp에 넣기 전에 임시적으로 저장한다.
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			if (i == 0) {
				// 맨 첫줄은 입력받은 값 그대로 저장한다.
				maxdp[i][0] = mindp[i][0] = x1;
				maxdp[i][1] = mindp[i][1] = x2;
				maxdp[i][2] = mindp[i][2] = x3;
			} else {
				// i번째 줄의 값은 그 전까지 줄인 i-1번째 줄 값에 받아온 값을 더해준 뒤에 비교하여 가장 큰 값과 작은 값을 각각 넣어준다.
				// 이때, 방향을 고려하여 max, min 값을 비교한다.
				maxdp[i][0] = Math.max(maxdp[i-1][0] + x1, maxdp[i-1][1] + x1);
				maxdp[i][1] = Math.max(Math.max(maxdp[i-1][0] + x2, maxdp[i-1][1] + x2), maxdp[i-1][2] + x2);
				maxdp[i][2] = Math.max(maxdp[i-1][1] + x3, maxdp[i-1][2] + x3);
				
				mindp[i][0] = Math.min(mindp[i-1][0] + x1, mindp[i-1][1] + x1);
				mindp[i][1] = Math.min(Math.min(mindp[i-1][0] + x2, mindp[i-1][1] + x2), mindp[i-1][2] + x2);
				mindp[i][2] = Math.min(mindp[i-1][1] + x3, mindp[i-1][2] + x3);
			}
		}
		
		int max = Math.max(Math.max(maxdp[N-1][0], maxdp[N-1][1]), maxdp[N-1][2]);
		int min = Math.min(Math.min(mindp[N-1][0], mindp[N-1][1]), mindp[N-1][2]);
		System.out.println(max + " " + min);
	}

}
