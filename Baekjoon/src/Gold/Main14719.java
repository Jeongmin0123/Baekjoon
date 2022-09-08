package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719 {
	
	public static int H,W;
	public static int[] block;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		block = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < W ; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;	// �����
		for(int i = 1 ; i < W - 1 ; i++) {	// �� ���ʰ� �� �������� ������� �ʾƵ� �ȴ�.
			int left = 0;
			int right = 0;
			// ���� ��ġ���� ���ʿ� �ִ� ���� �� ���̰� ���� ū ���� �����´�.
			for(int j = 0 ; j < i ; j ++) {
				left = Math.max(block[j], left);
			}
			// ���� ��ġ���� �����ʿ� �ִ� ���� �� ���̰� ���� ū ���� �����´�.
			for(int j = i + 1 ; j < W ; j++) {
				right = Math.max(block[j], right);
			}
			// ���� ��ġ�� ���� ����
			int now = block[i];
			// ���� ��ġ�� ���� ���� �������� ���� �� ���̰� ���� ū ������ ������ ������ ���δ�.
			if(now < left && now < right) {
				sum += Math.min(left, right) - now;
			}
		}
		System.out.println(sum);
	}
}
