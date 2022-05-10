package Gold;

import java.util.Scanner;

public class Main2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// i ���� ����� ���� ����� ������ �迭
		int[] way = new int[K+1];
		// ������ ���� �׵���� 1�� �д�.
		way[0] = 1;
		// ���� ������ ���ο� ������ �޾ƿ´�.
		// ù ��° for�� ���꿡���� �� ���� �������θ�, �� ��°������ 2����, .... n��°������ n���� �������� k���� �����.
		for(int i = 0 ; i < N ; i++) {
			int coin = sc.nextInt();
			for(int j = 1 ; j <= K ; j++) {
				if(j >= coin) {
					way[j] += way[j - coin];
				}
			}
		}
		System.out.println(way[K]);
	}

}
