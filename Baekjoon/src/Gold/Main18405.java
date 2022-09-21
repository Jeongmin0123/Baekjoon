package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18405 {

	// ���̷����� �����ϴ� ������ ��ǥ�� ���̷����� ����, �׸��� �� ���̷����� ���µ� �ɸ� �ð��� �����ϴ� Ŭ����
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int num;
		int time;

		public Node(int x, int y, int num, int time) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
		// ���̷����� ���� ������ �����Ѵ�.
		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}
	}
	
	public static int N,K,S;
	public static int[][] map;
	public static boolean[][] visited;
	public static ArrayList<Node> virus;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		virus = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) virus.add(new Node(i,j,map[i][j],0));
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		Collections.sort(virus);
		bfs();
		System.out.println(map[X-1][Y-1]);
	}
	// BFS �Լ�
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		// �����ϴ� ���̷����� ��� queue�� �־��ش�.
		// �� ��, ���ĵ� ���·� queue�� ���Ƿ� ���̷��� ���������� ���� �ȴ�.
		for(int i = 0 ; i < virus.size() ; i++) {
			q.offer(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// ���� �ð��� �����ϸ� �����.
			if(cur.time == S) break;
			for(int i = 0 ; i < 4 ; i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				// �迭�� ������ ����� ������ ���� �ʴ´�.
				if(!isValid(dx,dy)) continue;
				// �湮���� ���� ���� ���, �湮ó�� ���Ŀ� �� ������ ���� ������ queue�� �ִ´�
				if(!visited[dx][dy]) {
					map[dx][dy] = cur.num;
					visited[dx][dy] = true;
					q.offer(new Node(dx,dy,cur.num,cur.time+1));
				}
			}
		}
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}

}
