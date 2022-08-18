package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109 {

	public static int[] moveX = {-1,0,1};
	public static int R,C;
	public static char[][] map;
	public static int answer;
	public static void main(String[] args) throws IOException {
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
		for(int i = 0 ; i < R ; i++) {
			dfs(i,0);
		}
		System.out.println(answer);
	}
	
	// 빵집의 개수를 구하는 dfs 메서드
	public static boolean dfs(int x, int y) {
		// 다 이동한 경우에 파이프라인을 하나 추가해준다.
		if(y == C-1) {
			answer++;
			return true;
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			int dx = x + moveX[i];
			int dy = y + 1;
			// 배열의 범위 내에 없거나 이동한 좌표의 x 인경우는 제외한다.
			if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
			if(map[dx][dy] == 'x') continue;
			
			map[dx][dy] = 'x';
			
			// 가지치기
			// 이동한 곳 또한 조건을 만족할 시에만 연산이 계속된다.
			if(dfs(dx,dy)) return true;
		}
		return false;
	}
}

