package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {

	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int max = 0;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// map�� ��� ������ ���������� �Ͽ� 5���� ����� ����� dfs Ž���� �����Ѵ�.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				visited[i][j] = true;
				dfs(i,j,map[i][j],1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	public static void dfs(int r, int c, int sum, int cnt) {
		// ���� 4���� �̾���� ��Ʈ�ι̳븦 ����� max ���� ���Ͽ� �� ū���� �������ش�.
		if(cnt == 4) {
			max = Math.max(sum, max);
			return;
		}
		// �� ������ �������� ���Ž���� �����Ѵ�.
		for(int i = 0 ; i < 4 ; i++) {
			int dr = r + move[i][0];
			int dc = c + move[i][1];
			// �迭�� ����ų� �湮ó�� �� ������ ������ ���� ������ �����Ѵ�.
			if(!isValid(dr,dc) || visited[dr][dc]) continue;
			// 4���� ĭ�� 2��°ĭ���� ä�� ��� �� ����� 2��° �������� �ѹ� �� ������ ����� �ϹǷ� �̸� ����Ѵ�.
			if(cnt == 2) {
				visited[dr][dc] = true;
				dfs(r,c,sum+map[dr][dc], cnt+1);
				visited[dr][dc] = true;
			}
			// �湮 ó���� ���� dfsŽ���� ������ �� �ٽ� �湮 ó���� ����Ѵ�.
			visited[dr][dc] = true;
			dfs(dr,dc,sum+map[dr][dc], cnt+1);
			visited[dr][dc] = false;
		}
	}
	// �迭 ���ο� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}
