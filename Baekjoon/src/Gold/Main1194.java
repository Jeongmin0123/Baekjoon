package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {

	// 사람의 좌표, 걸린 시간, 그리고 현재 가지고 있는 열쇠의 정보를 포함하는 클래스
	static class Person {
		int r;
		int c;
		int time;
		int keys;
		
		public Person(int r, int c, int time, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.keys = keys;
		}
	}
	public static int N,M;
	public static char[][] map;
	public static boolean[][][] visited;
	public static Queue<Person> q;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 열쇠의 개수가 6개이므로 가질 수 있는 열쇠 배열의 개수는 2의 6제곱은 64이다.
		// 방문 처리를 열쇠 개수 배열에 따라 다르게 해야 하므로 3차원 배열로 만들고 가로,세로,열쇠 배열의 개수를 순서대로 크기로 지정한다.
		visited = new boolean[N][M][64];
		map = new char[N][M];
		q = new ArrayDeque<>();
		// 입력받고, 시작점을 Queue에 추가한다.
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == '0') {
					q.offer(new Person(i,j,0,0));
					visited[i][j][0] = true;
				}
			}
		}
		bfs();
	}

	// bfs 함수
	public static void bfs() {
		while(!q.isEmpty()) {
			Person cur = q.poll();
			int nowkey = cur.keys;
			// 탈출점에 도달하면 걸린 시간을 반환하고 종료한다.
			if(map[cur.r][cur.c] == '1') {
				System.out.println(cur.time);
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// 벽을 만나거나, 배열 밖의 범위거나 방문한 적 있으면 다음 연산을 진행한다.
				if(!isValid(dr,dc) || map[dr][dc] == '#' || visited[dr][dc][nowkey]) continue;
				// 열쇠를 만난 경우, 현재 가지고 있는 열쇠 배열에 만난 열쇠를 추가한 뒤, 방문처리를 하고 그 지점을 queue에 추가한다.
				if(map[dr][dc] - 'a' >= 0 && map[dr][dc] - 'a' < 6) {
					int nextkey = (nowkey | (1 << (map[dr][dc] - 'a')));
					if(!visited[dr][dc][nextkey]) {
						visited[dr][dc][nowkey] = true;
						visited[dr][dc][nextkey] = true;
						q.offer(new Person(dr,dc,cur.time + 1, nextkey));
					}
				}
				// 문을 만난 경우, 열쇠가 있는 경우에 그 문으로 이동하고 방문처리를 한 뒤 그 지점을 queue에 추가한다.
				else if(map[dr][dc] - 'A' >= 0 && map[dr][dc] - 'A' < 6) {
					int temp = nowkey & (1 << (map[dr][dc] - 'A'));
					if(temp > 0) {
						visited[dr][dc][nowkey] = true;
						q.offer(new Person(dr,dc,cur.time + 1, nowkey));
					}
				}
				// .인 경우 이동하고 방문처리를 한다.
				else {
					visited[dr][dc][nowkey] = true;
					q.offer(new Person(dr,dc,cur.time+1,nowkey));
				}
			}
		}
		System.out.println(-1);
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) return false;
		return true;
	}
	
}


