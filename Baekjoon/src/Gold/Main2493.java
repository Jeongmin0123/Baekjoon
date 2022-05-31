package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> check = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// ���� 17298���� ����� Ǯ��
		// �ڽ��� �������� ���ʿ� �ڽź��� ū ���� ������ ��� �� index���� +1 �� ���� ������.
		for(int i = N-1 ; i >= 0 ;i--) {
			while(!check.isEmpty() && num[check.peek()] < num[i]) {
				num[check.pop()] = i+1;
			}
			check.push(i);
		}
		while(!check.isEmpty()) {
			num[check.pop()] = 0;
		}
		// String�� for���� ���ؼ� ��� �����ִ� ������� ������ Ǯ�� �ð��ʰ��� �߻��ϹǷ� StringBuilder�� ����Ѵ�. 
		for(int i = 0 ; i < N ; i++) {
			sb.append(num[i]).append(' ');
		}
		System.out.println(sb);
		br.close();
	}

}
