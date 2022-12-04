package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2580 {
	
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for(int i = 0 ; i < 9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
	}
	// �迭�� (0,0)���� (9,9)���� ��Ģ�� �����ϴ� ���ڸ� ä���ִ� �޼���
	public static void dfs(int r, int c) {
		// �� ���� ������ ���ڸ� �־���ٸ� ���� ���� ������ش�.
		if(c == 9) {
			dfs(r+1,0);
			return;
		}
		// ��� �࿡ ���ڸ� �� �־���ٸ� �� ����� ����Ѵ�.
		if(r == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(map[r][c] == 0) {
			for(int num = 1 ; num <= 9 ; num++) {
				// ����ִ� ĭ�� 1 ~ 9������ ���ڸ� �־��ְ� ���� �� ���ڰ� ��Ģ�� �����Ѵٸ� ���� ���� ���� �� ���ڸ� ä���ش�.
				map[r][c] = num;
				if(rowCheck(r,c) && columnCheck(r,c) && squareCheck(r,c)) {
					dfs(r,c+1);
				}
			}
			// �־��� ���ڰ� ��Ģ�� �������� ���ϴ� ��� �߸��� ����̹Ƿ� ������� �ǵ�����.
			map[r][c] = 0;
			return;
		}
		// �̹� ���ڰ� ä�����ִ°�� ���� �� ���ڸ� ����Ѵ�.
		dfs(r,c+1);
	}
	// �־��� ���ڰ� ���� ��Ģ�� �����ϴ� �Ǵ��ϴ� �޼���
	public static boolean rowCheck(int r, int c) {
		for(int i = 0 ; i < 9 ; i++) {
			if(i == c) continue;
			if(map[r][c] == map[r][i]) {
				return false;
			}
		}
		return true;
	}
	// �־��� ���ڰ� ���� ��Ģ�� �����ϴ� �Ǵ��ϴ� �޼���
	public static boolean columnCheck(int r, int c) {
		for(int i = 0 ; i < 9 ; i++) {
			if(i == r) continue;
			if(map[r][c] == map[i][c]) {
				return false;
			}
		}
		return true;
	}
	// �־��� ���ڰ� 3X3 �簢�� ��Ģ�� �����ϴ� �Ǵ��ϴ� �޼���
	public static boolean squareCheck(int r, int c) {
		int rowStart = (r/3)*3;
		int columnStart = (c/3)*3;
		for(int i = rowStart ; i < rowStart + 3 ; i++) {
			for(int j = columnStart ; j < columnStart + 3 ; j++) {
				if(r == i && c == j) continue;
				if(map[r][c] == map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
