package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {

	// �ɸ��ð�, ��ǥ, ������ ������ Ƚ���� �����ϴ� class
	static class Node {
		int x;
		int y;
		int time;
		int horse;
		
		public Node(int x, int y, int time, int horse) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.horse = horse;
		}
		
	}
	
	public static int K,W,H;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int answer = Integer.MAX_VALUE;
	// �����̷μ��� ������
	public static int[][] monkey = {{1,0},{0,1},{-1,0},{0,-1}};
	// ���ν��� ������
	public static int[][] horse = {{2,1},{1,2},{-2,-1},{-1,2},{-1,-2},{2,-1},{-2,1},{1,-2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());;
		map = new int[H][W];
		// K������ ��ó�� ������ �� �����Ƿ� �迭�� �տ� ��ĭ�� ��ǥ, ������ ĭ�� ���ν� ������ Ƚ���� ǥ���Ѵ�.
		visited = new boolean[H][W][K+1];
		for(int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0,0,0,0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// ��ǥ ������ ������ ���, �ּҰ��� �������Ѵ�.
			if(cur.x == H-1 && cur.y == W-1) {
				answer = Math.min(answer, cur.time);
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				// ������ó�� �����̴� ���
				int dx = cur.x + monkey[i][0];
				int dy = cur.y + monkey[i][1];
				if(!isValid(dx,dy)) continue;
				if(!visited[dx][dy][cur.horse] && map[dx][dy] == 0) {
					visited[dx][dy][cur.horse] = true;
					q.offer(new Node(dx,dy,cur.time+1,cur.horse));
				}
			}
			// ���� �̵��� �� �ִ� Ƚ���� ���� ��쿡�� ��ó�� �����δ�.
			if(cur.horse < K) {
				// ��ó�� �����̴� ���
				for(int i = 0 ; i < 8 ; i++) {
					int dx = cur.x + horse[i][0];
					int dy = cur.y + horse[i][1];
					if(!isValid(dx,dy)) continue;
					if(!visited[dx][dy][cur.horse+1] && map[dx][dy] == 0) {
						visited[dx][dy][cur.horse+1] = true;
						q.offer(new Node(dx,dy,cur.time+1,cur.horse+1));
					}
				}
			}
		}
	}
	
	// �迭�ȿ� ���ԵǴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= H || y >= W) return false;
		return true;
	}

}

