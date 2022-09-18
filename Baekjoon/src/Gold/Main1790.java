package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1790 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 1�ڸ� ��, 2�ڸ� ��, 3�ڸ� ���� ������ ����
		long count = 9;
		// 1�ڸ� ��, 2�ڸ� ��, 3�ڸ� �� �� �ڸ����� ����
		long length = 1;
		// ã�� ���ڸ� �����ϴ� ����
		long containNumber = 0;
		while(K > count * length) {
			// i��° �ڸ����� ������ ������ ������ �� ������ �ڸ����� ���� ���ش�
			K -= count * length;
			containNumber += count;
			// �ڸ����� ���ڸ� �÷��ش�.
			count *= 10;
			length++;
		}
		
		containNumber += (K - 1)/length + 1;
		// �����ϰ� �ִ� ���ڰ� N�� ������ �Ұ����ϹǷ� -1 ���
		if(containNumber > N) {
			System.out.println(-1);
		} else {
			// �����ϰ� �ִ� ���ڿ����� �ڸ����� ���ؼ� ���� return�Ѵ�.
			int index = (int) ((K-1)%length);
			System.out.println(String.valueOf(containNumber).charAt(index));
		}
	}

}
