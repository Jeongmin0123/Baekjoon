package Silver;

import java.util.Scanner;

public class Main1012 {
	// 밑의 변수들은 dfs_count 함수에서 한번 main 함수에서 한번, 총 두번 사용하므로 전역변수로 선언한다.
	public static int m;
	public static int n;
	public static boolean map[][];
	public static boolean visited[][];
	// 상, 하, 좌, 우 순으로 x,y좌표의 변화에 대한 배열을 생성한다.
	public static int[] dx = {0, 0, -1, 1}; 
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 결과값을 저장하는 배열
		int results[] = new int[T];
		for(int i = 0 ; i < T ; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int K = sc.nextInt();
			// 실제 배추들의 배치에 관련된 2차원 배열로 1일 경우 true, 0일경우 false 이므로 boolean 타입으로 생성해주었다.
			map = new boolean[m][n];
			// 배추가 연결되어 있는 경우 dfs_count함수에 의하여 연결되어 있는 곳은 방문되므로 map의 방문여부에 대한 2차원 배열을 생성해준다.
			// 이 때, true일 경우 방문한 상태, false가 방문하지 않은 상태이다.
			visited = new boolean[m][n];
			for(int j = 0 ; j < K ; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				// 배추가 있는 곳은 true로 값을 지정해준다.
				map[a][b] = true;
			}
			int result = 0;
			for(int a = 0 ; a < m ; a++) {
				for(int b = 0 ; b < n ; b++) {
					// 배추가 있으면서 방문을 하지 않은 경우에만 result값을 증가시켜주고, 그 위치의 방문값을 true로 바꿔준 후에 dfs_count 함수를 시행한다.
					if(map[a][b] && !visited[a][b]) {
						result++;
						visited[a][b] = true;
						dfs_count(a, b);
					}
				}
			}
			results[i] = result;
		}
		for(int i = 0 ; i < T ; i++) {
			System.out.println(results[i]);
		}
		sc.close();
	}
	// 배추가 있는 지점의 상하좌우에 배추가 있는지 탐색해서 있는 경우에 연결된 배추를 하나로 보도록하는 함수 
	public static void dfs_count(int x, int y) {
		int nx;
		int ny;
		// 상하좌우 4방면을 알아야하므로 for문을 4번 시행한다.
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 움직였을 때 생성된 2차원 배열 안에 존재해야 한다.
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				// 움직인 곳에 배추가 존재하고 방문한 적이 없으면 그 위치의 방문값을 true로 바꿔주고 다시 움직인 곳 상하좌우에 배추가 있는지 탐색한다.
				if(map[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs_count(nx,ny);
				}
			}
		}
		
	}


}
