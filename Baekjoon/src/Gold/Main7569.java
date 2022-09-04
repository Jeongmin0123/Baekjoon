package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {

	// �丶���� x,y,z ��ǥ�� �����ϴ� Ŭ����
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
	
	// 6���⿡ ���� x,y,z�� �̵��� �迭
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
			// ���� ��ġ�� �޾ƿ� �ڿ� 6���� Ž���Ѵ�.
			tomato now = q.remove();
			for(int i = 0 ; i < 6 ; i++) {
				int a = now.x + dx[i];
				int b = now.y + dy[i];
				int c = now.z + dz[i];
				// ���� Ž���� ������ �̵� �����ϰ� �� ������ ���� 0�̶�� �� ��ġ�� ���ο� �丶�並 �����Ͽ� queue�� �־��ְ� �� ��ġ����
				// �̵� ���������� ������ 1 �����ش�.
				if(isValid(a,b,c) && map[a][b][c] == 0) {
					q.offer(new tomato(a,b,c));
					map[a][b][c] = map[now.x][now.y][now.z] + 1;
				}
			}
		}
		
		// �ּ��ϼ��� ��ȯ�ϴ� �˰���
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
	
	// �̵��� ������ �迭�� ���ο� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int x, int y, int z) {
		if(x < 0 || x >= M || y < 0 || y >= N || z < 0 || z >= H) {
			return false;
		}
		return true;
	}

}
