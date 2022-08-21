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
			// �Է¹��� ���� maxdp�� mindp�� �ֱ� ���� �ӽ������� �����Ѵ�.
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			if (i == 0) {
				// �� ù���� �Է¹��� �� �״�� �����Ѵ�.
				maxdp[i][0] = mindp[i][0] = x1;
				maxdp[i][1] = mindp[i][1] = x2;
				maxdp[i][2] = mindp[i][2] = x3;
			} else {
				// i��° ���� ���� �� ������ ���� i-1��° �� ���� �޾ƿ� ���� ������ �ڿ� ���Ͽ� ���� ū ���� ���� ���� ���� �־��ش�.
				// �̶�, ������ ����Ͽ� max, min ���� ���Ѵ�.
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
