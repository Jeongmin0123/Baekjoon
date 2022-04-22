package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1520 {
	public static int[][] count;
	public static int[][] arr;
	public static int M;
	public static int N;
	public static int[] rangeX = {1, 0,-1, 0};
	public static int[] rangeY = {0, 1, 0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M+1][N+1];
		count = new int[M+1][N+1];
		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				arr[i][j] = sc.nextInt();
				count[i][j] = -1;
			}
		}
		int result = check(1,1);
		System.out.println(result);
		
		
	}
	
	public static int check(int x, int y) {
		// 원하는 지점에 도착시에 1을 반환하고 종료한다.
		// 추가로 다시 움직일 필요가 없기 때문이다.
		if(x == M && y == N) {
			return 1;
		}
		// -1이 아닌 경우 이미 방문한 경우이므로 전에 방문했을 때의
		// 값을 반환한다.
		if(count[x][y] != -1) {
			return count[x][y];
		} else {
			count[x][y] = 0;
			// 상하좌우 움직인다.
			for(int i = 0 ; i < 4 ; i++) {
				int dx = x + rangeX[i];
				int dy = y + rangeY[i];
				// 움직일 수 없는 구간일 경우 넘어간다.
				if(dx < 1 || dy < 1 || dx > M || dy > N) {
					continue;
				}
				// 만약 움직인 부분의 숫자가 더 작다면,
				// 경로의 수에 추가한다.
				if(arr[x][y] > arr[dx][dy]) {
					count[x][y] += check(dx,dy);
				}
			}
		}
		
		return count[x][y];
	}

}
