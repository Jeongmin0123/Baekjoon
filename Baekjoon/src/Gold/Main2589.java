package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {

	public static int N,M;
	public static int answer = Integer.MIN_VALUE;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	// �̵��� ���� x��ǥ,y��ǥ�� ���������� �� ������ ���µ� �ɸ� �ð��� �����ϴ� Ŭ����
	static class Node {
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// �������� ���� ���� �� ������ ���� �ð��� �ٸ��Ƿ� ��� ���� ���ؼ� �����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 'L') {
					visited = new boolean[N][M];
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	// �������� �޾ƿ� �� ������ ���� �� ������ ���µ� �ɸ��� �ð��� ����ϴ� bfs �޼���
	public static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		// �������� �ɸ��� �ð��� 0�̴�.
		q.offer(new Node(x,y,0));
		// �湮üũ
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				// �̵� ������ �������� üũ
				if(isValid(dx,dy) && !visited[dx][dy] && map[dx][dy] == 'L') {
					// �̵� ������ �� �� ���������� �ɸ� �ð��� ���ϱ� 1�� ���ش�.
					q.offer(new Node(dx,dy,cur.time+1));
					// �湮üũ
					visited[dx][dy] = true;
					// �� ������ �ִ� �Ÿ��� �̵��ϴ� �ð��� ����
					answer = Math.max(cur.time+1, answer);
				}
			}
		}
	}
	
	// �迭�� ���� ���� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}

}
