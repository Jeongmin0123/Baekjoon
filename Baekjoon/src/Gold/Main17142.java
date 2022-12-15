package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17142 {
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int N,M;
	public static int answer = Integer.MAX_VALUE;
	public static int[][] map;
	public static ArrayList<Node> virus;
	public static int[] select;
	// 맨 처음 연구소의 빈칸의 개수
	public static int origin = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 바이러스의 위치를 저장하는 ArrayList
		virus = new ArrayList<>();
		select = new int[M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					origin++;
				} else if(map[i][j] == 2) {
					virus.add(new Node(i,j));
				}
			}
		}
		// 연구소에 빈칸이 없으면 이미 바이러스로 가득찬 경우이다.
		if(origin == 0) {
			System.out.println(0);
		} else {
			Comb(0,0);
			if(answer != Integer.MAX_VALUE) {
				System.out.println(answer);
			} else {
				System.out.println(-1);
			}
		}
	}
	// 연구소의 존재하는 바이러스 중 M개를 뽑아주는 메서드
	public static void Comb(int idx, int cnt) {
		if(cnt == M) {
			bfs(origin);
			return;
		}
		for(int i = idx ; i < virus.size() ; i++) {
			select[cnt] = i;
			Comb(i+1, cnt+1);
		}
	}
	
	public static void bfs(int emptySpace) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		// Combination으로 고른 바이러스들을 queue에 넣어준다.
		for(int i = 0 ; i < select.length ; i++) {
			Node checked = virus.get(select[i]);
			q.offer(checked);
			visited[checked.r][checked.c] = true;
		}
		// 연구소의 모든 빈 칸에 바이러스가 있게 되는 시간
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int t = 0 ; t < size ; t++) {
				Node cur = q.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int dr = cur.r + move[i][0];
					int dc = cur.c + move[i][1];
					// 배열 밖으로 벗어나거나, 벽이거나, 이미 방문한 경우 이동할 수 없으므로 다음 연산을 진행한다.
					if(!isValid(dr,dc) || map[dr][dc] == 1 || visited[dr][dc]) continue;
					// 만약 이동 지점이 빈 곳이라면 빈 지점의 개수를 1 감소시킨다.
					if(map[dr][dc] == 0) emptySpace--;
					// 빈 곳의 개수가 0이라면 최소 시간을 초기화하고 연산을 종료한다.
					if(emptySpace == 0) {
						answer = Math.min(answer, time+1);
						return;
					}
					visited[dr][dc] = true;
					q.offer(new Node(dr,dc));
				}
			}
			time++;
		}
	}
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}

}
