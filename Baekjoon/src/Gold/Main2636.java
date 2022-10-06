package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	// ġ���� ��ǥ�� �����ϴ� Ŭ����
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static Queue<Node> q;
	public static int remain = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		// �迭�� ���� �����ϰ�, ���� �޾ƿ� ���� ġ���� ġ���� ���� ������Ų��.
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) remain++;
			}
		}
		// �ɸ� �ð�
		int count = 0;
		while(true) {
			int result = bfs();
			// ���� ���� ġ� ���ٸ�, ������ �����Ѵ�.
			if(remain - result == 0) {
				count++;
				break;
			}
			remain -= result;
			count++;
		}
		System.out.println(count);
		System.out.println(remain);
	}
	
	public static int bfs() {
		//(0,0)�� �������� �ʺ� �켱 Ž���� �����Ѵ�.
		q = new ArrayDeque<>();
		visited = new boolean[R][C];
		q.offer(new Node(0,0));
		int remove = 0;
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// �̵��� ������ �湮�߰ų�, �迭 ���̶�� ���� ������ �����Ѵ�.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				// ���� ��ĭ�̶��, �湮ó�� �� �� Queue�� �־��ش�.
				if(map[dr][dc] == 0) {
					visited[dr][dc] = true;
					q.offer(new Node(dr,dc));
				// ���� �ٱ��� 0�� ���˵Ǿ� �ִ� ġ���� �����ְ� �湮ó���� �Ѵ�.
				} else {
					remove++;
					map[dr][dc] = 0;
					visited[dr][dc] = true;
				}
			}
		}
		return remove;
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= R || y >= C) return false;
		return true;
	}
	
}
