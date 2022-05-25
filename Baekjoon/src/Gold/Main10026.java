package Gold;

import java.util.Scanner;

public class Main10026 {
	// 좌우상하 움직임에 대한 x,y값으 변화
	public static int[] dx = {1,-1, 0, 0};
	public static int[] dy = {0, 0,-1, 1};
	public static char[][] domain;
	public static boolean[][] visited;
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		domain = new char[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			String temp = sc.next();
			for(int j = 0 ; j < N ; j++) {
				domain[i][j+1] = temp.charAt(j);
			}
		}
		int normal = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					normal++;
				}
			}
		}
		visited = new boolean[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(domain[i][j] == 'G') {
					domain[i][j] = 'R';
				}
			}
		}
		int color = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					color++;
				}
			}
		}
		System.out.println(normal + " " + color);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			if(new_x < 1 || new_x > N || new_y < 1 || new_y > N) {
				continue;
			}
			if(!visited[new_x][new_y] && domain[x][y] == domain[new_x][new_y]) {
				dfs(new_x, new_y);
			}
		}
	}

}
