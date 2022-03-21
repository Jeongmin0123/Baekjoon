package Silver;

import java.util.Scanner;

public class Main4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 0�� ���� ������ ��� ����Ǵ� ���ѷ����� ����Ѵ�.
		while(true) {
			int n = sc.nextInt();
			int count = 0;
			// n�� 2n ������ ���� ���� prime�� ���� ������ ������ ������ count�� �ö󰣴�.
			for(int i = n+1; i <=2*n ; i++) {
				if(prime_check(i)) {
					count++;
				}
			}
			if(n == 0) break;
			System.out.println(count);
		}
		sc.close();
	}
	// �־��� ���ڰ� �Ҽ�����, �ƴ����� �Ǵ��Ͽ� boolean ���� �������ִ� �Լ�
	public static boolean prime_check(int n) {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
