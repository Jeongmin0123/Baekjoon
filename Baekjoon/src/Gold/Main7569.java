package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {

	// 토마토의 x,y,z 좌표를 저장하는 클래스
	static class tomato{
		int x;
		int y;
		int z;
		
		public tomato(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	
	public static int N,M,H;
	public static int[][][] map;
	
	// 6방향에 대한 x,y,z의 이동값 배열
	public static int[] dx = {-1,1,0,0,0,0};
	public static int[] dy = {0,0,1,-1,0,0};
	public static int[] dz = {0,0,0,0,-1,1};
	
	public static Queue<tomato> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		map = new int[M][N][H];
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < N ; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0 ; k < M ; k++) {
					map[k][j][i] = Integer.parseInt(st.nextToken());
					if(map[k][j][i] == 1) q.offer(new tomato(k,j,i));
				}
			}
		}
		int result = bfs();
		System.out.println(result);
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			// 현재 위치를 받아온 뒤에 6방향 탐색한다.
			tomato now = q.remove();
			for(int i = 0 ; i < 6 ; i++) {
				int a = now.x + dx[i];
				int b = now.y + dy[i];
				int c = now.z + dz[i];
				// 만약 탐색한 방향중 이동 가능하고 그 지점의 값이 0이라면 그 위치로 새로운 토마토를 생성하여 queue에 넣어주고 그 위치값을
				// 이동 시작지점의 값에서 1 더해준다.
				if(isValid(a,b,c) && map[a][b][c] == 0) {
					q.offer(new tomato(a,b,c));
					map[a][b][c] = map[now.x][now.y][now.z] + 1;
				}
			}
		}
		
		// 최소일수를 반환하는 알고리즘
		int result = Integer.MIN_VALUE;
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < M ; k++) {
					if(map[k][j][i] == 0) return -1;
						result = Math.max(result, map[k][j][i]);
					
				}
			}
		}
		return result - 1;
	}
	
	// 이동한 지점이 배열의 내부에 있는지 판단하는 메서드
	public static boolean isValid(int x, int y, int z) {
		if(x < 0 || x >= M || y < 0 || y >= N || z < 0 || z >= H) {
			return false;
		}
		return true;
	}

}
