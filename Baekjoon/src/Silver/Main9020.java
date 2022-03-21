package Silver;

import java.util.Scanner;

public class Main9020 {

	public static void main(String[] args) {
		// Scanner�� �̿��Ͽ� ���ڸ� �Է¹޴´�.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int n = sc.nextInt();
			prime_part(n);
		}
		sc.close();
	}
	public static void prime_part(int n) {
		// a, b�� ���ڸ� �޾� �� ���ڰ� �Ҽ����� �ƴ����� �Ǵ��ϱ� ���� �ʿ��� ����
		int a; int b;
		// r1, r2 : �Ҽ� partition ���ڸ� �����ϱ� ���� ����
		int r1 = 0; int r2 = 0;
		for(int i = 2; i <= n/2; i++) {
			a = i; b = n - a;
			if(prime_check(a) && prime_check(b)) {
				r1 = a; r2 = b;
			}
		}
		System.out.println(r1 + " " + r2);
	}
	// �־��� ���ڰ� �Ҽ����� �ƴ����� �Ǵ��ϴ� �Լ�
	public static boolean prime_check(int n) {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
