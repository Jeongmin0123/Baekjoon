package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406 {
	public static int N,M,K;
	public static int[][] map;
	// �� �� �� ��
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static int answer = Integer.MAX_VALUE;
	public static int[] order;
	public static boolean[] used;
	
	public static int[][] cal; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		// �迭�� �޾ƿ� �����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ���꿡 ���� ������ �����ϴ� �迭
		cal = new int[K][3];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cal[i][0] = Integer.parseInt(st.nextToken());
			cal[i][1] = Integer.parseInt(st.nextToken());
			cal[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// ������ ������ �����ϴ� �迭
		order = new int[K];
		// ������ ���� ��, i��° ������ ���ԵǾ����� �ȵǾ������� �Ǻ��ϴ� �迭
		used = new boolean[K];
		Perm(0);
		System.out.println(answer);
	}
	
	public static void Rotation() {
		// map�迭�� ����Ͽ� �����ϰ� �Ǹ� ���� ���꿡 ������ �ֹǷ� �����Ͽ� ����Ѵ�.
		int[][] copy = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			copy[i] = map[i].clone();
		}
		// x,y��ǥ�� 1���� �����ϹǷ� 1�� ���־� �迭�� idx�� ���� ���ش�.
		for(int t : order) {
			int x = cal[t][0] - 1;
			int y = cal[t][1] - 1;
			int s = cal[t][2];
			for(int i = 1 ; i <= s ; i++) {
				int dir = 0;
				int a = x-i;
				int b = y-i;
				int temp = copy[a][b];
				while(dir < 4) {
					int next_x = a + dx[dir];
					int next_y = b + dy[dir];
					
					if(next_x >= x-i && next_y >= y-i && next_x <= x + i && next_y <= y + i) {
						copy[a][b] = copy[next_x][next_y];
						a = next_x;
						b = next_y;
					} else {
						dir++;
					}
				}
				copy[x-i][y-i+1] = temp;
			}
		}
		// ���� ���� ���� ���� ���ϴ� ����
		for(int i = 0 ; i < N ; i++) {
			int sum = 0;
			for(int j = 0 ; j < M ; j++) {
				sum+= copy[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}
	
	// �޾ƿ� ������ ������ ������ִ� �޼���
	public static void Perm(int depth) {
		// ������ ������ �� �����ϸ� �� ������ ������ ������ �����Ѵ�.
		if(depth == K) {
			Rotation();
			return;
		}
		for(int i = 0 ; i < K ; i++) {
			if(!used[i]) {
				used[i] = true;
				order[depth] = i;
				Perm(depth+1);
				used[i] = false;
			}
		}
	}
}
