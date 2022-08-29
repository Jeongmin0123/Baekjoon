package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3190 {
	// ���� �����̴� ���⿡ ���� �迭
	public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	// ���� �����ϴ� ��ġ�� �����ϴ� List
	public static ArrayList<int []> snake;
	public static int N,K,L;
	public static int[][] map;
	// ����, ��� ������ �ٲٴ����� �����ϴ� List
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
		// �������� 0,0�̴�
		int x = 0;
		int y = 0;
		int time = 0;
		int d = 0;
		snake.add(new int[] {x,y});
		while(true) {
			time++;
			
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			
			// ������ ������ ���̶� �ε����� �ʰ�, map �ȿ� �����ϴ� ��쿡�� ������ �����Ѵ�.
			if(!isValid(dx,dy)) {
				break;
			}
			// ���� ������ ������ ����� �����ϸ� ����� �԰� Ŀ�� ���� ���� �����Ѵ�.
			if(map[dx][dy] == 1) {
				map[dx][dy] = 0;
				snake.add(new int[] {dx,dy});
			// ����� ������ �׳� ���� �ű��.
			} else {
				snake.add(new int[] {dx,dy});
				snake.remove(0);
			}
			// ���̻� ������ȯ�� ���� ������ ������ȯ�� �����Ѵ�.
			if(change.size() != 0) {
				// �־��� ������ȯ �ð��� ���� �ð��� ������ �־��� ���ڰ��� ���� ������ ��ȯ�Ѵ�. 
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
	
	// ������ �� �ִ��� �Ǵ��ϴ� �Լ�
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >=N) return false;
		for(int i = 0 ; i < snake.size() ; i++) {
			int[] temp = snake.get(i);
			if(temp[0] == x && temp[1] == y) return false;
		}
		return true;
	}
}
