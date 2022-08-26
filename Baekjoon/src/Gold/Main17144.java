package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17144 {

	public static int R,C,T;
	public static int[][] map;
	public static int[][] dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int[][] dxdy2 = {{1,0},{0,1},{-1,0},{0,-1}};
	public static ArrayList<int[]> air;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		// ����û������ ��ġ�� �޾ƿ� �����Ѵ�.
		air = new ArrayList<>();
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air.add(new int[] {i,j});
				}
			}
		}
		Rotation(T);
		int sum = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	
	// Ȯ���� ���� �޼���
	public static void spread() {
		int[][] spreadMap = new int[R][C];
		for(int x = 0 ; x < R ; x++) {
			for(int y = 0 ; y < C ; y++) {
				int cnt = 0;
				for(int i = 0 ; i < 4 ; i++) {
					int dx = x + dxdy[i][0];
					int dy = y + dxdy[i][1];
					// ���鿡 ���Ͽ� Ȯ���� ������ ��ġ�� Ȯ�� ��Ų�ڿ� cnt�� 1 ������Ų��. �� ,cnt�� �� �������� Ȯ��� �ֺ� ������ �����̴�.
					if(isValid(dx,dy)) {
						spreadMap[dx][dy] += map[x][y]/5;
						cnt++;
					}
				}
				// Ȯ��ǰ� ���� ���� ���� ������ �־��ش�,
				map[x][y] -= (map[x][y]/5)*cnt;
			}
		}
		// ������ ��ġ�� Ȯ��� ���� ���� ������ ���� �����ش�.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				map[i][j] += spreadMap[i][j];
			}
		}
	
	}
	// �� �������� �����ϰ� �� ��ġ�� ����û���Ⱑ �ƴϸ� Ȯ�� �����ϴ�.
	public static boolean isValid(int x, int y) {
		if(x >= R || x < 0 || y < 0 || y >= C || map[x][y] == -1) return false;
		return true;
	}
	
	// �ѹ� �������� Ȯ����� �� �ڿ� ����û���� �� ĭ�� �������� ���Ʒ� ���� ȸ�������ش�
	public static void Rotation(int T) {
		for(int tc = 0 ; tc < T ; tc++) {
			spread();
			// ����û���Ⱑ ��ġ�ϴ� ���� ���� ���� x,y�� �־��ش�.
			int x = air.get(0)[0];
			int y = air.get(0)[1];
			int idx = 0;
			while(true) {
				if(idx == 4) break;
				int dx = x + dxdy[idx][0];
				int dy = y + dxdy[idx][1];
				// ȸ�� �����ϸ� x,y������ ��ĭ�� ����ش�.
				if(isValidRotation(dx, dy)) {
					map[x][y] = map[dx][dy];
					x = dx;
					y = dy;
				// �Ұ����ϸ� ȸ�� ������ �ٲ۴�.
				} else {
					idx++;
				}
			}
			// ȸ���� �� ������ ���� û������ ��ġ�� �ٽ� 0���� �ٲ��ְ�, ����û���⿡�� ���� ���� 0���� �ٲ��ش�.
			map[air.get(0)[0]][air.get(0)[1]] = -1;
			map[air.get(0)[0]][air.get(0)[1]+1] = 0;
			// ����û���Ⱑ ��ġ�ϴ� ���� �Ʒ��� ���� x,y�� �־��ش�.
			x = air.get(1)[0];
			y = air.get(1)[1];
			idx = 0;
			while(true) {
				if(idx == 4) break;
				int dx = x + dxdy2[idx][0];
				int dy = y + dxdy2[idx][1];
				// ȸ�� �����ϸ� x,y������ ��ĭ�� ����ش�.
				if(isValidRotation2(dx, dy)) {
					map[x][y] = map[dx][dy];
					x = dx;
					y = dy;
				// �Ұ����ϸ� ȸ�� ������ �ٲ۴�.
				} else {
					idx++;
				}
			}
			map[air.get(1)[0]][air.get(1)[1]] = -1;
			map[air.get(1)[0]][air.get(1)[1]+1] = 0;
		}
	}
	// ����û���� �� ĭ�� �������� ���� ������ ȸ�� ������ ��츦 �Ǵ��ϴ� �޼���
	public static boolean isValidRotation(int x, int y) {
		if(x > air.get(0)[0] || x < 0 || y < 0 || y >= C) return false;
		return true;
	}
	// ����û���� �� ĭ�� �������� �Ʒ��� ������ ȸ�� ������ ��츦 �Ǵ��ϴ� �޼���
	public static boolean isValidRotation2(int x, int y) {
		if(x < air.get(1)[0] || x >=R || y < 0 || y >= C) return false;
		return true;
	}
	
}

