package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136 {

	public static int[][] map;
	public static int[] count = {0,5,5,5,5,5};
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for(int i = 0 ; i < 10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(0,0,0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	// 백트래킹
	public static void dfs(int r, int c, int cnt) {
		// map의 모든 지점을 다 탐색한 경우, answer 값을 초기화한다.
		if(r == 9 && c > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		// answer 값이 cnt보다 작거나 같은 경우, 최소 개수를 넘어가기 때문에 더 이상 연산할 필요가 없다.
		if(answer <= cnt) return;
		if(c > 9) {
			dfs(r+1, 0, cnt);
			return;
		}
		// 주어진 좌표가 1인 경우 색종이를 붙일 수 있다.
		if(map[r][c] == 1) {
			// 크기가 큰 색종이를 먼저 붙이는 경우, 백트래킹을 통해 연산을 크게 줄일 수 있으므로 큰 색종이 먼저 붙인다.
			for(int i = 5 ; i > 0 ; i--) {
				// 색종이가 남아있고, 그 색종이를 붙일 수 있는 경우 색종이를 붙이고 dfs 탐색을 진행한 뒤 다시 색종이를 떼준다.
				if(count[i] > 0 && canAttach(r,c,i)) {
					Attach(r,c,i,0);
					count[i]--;
					dfs(r,c+1,cnt+1);
					Attach(r,c,i,1);
					count[i]++;
				}
			}
		// 주어진 좌표가 0인 경우 색종이를 붙일 수 없으므로 다음 좌표로 넘어간다.
		} else {
			dfs(r,c+1,cnt);
		}
	}
	// 색종이를 붙이거나 떼는 메서드, num 값이 0이면 색종이를 붙여 그 위치를 0으로 보이도록 하고
	// num 값이 1이면 색종이를 떼서 그 위치를 1로 보이도록 하는 메서드
	public static void Attach(int r, int c, int size, int num) {
		for(int i = r ; i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				map[i][j] = num;
			}
		}
	}
	
	// 그 좌표가 배열 내부에 존재하는 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= 10 || c >= 10) return false;
		return true;
	}
	
	// 크기가 size인 색종이를 r,c에 붙일 수 있는지 판단하는 메서드
	public static boolean canAttach(int r, int c, int size) {
		for(int i = r ; i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				if(!isValid(i,j) || map[i][j] == 0) return false;
			}
		}
		return true;
	}

}
