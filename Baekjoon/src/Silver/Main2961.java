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
	
	// ��� ������ ���Ͽ� �κ������� ���� �� �� �κ����տ��� �Ÿ��� ������ ���� ���� ���� ���� ���ϴ� �޼���
	public static void subset(int idx, int input_count) {
		// ������ ������ �� ����� ���
		if(idx == N) {
			// �ƹ��͵� �ȳ��� ��츦 ����.
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
		// ��͸� �̿��Ͽ� ������ Ǭ��.
		used[idx] = true;
		subset(idx+1, input_count+1);
		used[idx] = false;
		subset(idx+1, input_count);
	}

}
