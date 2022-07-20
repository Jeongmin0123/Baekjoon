package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1931 {
	// �ʿ��� ���� ����
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
		
		// �湮�� �� ����, ���� �����ϸ� dfs �Լ��� �����Ѵ�.
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
	
	//4 ��鿡 �ǹ��� �����ϴ��� Ȯ���ϴ� �Լ�, �����ϴ� ��� �� �ǹ����� �ٽ� 4����� �����ϸ� ���ÿ� �� ������ �� ������ 1�� ������Ų��.
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
