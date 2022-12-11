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
		// 각각의 Row가 지나갈 수 있는 길인지 판단한다.
		for(int i = 0 ; i < N ; i++) {
			checkRow(i);
		}
		// 각각의 Column이 지나갈 수 있는 길인지 판단한다.
		for(int i = 0 ; i < N ; i++) {
			checkColumn(i);
		}
		System.out.println(result);
	}

	public static void checkRow(int r) {
		// 경사로가 설치되어 있는 칸인지 판단하는 배열
		boolean[] used = new boolean[N];
		for(int i = 0 ; i < N - 1 ; i++) {
			// 연결된 두 칸의 높이가 같은 경우, 경사로가 필요없으므로 넘어간다.
			if(map[r][i+1] == map[r][i]) continue;
			boolean check = true;
			// 앞의 칸이 뒤에 칸보다 높이가 낮은 경우를 고려한다.
			// 뒤에 칸을 기준으로 앞에 존재하는 L개의 칸을 고려해준다.
			for(int j = 0 ; j < L ; j++) {
				// 배열 내부에 존재하고, 둘 사이의 높이의 차가 1이고, 그 곳에 지어진 경사로가 없는 경우에 경사로를 놓을 수 있다.
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
			// 앞의 칸이 뒤에 칸보다 높이가 높은 경우를 고려한다.
			// 앞에 칸을 기준으로 뒤에 존재하는 L개의 칸을 고려해준다.
			for(int j = 1 ; j <= L ; j++) {
				// 배열 내부에 존재하고, 둘 사이의 높이의 차가 1이고, 그 곳에 지어진 경사로가 없는 경우에 경사로를 놓을 수 있다.
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
		// for문을 빠져나온 경우 지나갈 수 있는 길이므로 result값을 증가시킨다.
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
	// 배열 내부에 존재하는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}
}
