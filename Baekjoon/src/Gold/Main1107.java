package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1107 {
	public static void main(String[] args) {
		// ���峭 ��ư���� �����ϴ� ArrayList�� �����.
		ArrayList<Integer> broken = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int k = sc.nextInt();
			broken.add(k);
		}
		// +,- ��ư���� �����̴� ���
		int ans = Math.abs(N-100);
		// N�� 500000�����̹Ƿ� 6�ڸ����� �����ϹǷ� ���� ū 6�ڸ� ���ڸ� min�� �����Ѵ�.
		int min = 999999;
		// ���ڸ� �Է��� �� +,-�� �������� �� ��ư�� ���� Ƚ��
		int count = 0;
		for(int i = 0 ; i < 999999 ; i++) {
			boolean check = true;
			String temp = String.valueOf(i);
			for(int j = 0 ; j < temp.length() ; j++) {
				// temp.charAt�� char���·� ��ȯ�ϹǷ� 0�� ���ش�
				if(broken.contains(temp.charAt(j)-'0')) {
					check = false;
					break;
				}
			}
			if(check == false) continue;
			// ���� ����Ƚ�� + ���� ���ڿ��� ���������� +,-�� �� �� Ƚ��
			count = temp.length() + Math.abs(i-N);
			if(count < min) {
				min = count;
			}
		}
		if(min < ans) {
			ans = min;
		}
		System.out.println(ans);
		sc.close();
	}
}
