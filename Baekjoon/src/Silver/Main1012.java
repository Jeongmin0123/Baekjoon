package Silver;

import java.util.Scanner;

public class Main1012 {
	// ���� �������� dfs_count �Լ����� �ѹ� main �Լ����� �ѹ�, �� �ι� ����ϹǷ� ���������� �����Ѵ�.
	public static int m;
	public static int n;
	public static boolean map[][];
	public static boolean visited[][];
	// ��, ��, ��, �� ������ x,y��ǥ�� ��ȭ�� ���� �迭�� �����Ѵ�.
	public static int[] dx = {0, 0, -1, 1}; 
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// ������� �����ϴ� �迭
		int results[] = new int[T];
		for(int i = 0 ; i < T ; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int K = sc.nextInt();
			// ���� ���ߵ��� ��ġ�� ���õ� 2���� �迭�� 1�� ��� true, 0�ϰ�� false �̹Ƿ� boolean Ÿ������ �������־���.
			map = new boolean[m][n];
			// ���߰� ����Ǿ� �ִ� ��� dfs_count�Լ��� ���Ͽ� ����Ǿ� �ִ� ���� �湮�ǹǷ� map�� �湮���ο� ���� 2���� �迭�� �������ش�.
			// �� ��, true�� ��� �湮�� ����, false�� �湮���� ���� �����̴�.
			visited = new boolean[m][n];
			for(int j = 0 ; j < K ; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				// ���߰� �ִ� ���� true�� ���� �������ش�.
				map[a][b] = true;
			}
			int result = 0;
			for(int a = 0 ; a < m ; a++) {
				for(int b = 0 ; b < n ; b++) {
					// ���߰� �����鼭 �湮�� ���� ���� ��쿡�� result���� ���������ְ�, �� ��ġ�� �湮���� true�� �ٲ��� �Ŀ� dfs_count �Լ��� �����Ѵ�.
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
	// ���߰� �ִ� ������ �����¿쿡 ���߰� �ִ��� Ž���ؼ� �ִ� ��쿡 ����� ���߸� �ϳ��� �������ϴ� �Լ� 
	public static void dfs_count(int x, int y) {
		int nx;
		int ny;
		// �����¿� 4����� �˾ƾ��ϹǷ� for���� 4�� �����Ѵ�.
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// �������� �� ������ 2���� �迭 �ȿ� �����ؾ� �Ѵ�.
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				// ������ ���� ���߰� �����ϰ� �湮�� ���� ������ �� ��ġ�� �湮���� true�� �ٲ��ְ� �ٽ� ������ �� �����¿쿡 ���߰� �ִ��� Ž���Ѵ�.
				if(map[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs_count(nx,ny);
				}
			}
		}
		
	}


}
