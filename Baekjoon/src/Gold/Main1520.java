package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1520 {
	public static int[][] count;
	public static int[][] arr;
	public static int M;
	public static int N;
	public static int[] rangeX = {1, 0,-1, 0};
	public static int[] rangeY = {0, 1, 0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M+1][N+1];
		count = new int[M+1][N+1];
		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				arr[i][j] = sc.nextInt();
				count[i][j] = -1;
			}
		}
		int result = check(1,1);
		System.out.println(result);
		
		
	}
	
	public static int check(int x, int y) {
		// ���ϴ� ������ �����ÿ� 1�� ��ȯ�ϰ� �����Ѵ�.
		// �߰��� �ٽ� ������ �ʿ䰡 ���� �����̴�.
		if(x == M && y == N) {
			return 1;
		}
		// -1�� �ƴ� ��� �̹� �湮�� ����̹Ƿ� ���� �湮���� ����
		// ���� ��ȯ�Ѵ�.
		if(count[x][y] != -1) {
			return count[x][y];
		} else {
			count[x][y] = 0;
			// �����¿� �����δ�.
			for(int i = 0 ; i < 4 ; i++) {
				int dx = x + rangeX[i];
				int dy = y + rangeY[i];
				// ������ �� ���� ������ ��� �Ѿ��.
				if(dx < 1 || dy < 1 || dx > M || dy > N) {
					continue;
				}
				// ���� ������ �κ��� ���ڰ� �� �۴ٸ�,
				// ����� ���� �߰��Ѵ�.
				if(arr[x][y] > arr[dx][dy]) {
					count[x][y] += check(dx,dy);
				}
			}
		}
		
		return count[x][y];
	}

}
