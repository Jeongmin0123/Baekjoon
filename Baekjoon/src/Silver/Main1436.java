package Silver;

import java.util.Scanner;

public class Main1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ���� �ȿ� �� �־�� �� ���ڰ� 666 �̹Ƿ� answer ������ 666�� �����Ѵ�.
		int answer = 666;
		int count = 0;
		// �Է¹��� ���ڱ���  count�� �ö� ������ �����Ѵ�.
		while(count != N) {
			// ���� �ȿ� 666�� �� ��� count�� ������Ų��.
			if(check_666(answer)) {
				count++;
			}
			answer++;
		}
		System.out.println(answer-1);
		sc.close();
	}
	// ���ڿ� 666�� ������ �ȵ����� �Ǵ��ϴ� �޼���
	public static boolean check_666(int n) {
		int count=0;
		// 6�� 3�� ������ while���� �����Ѵ�.
		while(count != 3) {
			// 10���� ������ �� �������� 6�� ��� count�� ������Ų��.
			if(n%10 == 6) {
				count++;
			} else {
				count = 0;
			}
			// �� ������ ���� �������� 6�� 3���� ��츸 true�� ��ȯ�ϰ� �Ѵ�.
			n = n/10;
			if(n==0) break;
		}
		if(count == 3) {
			return true;
		} else {
			return false;
		}
	}
}
