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
		// �̴׸����� Ÿ�ڵ��� Ÿ�� ���
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

	// Ÿ���� ���ϴ� Permutation �޼���
	public static void Perm(int cnt) {
		// Ÿ���� �� ���ϸ� �� Ÿ������ �������� ��, ������ ������ ��ȯ�ϴ� �޼��带 �����Ѵ�.
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

	// Ÿ���� ���� ������ ���Ͽ� �� ���� ���� �ִ� �������� �ٲ��ش�.
	public static void calc() {
		// �� Ÿ������ ���� �� �޴� ����
		int sum = 0;
		// ���� Ÿ���� �� Ÿ���� ��ȣ
		int now = 0;
		for (int i = 0; i < N; i++) {
			// �� �̴��� �ƿ�ī��Ʈ 0���� �����Ѵ�.
			int outCount = 0;
			// �� base�� ���ڰ� �ִ��� �����ϴ� �迭
			boolean[] bases = new boolean[4];
			// �ƿ� ī��Ʈ�� 3�� �Ǹ� ������ �����Ѵ�.
			while (outCount < 3) {
				// ���� Ÿ���� �� ������ Ÿ�� ����
				int hitter = battingList[i][order[now]];
				switch (hitter) {
				// �ƿ�
				case 0:
					outCount++;
					break;
				// 1��Ÿ
				case 1:
					// 1��Ÿ�� ���, 3�� ���ڸ� Ȩ�� ������, �������� 1�� �����Ѵ�.
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
				// 2��Ÿ
				case 2:
					// 2��Ÿ�� ���, 2,3�� ���ڸ� Ȩ�� ������, �������� 2�� �����Ѵ�.
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
				// 3��Ÿ
				case 3:
					// 3��Ÿ�� ���, ��� ���ڸ� Ȩ�� ������, Ÿ�ڴ� 3�� �����Ѵ�.
					for (int k = 3; k >= 1; k--) {
						if (bases[k]) {
							sum++;
							bases[k] = false;
						}
					}
					bases[3] = true;
					break;
				// Ȩ��
				case 4:
					for(int k = 3 ; k >= 1 ; k--) {
						// ��� ���ڸ� �ҷ����̰�, Ÿ�ڵ� ���´�.
						if(bases[k]) {
								sum++;
								bases[k] = false;
						}
					}
					sum++;
					break;
				}
				// Ÿ���� �ѱ��.
				now++;
				if (now == 9)
					now = 0;
			}
		}
		score = Math.max(sum, score);
	}
}