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
	
	// 먹는데 걸리는 시간 찾기
	public static int time() {
		int result = 0;
		boolean[][] visited = new boolean[N][N];
		q = new ArrayDeque<>();
		// 현재 상어 위치를 넣어주고 그 위치의 방문값을 true 바꿔준다.
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			fish expectedFish = null;
			int size = q.size();
			// 같은 depth에 있는 것들끼리 비교할 예정
			for(int i = 0 ; i < size ; i++) {
				int[] sharkLocation = q.poll();
				for(int j = 0 ; j < 4 ; j++) {
					int dx = sharkLocation[0] + dxdy[j][0];
					int dy = sharkLocation[1] + dxdy[j][1];
					
					// 이동가능하지 않거나 방문한 곳이면 넘어간다.
					if(!Moveable(dx,dy)) {
						continue;
					}
					if(visited[dx][dy]) {
						continue;
					}
					
					// 그렇지 않은 경우 이동하고 방문값을 바꿔준다.
					q.offer(new int[] {dx,dy});
					visited[dx][dy] = true;
					
					// 이동한 곳의 물고기를 먹을 수 있으면 현재 먹을 수 있는 물고기의 위치값과 비교하여 조건에 맞는 값을 재지정한다.
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
			// 같은 depth에 대하여 연산이 완료되면 이동거리를 하나 늘려준다.
			cnt++;
			// 만약 물고기를 먹었다면, 상어의 위치를 바꿔주고 총 이동거리에 현재 depth의 이동거리를 더해준다.
			if(eat(expectedFish)) {
				visited = sharkLocation(expectedFish);
				result += cnt;
				cnt = 0;
			}
		}
		return result;
	}
	// 먹을 수 있는지 판단하는 메서드
	public static boolean Eatable(int x, int y) {
		if(map[x][y] < sharkSize && map[x][y] != 0) {
			return true;
		}
		return false;
	}
	
	// 움직일 수 있는지 여부를 판단하는 메서드
	public static boolean Moveable(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		if(map[x][y] > sharkSize) {
			return false;
		}
		return true;
	}
	
	// 먹는 행동을 위한 메서드
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
	
	// 상어의 위치를 바꿔주는 메서드
	public static boolean[][] sharkLocation(fish expectedFish) {
		q.clear();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new int[] {expectedFish.x,expectedFish.y});
		visited[expectedFish.x][expectedFish.y] = true;
		return visited;
	}

}

