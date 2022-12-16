package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2342 {

	public static ArrayList<Integer> list;
	public static int[][][] dp;
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(true) {
			int input = Integer.parseInt(st.nextToken());
			if(input == 0) break;
			list.add(input);
		}
		N = list.size();
		dp = new int[N][5][5];
		int answer = calc(0,0,0);
		System.out.println(answer);
	}
	// Top - Down 방식
	public static int calc(int cnt, int left, int right) {
		//
		if(cnt == N) {
			return 0;
		}
		if(dp[cnt][left][right] != 0) {
			return dp[cnt][left][right];
		}
		// 현재 발위치를 기준으로 왼발으로 움직였을 때 점수
		int moveleft = score(left, list.get(cnt)) + calc(cnt+1, list.get(cnt), right);
		// 현재 발위치를 기준으로 오른발으로 움직였을 때 점수
		int moveright = score(right, list.get(cnt)) + calc(cnt+1, left, list.get(cnt));
		// 최소 힘을 초기화해준다.
		dp[cnt][left][right] = Math.min(moveleft, moveright);
		return dp[cnt][left][right];
	}
	// 시작점과 목표 지점을 기준으로 드는 힘을 구하는 메서드
	public static int score(int from, int to) {
		if(from == to) return 1;
		if(from == 0) return 2;
		if(Math.abs(from - to) == 2) return 4;
		return 3;
	}
}
