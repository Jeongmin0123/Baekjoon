package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
	public static int N,L;
	public static int[][] map;
	public static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ������ Row�� ������ �� �ִ� ������ �Ǵ��Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			checkRow(i);
		}
		// ������ Column�� ������ �� �ִ� ������ �Ǵ��Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			checkColumn(i);
		}
		System.out.println(result);
	}

	public static void checkRow(int r) {
		// ���ΰ� ��ġ�Ǿ� �ִ� ĭ���� �Ǵ��ϴ� �迭
		boolean[] used = new boolean[N];
		for(int i = 0 ; i < N - 1 ; i++) {
			// ����� �� ĭ�� ���̰� ���� ���, ���ΰ� �ʿ�����Ƿ� �Ѿ��.
			if(map[r][i+1] == map[r][i]) continue;
			boolean check = true;
			// ���� ĭ�� �ڿ� ĭ���� ���̰� ���� ��츦 ����Ѵ�.
			// �ڿ� ĭ�� �������� �տ� �����ϴ� L���� ĭ�� ������ش�.
			for(int j = 0 ; j < L ; j++) {
				// �迭 ���ο� �����ϰ�, �� ������ ������ ���� 1�̰�, �� ���� ������ ���ΰ� ���� ��쿡 ���θ� ���� �� �ִ�.
				if(isValid(r, i-j) && map[r][i-j] - map[r][i+1] == -1 && !used[i-j]) continue;
				check = false;
				break;
			}
			if(check) {
				for(int j = 0 ; j < L ; j++) {
					used[i-j] = true;
				}
				continue;
			}
			check = true;
			// ���� ĭ�� �ڿ� ĭ���� ���̰� ���� ��츦 ����Ѵ�.
			// �տ� ĭ�� �������� �ڿ� �����ϴ� L���� ĭ�� ������ش�.
			for(int j = 1 ; j <= L ; j++) {
				// �迭 ���ο� �����ϰ�, �� ������ ������ ���� 1�̰�, �� ���� ������ ���ΰ� ���� ��쿡 ���θ� ���� �� �ִ�.
				if(isValid(r, i+j) && map[r][i+j] - map[r][i] == -1 && !used[i+j]) continue;
				check = false;
				break;
			}
			if(check) {
				for(int j = 1 ; j <= L ; j++) {
					used[i+j] = true;
				}
				continue;
			}
			return;
		}
		// for���� �������� ��� ������ �� �ִ� ���̹Ƿ� result���� ������Ų��.
		result++;
	}
	public static void checkColumn(int c) {
		boolean[] used = new boolean[N];
		for(int i = 0 ; i < N - 1 ; i++) {
			if(map[i+1][c] == map[i][c]) continue;
			boolean check = true;
			for(int j = 0 ; j < L ; j++) {
				if(isValid(i-j, c) && map[i-j][c] - map[i+1][c] == -1 && !used[i-j]) continue;
				check = false;
				break;
			}
			if(check) {
				for(int j = 0 ; j < L ; j++) {
					used[i-j] = true;
				}
				continue;
			}
			check = true;
			for(int j = 1 ; j <= L ; j++) {
				if(isValid(i+j, c) && map[i+j][c] - map[i][c] == -1 && !used[i+j]) continue;
				check = false;
				break;
			}
			if(check) {
				for(int j = 1 ; j <= L ; j++) {
					used[i+j] = true;
				}
				continue;
			}
			return;
		}
		result++;
	}
	// �迭 ���ο� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}
}
