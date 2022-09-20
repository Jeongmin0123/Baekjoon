package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16928 {

	public static int N,M;
	public static int[] map;
	public static boolean[] visited;
	public static int answer = Integer.MAX_VALUE;
	
	// ���� ��ġ�� �� ��ġ���� ���µ� �ɸ� �ð��� �����ϴ� Ŭ����
	static class Node {
		int x;
		int time;
		
		public Node(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// �ʰ� �湮ó���� �迭�� �����.
		map = new int[101];
		visited = new boolean[101];
		for(int i = 0 ; i < N+M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start] = end;
		}
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		// queue�� �������� �־��ش�.
		q.offer(new Node(1,0));
		visited[1] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// �������� �����ϸ� ������� ���������ش�.
			if(cur.x == 100) {
				answer = Math.min(answer, cur.time);
				return;
			}
			for(int i = 1 ; i <= 6 ; i++) {
				int x = cur.x + i;
				// ��ǥ������ �Ѿ�ų� �̹� �湮�� ������ �Ѿ��.
				if(x > 100 || visited[x]) continue;
				// ��ٸ��� ���� ����Ǿ� �ִ� ���
				if(map[x] != 0) {
					if(!visited[x]) {
						q.offer(new Node(map[x], cur.time+1));
						visited[x] = true;
						visited[map[x]] = true;
					}
				// ��ٸ��� ���� ����Ǿ� ���� ���� ���
				} else {
					q.offer(new Node(x, cur.time+1));
					visited[x] = true;
				}
			}
		}
	}

}
