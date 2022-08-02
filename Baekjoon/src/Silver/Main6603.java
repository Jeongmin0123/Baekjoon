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
			
			// �޾ƿ� ������ ù ���ڰ� 0�� ��� ��������
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			// �޾ƿ� ������ ���ڰ� 0�� �ƴ� ���, ��ȣ �ĺ��� �� �ĺ��� ���� ���Ǿ������� ���� �迭�� ����
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
		// 6���� �� �� ��쿡 �� ���ڵ��� �����Ѵ�.
		if(depth == 6) {
			for(int i = 0 ; i < N ; i++) {
				if(used[i]) {
					System.out.print(lotto[i] + " ");
				}
			}
			System.out.println();
		}
		// ����Լ�
		for(int i = start ; i < N ; i++) {
			used[i] = true;
			return_list(depth+1,i+1);
			used[i] = false;
		}
	}
}
