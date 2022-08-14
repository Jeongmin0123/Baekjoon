package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16926 {

	public static int[][] arr;
	public static int N,M,R;
	// 우 상 좌 하
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		R  = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전시켜야 할 사각형의 개수
		int square = Math.min(N, M)/2;
		for(int i = 0 ; i < R ; i++) {
			Rotation(square);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 회전시켜야 할 사각형의 개수를 받아와 배열을 회전시키는 메서드
	public static void Rotation(int square) {
		for(int i = 0 ; i < square ; i++) {
			// 시작점을 각 사각형의 왼쪽 맨위로 둔다.
			int dir = 0;
			int a = i;
			int b = i;
			int temp = arr[a][b];
			while(dir < 4) {
				int x = a + dx[dir];
				int y = b + dy[dir];
				
				// 이동한 점이 사각형 변 위에 있는 경우 연산을 진행하고 아니면 방향을 바꾼다.
				if(x >= i && y >= i && x < N - i && y < M - i) {
					arr[a][b] = arr[x][y];
					a = x;
					b = y;
				} else {
					dir++;
				}
			}
			arr[i+1][i] = temp;
		}
	}
}
