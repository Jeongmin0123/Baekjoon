package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17281 {
	public static int N;
	public static int[][] battingList;
	public static boolean[] used = new boolean[9];
	public static int[] order = new int[9];
	public static int score = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 이닝마다의 타자들의 타석 결과
		battingList = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				battingList[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order[3] = 0;
		used[3] = true;
		Perm(1);
		System.out.println(score);
	}

	// 타순을 정하는 Permutation 메서드
	public static void Perm(int cnt) {
		// 타순을 다 정하면 그 타순으로 진행했을 때, 나오는 점수를 반환하는 메서드를 수행한다.
		if (cnt == 9) {
			calc();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;
			order[i] = cnt;
			used[i] = true;
			Perm(cnt + 1);
			used[i] = false;
		}
	}

	// 타순에 따른 득점을 구하여 그 값에 따라 최대 점수값을 바꿔준다.
	public static void calc() {
		// 현 타순으로 진행 시 받는 점수
		int sum = 0;
		// 현재 타석에 들어선 타자의 번호
		int now = 0;
		for (int i = 0; i < N; i++) {
			// 매 이닝은 아웃카운트 0에서 시작한다.
			int outCount = 0;
			// 각 base에 주자가 있는지 저장하는 배열
			boolean[] bases = new boolean[4];
			// 아웃 카운트가 3이 되면 연산을 종료한다.
			while (outCount < 3) {
				// 현재 타석에 들어선 선수의 타석 정보
				int hitter = battingList[i][order[now]];
				switch (hitter) {
				// 아웃
				case 0:
					outCount++;
					break;
				// 1루타
				case 1:
					// 1루타의 경우, 3루 주자만 홈에 들어오고, 나머지는 1루 진루한다.
					for (int k = 3; k >= 1; k--) {
						if (bases[k]) {
							if (k == 3) {
								sum++;
								bases[3] = false;
								continue;
							}
							bases[k] = false;
							bases[k + 1] = true;
						}
					}
					bases[1] = true;
					break;
				// 2루타
				case 2:
					// 2루타의 경우, 2,3루 주자만 홈에 들어오고, 나머지는 2루 진루한다.
					for (int k = 3; k >= 1; k--) {
						if (bases[k]) {
							if (k >= 2) {
								sum++;
								bases[k] = false;
								continue;
							}
							bases[k] = false;
							bases[k + 2] = true;
						}
					}
					bases[2] = true;
					break;
				// 3루타
				case 3:
					// 3루타의 경우, 모든 주자만 홈에 들어오고, 타자는 3루 진루한다.
					for (int k = 3; k >= 1; k--) {
						if (bases[k]) {
							sum++;
							bases[k] = false;
						}
					}
					bases[3] = true;
					break;
				// 홈런
				case 4:
					for(int k = 3 ; k >= 1 ; k--) {
						// 모든 주자를 불러들이고, 타자도 들어온다.
						if(bases[k]) {
								sum++;
								bases[k] = false;
						}
					}
					sum++;
					break;
				}
				// 타순을 넘긴다.
				now++;
				if (now == 9)
					now = 0;
			}
		}
		score = Math.max(sum, score);
	}
}