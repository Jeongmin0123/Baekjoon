package Gold;

import java.util.Scanner;

public class Main2166 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ��ǥ�� �޾ƿ´�. �̶� N+1�� �޾ƿ��� ������ ���Ŀ� �Ź߲� ������ ����ϱ� �����̴�.
		// ���� ���� ����� ���� �迭�� ������ ���� �迭�� ù ���� �־��ش�.
		long[][] coordi = new long[N+1][2];
		for(int i = 0 ; i < N ; i++) {
			coordi[i][0] = sc.nextLong();
			coordi[i][1] = sc.nextLong();			
		}
		// �迭�� �� ������ ���� �迭�� �� ù���� �־��ش�.
		coordi[N] = coordi[0].clone();
		area(coordi);
	}
	// �Ź߲� ������ �̿��Ͽ� ���̸� ���ϴ� �޼���
	public static void area(long[][] coordi) {
		long sum1 = 0L;
		long sum2 = 0L;
		for(int i = 0 ; i < coordi.length - 1 ; i++) {
			sum1 += coordi[i][0]*coordi[i+1][1];
			sum2 += coordi[i+1][0]*coordi[i][1];
		}
		System.out.println(String.format("%.1f", Math.abs(sum1 - sum2) / 2D));
		
	}
}
