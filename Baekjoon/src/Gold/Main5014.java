package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {
	public static int F;
	public static int S;
	public static int G;
	public static int U;
	public static int D;
	public static int[] floor;
	public static int[] move = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		move[0] = Integer.parseInt(st.nextToken());
		move[1] = -Integer.parseInt(st.nextToken());
		// 층마다 누른 버튼수를 저장하는 배열
		floor = new int[F+1];
		bfs(S);
	}
	
	// dfs 사용시 무한루프나 시간초과가 발생하므로 bfs를 사용한다.
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		// 방문한 층인지 확인하는 배열
		boolean[] check = new boolean[F+1];
		check[start] = true;
		// 시작점은 버튼을 안 누른 상태이므로 0으로 고정한다.
		floor[start] = 0;
		while(!q.isEmpty()) {
			// 현재 지점이 목표지점이면 누른 버튼의 횟수를 출력한다.
			int now = q.poll();
			if(now == G) {
				System.out.println(floor[G]);
				return;
			}
			// 올라가는 버튼과 내려가는 버튼 2번을 고려해야 한다.
			for(int i = 0 ; i < 2 ; i++) {
				int next = now + move[i];
				if(next > F || next < 1) {
					continue;
				}
				// 방문하지 않은 지역이면 그 층을 연산에 포함시키고 방문한 층이라고 표시한 뒤에
				// 현재 지점에서 버튼을 한번 더 누른 것이므로 floor[now] + 1를 저장한다.
				if(!check[next]) {
					q.add(next);
					check[next] = true;
					floor[next] += floor[now] + 1;
				}
			}
		}
		// 엘레베이터로 갈 수 없는 경우 출력한다.
		System.out.println("use the stairs");
	}
}
