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
	
	// 현재 위치와 그 위치까지 가는데 걸린 시간을 저장하는 클래스
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
		// 맵과 방문처리할 배열을 만든다.
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
		// queue에 시작점을 넣어준다.
		q.offer(new Node(1,0));
		visited[1] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 도착점에 도착하면 결과값을 재지정해준다.
			if(cur.x == 100) {
				answer = Math.min(answer, cur.time);
				return;
			}
			for(int i = 1 ; i <= 6 ; i++) {
				int x = cur.x + i;
				// 목표지점을 넘어가거나 이미 방문한 지점은 넘어간다.
				if(x > 100 || visited[x]) continue;
				// 사다리나 뱀이 연결되어 있는 경우
				if(map[x] != 0) {
					if(!visited[x]) {
						q.offer(new Node(map[x], cur.time+1));
						visited[x] = true;
						visited[map[x]] = true;
					}
				// 사다리나 뱀이 연결되어 있지 않은 경우
				} else {
					q.offer(new Node(x, cur.time+1));
					visited[x] = true;
				}
			}
		}
	}

}
