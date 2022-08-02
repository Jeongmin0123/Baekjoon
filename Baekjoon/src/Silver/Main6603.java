package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
	public static int N;
	public static int[] lotto;
	public static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 받아온 라인의 첫 숫자가 0인 경우 연산종료
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			// 받아온 라인의 숫자가 0이 아닌 경우, 번호 후보와 그 후보에 대해 사용되었는지에 대한 배열을 생성
			} else {
				lotto = new int[N];
				used = new boolean[N];
				for(int i = 0 ; i < N ; i++) {
					lotto[i] = Integer.parseInt(st.nextToken());
				}
				return_list(0,0);
			}
			System.out.println();
		}
	}
	
	public static void return_list(int depth, int start) {
		// 6개를 다 고른 경우에 고른 숫자들을 리턴한다.
		if(depth == 6) {
			for(int i = 0 ; i < N ; i++) {
				if(used[i]) {
					System.out.print(lotto[i] + " ");
				}
			}
			System.out.println();
		}
		// 재귀함수
		for(int i = start ; i < N ; i++) {
			used[i] = true;
			return_list(depth+1,i+1);
			used[i] = false;
		}
	}
}
