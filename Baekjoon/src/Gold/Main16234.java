package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {

	public static int N,L,R;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int time = 0;
	public static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// �α� �̵��� ������ ��ŭ �̵��Ѵ�.
		while(true) {
			visited = new boolean[N][N];
			flag = false;
			int temp = time;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j]) {
						// �湮���� ���� ������ �������� �ʺ� �켱 Ž���� �����Ѵ�.
						bfs(i,j);
					}
				}
			}
			// �α� �̵��� �Ͼ ���, �ٽ� �α��̵��� �����ϰ�, �ƴ� ��� �α��̵��� �� Ƚ���� ����Ѵ�.
			if(flag == true) time++;
			if(time == temp) {
				System.out.println(time);
				break;
			}
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		ArrayList<int[]> change = new ArrayList<>();
		change.add(new int[] {r,c});
		int count = 0;
		int sum = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			count++;
			sum += map[cur[0]][cur[1]];
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur[0] + move[i][0];
				int dc = cur[1] + move[i][1];
				// �湮�� ���� ����, �迭 ���� �����ϸ�, �� ���� ������ ���̰� L�� �̻�, R�� ������ ���, ������ ����.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				if(Math.abs(map[cur[0]][cur[1]] - map[dr][dc]) >= L && Math.abs(map[cur[0]][cur[1]] - map[dr][dc]) <= R) {
					visited[dr][dc] = true;
					q.offer(new int[] {dr,dc});
					change.add(new int[] {dr,dc});
				}
			}
		}
		// ������ ���� �������� ���� �� ������ ������.
		int avg = sum/count;
		for(int[] i : change) {
			// ������ ���� �������� ���� �׵��� ��� ������ �ٲ��ش�.
			map[i[0]][i[1]] = avg;
		}
		if(count > 1) {
			flag = true;
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}

}
