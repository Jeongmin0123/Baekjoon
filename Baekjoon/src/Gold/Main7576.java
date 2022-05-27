package Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ��ǥ�� �����ϴ� class
class dot{
	int x;
	int y;
	dot(int x,int y) {
		this.x = x;
		this.y = y;
  	}
}

public class Main7576 {
	public static int[] dx = { 0, 0, 1,-1};
	public static int[] dy = {-1, 1, 0, 0};
	public static int M;
	public static int N;
	public static Queue<dot> cal;
	public static int[][] tomato;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		tomato = new int[N][M];
		// �丶�䰡 ���� ������ ��ǥ�� �����ϴ� queue
		cal = new LinkedList<dot>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				tomato[i][j] = sc.nextInt();
				// ���� �丶�䰡 �;��ٸ� queue�� �߰��Ѵ�.
				if(tomato[i][j] == 1) {
					cal.add(new dot(i,j));
				}
			}
		}
		System.out.println(dfs());
	}
	// ��� ���� �������� �ּ� ��¥�� ����ϴ� �Լ�
	public static int dfs() {
		while(!cal.isEmpty()) {
			// ���� �丶���� ��ġ�� �޴´�.
			dot temp = cal.remove();
			// ���� �丶���� �����¿쿡 �������� �丶�䰡 �ִ��� Ȯ���Ѵ�.
			for(int i = 0 ; i < 4 ; i++) {
				int new_x = temp.x + dx[i];
				int new_y = temp.y + dy[i];
				if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < M) {
					// �����¿쿡 �������� �丶�䰡 �ִ� ��� queue �߰��ϰ� ���� �;����� �˱� ���ؼ�
					// ������ �� �丶���� ���� 1�� ���Ѵ�.
					if(tomato[new_x][new_y] == 0) {
						cal.add(new dot(new_x, new_y));
						tomato[new_x][new_y] = tomato[temp.x][temp.y]+1;
					}
				}
			}
		}
		int result = -1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(tomato[i][j] == 0) {
					return -1;
				} else {
					result = Math.max(result, tomato[i][j]);
				}
			}
		}
		return result - 1;
	}	
}