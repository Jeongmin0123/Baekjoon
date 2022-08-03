package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 표의 크기와 연산 횟수를 받아온다.
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		// 같은 행에 존재하는 숫자들의 누적합을 배열에 저장한다.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			for(int j = 1 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j-1];
			}
		}
		// 누적합의 차를 통해서 구간의 합을 구한다.
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j = y1 - 1 ; j < y2 ; j++) {
				if(x1 > 1) {
					sum += map[j][x2-1] - map[j][x1-2];
				} else {
					sum += map[j][x2-1] - map[j][x1-1]+map[j][x1-1];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}

}
