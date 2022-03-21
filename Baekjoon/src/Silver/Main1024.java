package Silver;

import java.util.Scanner;

public class Main1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		sum_check(N,L);
	}
	// ������ ���� ��ȯ�ϴ� �Լ�
	public static void sum_check(int N, int L) {
		// L�� 2���� ũ�� 100���� �۰ų� �����Ƿ�
		// ù��° for���� L�� 2���� ũ�� 100���� �۰ų� ���� ������ 2���� 100���� �����Ѵ�.
		for(int i = L ; i <= 100 ; i++) {
			// ���� N�̸鼭 ���̰� i�� ������ ù° ���� a��� �θ�
			// a*i + i*(i-1)/2 = N��� ���� ���� �� �ִ�.
			// ���� a�� a*i + i*(i-1)/2 <= N�� �������� �������Ѱ��� ������ �����Ѵ�.
			for(int a = 0 ; a*i + i*(i-1)/2 <= N ; a++) {
				// ���� a*i + i*(i-1)/2 == N�� ���, �츮�� ���ϴ� ������ �迭�̹Ƿ�
				// print �Ŀ� ������ �����Ѵ�.
				if(a*i + i*(i-1)/2 == N) {
					for(int k = 0 ; k < i ; k++) {
						System.out.print(a+k + " ");
					}
					return;
				} 
					
			}
		}
		// �� ���꿡�� �ɸ��� ���� ��� �����ϴ� ����Ʈ�� ���� ����̹Ƿ� -1�� ��ȯ�Ѵ�.
		System.out.println(-1);
	}
}
