package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1931 {
	// 필요한 변수 선언
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int numofapart = 0;
	public static int apart[] = new int[25*25];
	public static int[][] map;
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			String s = sc.next();
			for(int j = 0 ; j < s.length() ; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 방문한 적 없고, 집이 존재하면 dfs 함수를 실행한다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					numofapart++;
				}
			}
		}
		System.out.println(numofapart);
		Arrays.sort(apart);
		for(int i = 0 ; i < apart.length ; i++) {
			if(apart[i] != 0) {
				System.out.println(apart[i]);
			} else {
				continue;
			}
		}
		sc.close();
	}
	
	//4 방면에 건물이 존재하는지 확인하는 함수, 존재하는 경우 그 건물에서 다시 4방면을 조사하며 동시에 그 단지의 집 개수를 1개 증가시킨다.
	public static void dfs(int i, int j) {
		apart[numofapart]++;
		visited[i][j] = true;
		for(int k = 0 ; k < 4 ; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visited[x][y] && map[x][y] == 1) {
				dfs(x, y);
			}
		}
	}

}
