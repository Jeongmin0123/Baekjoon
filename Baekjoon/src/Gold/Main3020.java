package Gold;

import java.util.Scanner;

public class Main3020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		// ������ ���̿� ���� ������ ����
		int[] bottom = new int[H+1];
		// ������ ���̿� ���� �������� ����
		int[] top = new int[H+1];
		for(int i = 0 ; i < N/2 ; i++) {
			// �޾ƿ� ������ �������� ���� ������ ������Ų��.
			bottom[sc.nextInt()]++;
			top[sc.nextInt()]++;			
		}
		// ���̰� i������ �������� ������ ���� ���� �����ϴ� �迭�� �����.
		int[] bot_sum = new int[H+1];
		int[] top_sum = new int[H+1];
		for(int i = 0 ; i < H ; i++) {
			bot_sum[i+1] = bot_sum[i] + bottom[i+1];
			top_sum[i+1] = top_sum[i] + top[i+1];
		}
		int min = N;
		int count = 0;
		for(int i = 1 ; i < H+1 ; i++) {
			// �ε����� Ƚ��
			int crush = 0;
			// i�������� ������ �ε����� Ƚ���� ��ü ������ �������� ���̰� i-1������ ������ ������ �� �Ͱ� ����.
			crush += bot_sum[H] - bot_sum[i-1];
			// i�������� �������� �ε����� Ƚ���� ��ü �������� �������� ���̰� H-i������ �������� ������ �� �Ͱ� ����.
			crush += top_sum[H] - top_sum[H-i];
			// min������ �浹���� ũ�� min���� �ٲٰ� ������ 1�� �����Ѵ�.
			if(min > crush) {
				min = crush;
				count = 1;
				// min���� �浹���� ������ ������ ������Ų��.
			} else if (min == crush) {
				count++;
			}
		}
		System.out.println(min + " " + count);
	}
}
