package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3190 {
	// 뱀이 움직이는 방향에 대한 배열
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	// 뱀이 존재하는 위치를 저장하는 List
	public static ArrayList<int []> snake;
	public static int N,K,L;
	public static int[][] map;
	// 언제, 어떻게 방향을 바꾸는지를 저장하는 List
	public static ArrayList<String []> change; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		snake = new ArrayList<>();
		change = new ArrayList<>();
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken()) - 1;
			int column = Integer.parseInt(st.nextToken()) - 1;
			map[row][column] = 1;
		}
		L = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < L ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			change.add(new String[] {st.nextToken(), st.nextToken()});
		}
		int result = bfs();
		System.out.println(result);
	}
	
	public static int bfs() {
		// 시작점은 0,0이다
		int x = 0;
		int y = 0;
		int time = 0;
		int d = 0;
		snake.add(new int[] {x,y});
		while(true) {
			time++;
			
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			
			// 움직인 지점이 몸이랑 부딪히지 않고, map 안에 존재하는 경우에만 연산을 진행한다.
			if(!isValid(dx,dy)) {
				break;
			}
			// 만약 움직인 지점에 사과가 존재하면 사과를 먹고 커진 뱀의 몸을 저장한다.
			if(map[dx][dy] == 1) {
				map[dx][dy] = 0;
				snake.add(new int[] {dx,dy});
			// 사과가 없으면 그냥 뱀을 옮긴다.
			} else {
				snake.add(new int[] {dx,dy});
				snake.remove(0);
			}
			// 더이상 방향전환이 없을 때까지 방향전환을 진행한다.
			if(change.size() != 0) {
				// 주어진 방향전환 시간과 현재 시간이 같으면 주어진 문자값에 따라 방향을 전환한다. 
				if(change.get(0)[0].equals(Integer.toString(time))) {
					if(change.get(0)[1].equals("D")) {
						d++;
						if(d == 4) d = 0;
					} else {
						d--;
						if(d == -1) d = 3;
					}
					change.remove(0);
				}
			}
			x = dx;
			y = dy;
		}
		return time;
	}
	
	// 움직일 수 있는지 판단하는 함수
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >=N) return false;
		for(int i = 0 ; i < snake.size() ; i++) {
			int[] temp = snake.get(i);
			if(temp[0] == x && temp[1] == y) return false;
		}
		return true;
	}
}
