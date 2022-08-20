package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {

	public static int R,C;
	public static char[][] map;
	public static boolean[] used = new boolean[26];
	public static int[] moveX = {-1,1,0,0};
	public static int[] moveY = {0,0,-1,1};
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		used[map[0][0] - 'A'] = true;
		dfs(0,0,1);
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		for(int i = 0 ; i < 4 ; i++) {
			int dx = x + moveX[i];
			int dy = y + moveY[i];
			if(isValid(dx,dy) && !used[map[dx][dy]-'A']) {
				used[map[dx][dy]-'A'] = true;
				dfs(dx,dy,cnt+1);
				used[map[dx][dy]-'A'] = false;
			}
		}
		answer = Math.max(answer, cnt);
	}
	
	public static boolean isValid(int x, int y) {
		if(x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

}

