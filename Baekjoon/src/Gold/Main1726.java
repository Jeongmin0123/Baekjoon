package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1726 {

	static class Node {
		int r;
		int c;
		int time;
		int dir;
		
		public Node(int r, int c, int time, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.dir = dir;
		}
	}
	
	public static int R,C;
	public static int[][] map;
	public static boolean[][][] visited;
	public static Queue<Node> q;
	public static Node end;
	public static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		// �� 4������ ������ �����Ƿ� ���⿡ ���� �湮ó���� �ٸ��� �ϱ� ���� 3���� �迭�� ����Ѵ�.
		visited = new boolean[R][C][4];
		q = new ArrayDeque<>();
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int dir = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new Node(r,c,0,dir));
		visited[r][c][dir] = true;
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken()) - 1;
		end = new Node(r,c,0,dir);
		bfs();
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// �������� �����ϰ� ���⵵ ���� ��� ���� ����Ѵ�.
			if(cur.c == end.c && cur.r == end.r && cur.dir == end.dir) {
				System.out.println(cur.time);
				return;
			}
			
			// ��� 1 : 1,2,3ĭ ��ŭ �̵��̹Ƿ� for���� Ȱ���Ѵ�.
			for(int i = 1 ; i <= 3 ; i++) {
				int dr = cur.r + move[cur.dir][0]*i;
				int dc = cur.c + move[cur.dir][1]*i;
				// �迭�� ������ ��� ���
				if(!isValid(dr,dc)) continue;
				// �������� ������ ������ ���� �ƴѰ��
				if(map[dr][dc] == 0) {
					// �湮���� ���� ������ ��� �湮ó�� �� queue�� �߰��Ѵ�.
					if(!visited[dr][dc][cur.dir]) {
						visited[dr][dc][cur.dir] = true;
						q.offer(new Node(dr,dc,cur.time+1,cur.dir));
					}
				// �������� ������ ������ ���� ���
				} else {
					// �� ���� ������ʹ� ���� �հ� �������� ���̹Ƿ� ������ �ʿ䰡 ����.
					break;
				}
			}
			// ��� 2
			for(int i = 0 ; i < 4 ; i++) {
				// ȸ���� �ʿ��ϰ� �湮�� �� ���� ��� ȸ����Ų��.
				if(cur.dir != i && !visited[cur.r][cur.c][i]) {
					int add = 1;
					if(cur.dir == 0) {
						if(i == 1) add++;
					} else if(cur.dir == 1) {
						if(i == 0) add++;
					} else if(cur.dir == 2) {
						if(i == 3) add++;
					} else {
						if(i == 2) add++;
					}
					visited[cur.r][cur.c][i] = true;
					q.offer(new Node(cur.r,cur.c,cur.time+add,i));
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
	
}
