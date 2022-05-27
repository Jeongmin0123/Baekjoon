package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 좌표를 저장하는 class
class dot{
	int x;
	int y;
	dot(int x,int y) {
		this.x = x;
		this.y = y;
  	}
}

public class Main7576 {
	public static int[] dx = { 0, 0, 1,-1};
	public static int[] dy = {-1, 1, 0, 0};
	public static int M;
	public static int N;
	public static Queue<dot> cal;
	public static int[][] tomato;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		tomato = new int[N][M];
		// 토마토가 익은 지점의 좌표를 저장하는 queue
		cal = new LinkedList<dot>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				tomato[i][j] = sc.nextInt();
				// 만약 토마토가 익었다면 queue에 추가한다.
				if(tomato[i][j] == 1) {
					cal.add(new dot(i,j));
				}
			}
		}
		System.out.println(dfs());
	}
	// 모두 익을 때까지의 최소 날짜를 출력하는 함수
	public static int dfs() {
		while(!cal.isEmpty()) {
			// 익은 토마토의 위치를 받는다.
			dot temp = cal.remove();
			// 익은 토마토의 상하좌우에 익지않은 토마토가 있는지 확인한다.
			for(int i = 0 ; i < 4 ; i++) {
				int new_x = temp.x + dx[i];
				int new_y = temp.y + dy[i];
				if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < M) {
					// 상하좌우에 익지않은 토마토가 있는 경우 queue 추가하고 언제 익었는지 알기 위해서
					// 영향을 준 토마토의 값에 1을 더한다.
					if(tomato[new_x][new_y] == 0) {
						cal.add(new dot(new_x, new_y));
						tomato[new_x][new_y] = tomato[temp.x][temp.y]+1;
					}
				}
			}
		}
		int result = -1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(tomato[i][j] == 0) {
					return -1;
				} else {
					result = Math.max(result, tomato[i][j]);
				}
			}
		}
		return result - 1;
	}	
}