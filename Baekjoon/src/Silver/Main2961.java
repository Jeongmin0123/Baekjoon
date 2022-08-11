package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961 {

	public static int answer = Integer.MAX_VALUE;
	public static int N;
	public static int[] sour;
	public static int[] bitter;
	public static boolean[] used;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		used = new boolean[N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		subset(0,0);
		System.out.println(answer);
	}
	
	// 모든 재료들의 대하여 부분집합을 구한 뒤 그 부분집합에서 신맛과 쓴맛의 차가 가장 작은 값을 구하는 메서드
	public static void subset(int idx, int input_count) {
		// 마지막 재료까지 다 고려한 경우
		if(idx == N) {
			// 아무것도 안넣은 경우를 뺀다.
			if(input_count != 0) {
				int temp_sour = 1;
				int temp_bitter = 0;
				for(int i = 0 ; i < N ; i++) {
					if(used[i]) {
						temp_sour *= sour[i];
						temp_bitter += bitter[i];
					}
				}
				answer = Math.min(answer, Math.abs(temp_sour-temp_bitter));
			}
			return;
		}
		// 재귀를 이용하여 문제를 푼다.
		used[idx] = true;
		subset(idx+1, input_count+1);
		used[idx] = false;
		subset(idx+1, input_count);
	}

}
