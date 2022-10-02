package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070 {

	public static int N, answer;
	public static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0);
		System.out.println(answer);
	}
	
	// ���̿켱 Ž��
	public static void dfs(int x, int y, int dir) {
		// �迭�� ������ ����ų�, ��ֹ��� ���� ���
		if(!isValid(x,y) || map[x][y] == 1) return;
		// �밢������ �̵����״µ� 4ĭ �� ��ֹ��� �ִ� ���
		if(dir == 1 && (map[x-1][y] == 1 || map[x][y-1] == 1)) return;
		// ��ǥ������ ������ ���
		if(x == N-1 && y == N-1) {
			answer++;
			return;
		}
		// �������� ���η� �Ǿ��ִ� ���, ���γ� �밢������ �̵������ϴ�.
		if(dir == 0) {
			dfs(x+1,y+1,dir+1);
			dfs(x,y+1,dir);
		// �������� �밢������ �Ǿ��ִ� ���, ��� �������� �̵� �����ϴ�.
		} else if(dir == 1) {
			dfs(x,y+1,dir-1);
			dfs(x+1,y+1,dir);
			dfs(x+1,y,dir+1);
		// �������� ���η� �Ǿ��ִ� ���, �밢���� ���ι������� �̵� �����ϴ�
		}else {
			dfs(x+1,y,dir);
			dfs(x+1,y+1,dir-1);
		}
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}

}
