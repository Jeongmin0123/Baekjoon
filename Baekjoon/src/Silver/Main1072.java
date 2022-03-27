package Silver;

import java.util.Scanner;

public class Main1072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		long Y = sc.nextLong();
		long Z = (Y*100)/X;
		// Z�� 99���� ũ�ų� ������ �ƹ��� Ƚ���� �����ص� 100���� �� �̻��� �� �� �����Ƿ� -1�� ���
		if(Z>=99) {
			System.out.println(-1);
		} else {
			// Y���� ������ 0���� X���� �̹Ƿ� ���۰��� 0 ������ 1000000000�� �д�.
			long start = 0;
			long mid = 0;
			long end = 1000000000;
			// �������� �������� ū ���������� ������
			while(start <= end) {
				// �߰����� ���۰� ������ �߰����� ��´�.
				mid = (start+end)/2;
				if(Z < 100*(Y+mid)/(X+mid)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			// �ּҰ��� ����ؾ� �ϹǷ� start�� ����Ѵ�.
			System.out.println(start);
		}
	}

}
