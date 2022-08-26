package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {

	public static int N;
	public static int[][] map;
	public static boolean[] visited;
	public static int answer = Integer.MAX_VALUE;
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
		
		// �������� �𸣴� ����� ���������� ��� ���� ����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,i,0);
		}
		System.out.println(answer);
	}
	// �ּҺ���� ���ϴ� dfs�Լ�
	public static void dfs(int start, int now, int cost) {
		// ��� ������ �湮�߰� �� �������� �ٽ� ������������ ���ư� �� ������
		// ���ư� �ڿ� �׶� ��� ���� ���� �ּҺ�� �� ���Ͽ� �� ���� ���� �ּҺ�뿡 �����Ѵ�.
		if(AllVisited()) {
			if(map[now][start] != 0) {
				answer = Math.min(answer, cost + map[now][start]);
			}
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cost + map[now][i]);
				visited[i] = false;
			}
		}
	}

	public static boolean AllVisited() {
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	
}

