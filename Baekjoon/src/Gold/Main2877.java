package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2877 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 10������ 2������ �ٲ� ���� ������ ������� ������ �����Ѵ�.
		
		while(N != 0) {
			// ���ڸ� ������ ������ ���鼭 2�� �������� ���� �������� 4�� 7�� �����Ѵ�.
			if(N%2 == 0) {
				sb.append("7");
			} else {
				sb.append("4");
			}
			// 2������ 010 == 10 �� �ſ� �ٸ��� 474 != 74 �̹Ƿ� �̸� �ذ��ϱ� ���� 1�� ���صڿ� 2�� �������ش�
			N = (N-1)/2;
		}
		// �� �������� ���ڰ� �ں��� �����Ƿ� �̸� �������ش�.
		StringBuilder result = new StringBuilder();
		for(int i = sb.length() - 1 ; i >= 0 ; i--) {
			result.append(sb.charAt(i));
		}
		System.out.println(result);
	}
}