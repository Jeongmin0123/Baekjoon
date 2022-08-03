package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// ǥ�� ũ��� ���� Ƚ���� �޾ƿ´�.
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		// ���� �࿡ �����ϴ� ���ڵ��� �������� �迭�� �����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			for(int j = 1 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j-1];
			}
		}
		// �������� ���� ���ؼ� ������ ���� ���Ѵ�.
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
