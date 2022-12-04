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
	// 배열의 (0,0)부터 (9,9)까지 규칙을 만족하는 숫자를 채워주는 메서드
	public static void dfs(int r, int c) {
		// 한 행의 끝까지 숫자를 넣어줬다면 다음 행을 고려해준다.
		if(c == 9) {
			dfs(r+1,0);
			return;
		}
		// 모든 행에 숫자를 다 넣어줬다면 그 결과를 출력한다.
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
				// 비어있는 칸에 1 ~ 9까지의 숫자를 넣어주고 만약 그 숫자가 규칙을 만족한다면 같은 행의 다음 열 숫자를 채워준다.
				map[r][c] = num;
				if(rowCheck(r,c) && columnCheck(r,c) && squareCheck(r,c)) {
					dfs(r,c+1);
				}
			}
			// 넣어준 숫자가 규칙을 만족하지 못하는 경우 잘못된 경우이므로 원래대로 되돌린다.
			map[r][c] = 0;
			return;
		}
		// 이미 숫자가 채워져있는경우 다음 열 숫자를 고려한다.
		dfs(r,c+1);
	}
	// 넣어준 숫자가 가로 규칙을 만족하는 판단하는 메서드
	public static boolean rowCheck(int r, int c) {
		for(int i = 0 ; i < 9 ; i++) {
			if(i == c) continue;
			if(map[r][c] == map[r][i]) {
				return false;
			}
		}
		return true;
	}
	// 넣어준 숫자가 세로 규칙을 만족하는 판단하는 메서드
	public static boolean columnCheck(int r, int c) {
		for(int i = 0 ; i < 9 ; i++) {
			if(i == r) continue;
			if(map[r][c] == map[i][c]) {
				return false;
			}
		}
		return true;
	}
	// 넣어준 숫자가 3X3 사각형 규칙을 만족하는 판단하는 메서드
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
