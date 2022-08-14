package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16927 {

	public static int N,M,R;
	public static int[][] map;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// ���� �Է¹޴´�.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ȸ���ؾ� �� �簢���� ����
		int square = Math.min(N, M)/2;
		int n = N;
		int m = M;
		for(int i = 0 ; i < square ; i++) {
			rotation(i,2*n + 2*m - 4);
			n -= 2;
			m -= 2;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// �������� �ѹ����� �� ������ �� ���� ������ �޾ƿ� �迭�� ȸ����Ű�� �޼���
	public static void rotation(int start,int square) {
		int rotate = R%square;
		for(int i = 0 ; i < rotate ; i++) {
			int a = start;
			int b = start;
			int temp = map[a][b];
			int dir = 0;
			while(dir < 4) {
				int x = a + dx[dir];
				int y = b + dy[dir];
				if(x >= start && y >= start && x < N - start && y < M - start) {
					map[a][b] = map[x][y];
					a = x;
					b = y;
				} else {
					dir++;
				}
			}
			map[start+1][start] = temp;
		}
	}
}
