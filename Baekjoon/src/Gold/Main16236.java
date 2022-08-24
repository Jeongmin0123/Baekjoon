package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {

	public static int N;
	public static int[][] map;
	public static int eatedFish;
	public static int sharkSize = 2;
	public static int count;
	public static int x,y;
	public static Queue<int[]> q;
	
	public static int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static class fish {
		int x;
		int y;
		int size;
		
		public fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				map[i][j] = temp;
				
				if(temp == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		System.out.println(time());
	}
	
	// �Դµ� �ɸ��� �ð� ã��
	public static int time() {
		int result = 0;
		boolean[][] visited = new boolean[N][N];
		q = new ArrayDeque<>();
		// ���� ��� ��ġ�� �־��ְ� �� ��ġ�� �湮���� true �ٲ��ش�.
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			fish expectedFish = null;
			int size = q.size();
			// ���� depth�� �ִ� �͵鳢�� ���� ����
			for(int i = 0 ; i < size ; i++) {
				int[] sharkLocation = q.poll();
				for(int j = 0 ; j < 4 ; j++) {
					int dx = sharkLocation[0] + dxdy[j][0];
					int dy = sharkLocation[1] + dxdy[j][1];
					
					// �̵��������� �ʰų� �湮�� ���̸� �Ѿ��.
					if(!Moveable(dx,dy)) {
						continue;
					}
					if(visited[dx][dy]) {
						continue;
					}
					
					// �׷��� ���� ��� �̵��ϰ� �湮���� �ٲ��ش�.
					q.offer(new int[] {dx,dy});
					visited[dx][dy] = true;
					
					// �̵��� ���� ����⸦ ���� �� ������ ���� ���� �� �ִ� ������� ��ġ���� ���Ͽ� ���ǿ� �´� ���� �������Ѵ�.
					if(Eatable(dx, dy)) {
						if(expectedFish == null) {
							expectedFish = new fish(dx,dy,map[dx][dy]);
						} else if(expectedFish.x < dx) {
							continue;
						} else if(expectedFish.x == dx && expectedFish.y < dy) {
							continue;
						} else {
							expectedFish = new fish(dx,dy,map[dx][dy]);
						}
					}
				}
			}
			// ���� depth�� ���Ͽ� ������ �Ϸ�Ǹ� �̵��Ÿ��� �ϳ� �÷��ش�.
			cnt++;
			// ���� ����⸦ �Ծ��ٸ�, ����� ��ġ�� �ٲ��ְ� �� �̵��Ÿ��� ���� depth�� �̵��Ÿ��� �����ش�.
			if(eat(expectedFish)) {
				visited = sharkLocation(expectedFish);
				result += cnt;
				cnt = 0;
			}
		}
		return result;
	}
	// ���� �� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean Eatable(int x, int y) {
		if(map[x][y] < sharkSize && map[x][y] != 0) {
			return true;
		}
		return false;
	}
	
	// ������ �� �ִ��� ���θ� �Ǵ��ϴ� �޼���
	public static boolean Moveable(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		if(map[x][y] > sharkSize) {
			return false;
		}
		return true;
	}
	
	// �Դ� �ൿ�� ���� �޼���
	public static boolean eat(fish Fish) {
		if(Fish == null) {
			return false;
		}
		map[Fish.x][Fish.y] = 0;
		eatedFish++;
		if(eatedFish == sharkSize) {
			eatedFish = 0;
			sharkSize++;
		}
		return true;
	}
	
	// ����� ��ġ�� �ٲ��ִ� �޼���
	public static boolean[][] sharkLocation(fish expectedFish) {
		q.clear();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new int[] {expectedFish.x,expectedFish.y});
		visited[expectedFish.x][expectedFish.y] = true;
		return visited;
	}

}

