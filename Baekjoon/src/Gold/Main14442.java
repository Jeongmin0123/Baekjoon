package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14442 {

	// ��ǥ�� �� ��ǥ���� ���µ� �ɸ� �ð��� �μ� ���� ������ �����ϴ� �޼���
	static class Node {
		int r;
		int c;
		int time;
		int wall;
		
		public Node(int r, int c, int time, int wall) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.wall = wall;
		}
	}
	
	public static int R,C,K,answer;
	public static char[][] map;
	// �湮ó���� ���� �迭�� �����Ѵ�.
	// �̶�, �湮ó���� �μ� ���� �������� �ٸ��� �湮ó���� ����� �ϹǷ� 3���� �迭�� �����Ѵ�.
	public static boolean[][][] visited;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][K+1];
		// �� �� ���� ��� -1�� ����ؾ� �ϹǷ� answer ���� �ʱ�ȭ�Ѵ�.
		answer = -1;
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// bfsŽ���� �����Ѵ�.
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.offer(new Node(0,0,1,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// ���� ������ ��ġ�� �������� �׶����� �ɸ� �ð��� ��ȯ�Ѵ�.
			if(cur.r == R-1 && cur.c == C-1) {
				answer = cur.time;
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// ������ ������ �迭�� ����� ��� ������ ���� �ʴ´�.
				if(!isValid(dr,dc)) continue;
				// �湮�� ������ ���ΰ��
				if(map[dr][dc] == '1') {
					// �湮�� �����̰ų�, �� �̻� ���� �μ� �� ���� ��� ������ ���� �ʴ´�.
					if(cur.wall >= K || visited[dr][dc][cur.wall+1]) continue;
					// �湮 ó�� ��, queue�� �߰��Ѵ�.
					visited[dr][dc][cur.wall+1] = true;
					q.offer(new Node(dr,dc,cur.time+1,cur.wall+1));
				// �湮�� ������ ���� �ƴѰ��
				} else {
					// �湮���� ��� ������ ���� �ʴ´�.
					if(visited[dr][dc][cur.wall]) continue;
					// �湮 ó�� ��, queue�� �߰��Ѵ�.
					visited[dr][dc][cur.wall] = true;
					q.offer(new Node(dr,dc,cur.time+1,cur.wall));
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}

}
