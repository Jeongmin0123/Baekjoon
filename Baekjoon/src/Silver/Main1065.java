package Silver;

import java.util.Scanner;

public class Main1065 {
	
	// ��� ������ �� �ڸ��� ���������� �̷�� �Ѽ������� �Ǻ��ϱ� ���� �Լ�
	// � ���ڰ� �Ѽ��� ��� true�� �ƴ� ��� false�� ��ȯ�Ѵ�.
	public static boolean func(int n) {
		if(n < 100) {
			// 100���� ���� ���� ������ �Ѽ��̴�.
			return true;
		}
		else {
			while((n/100) != 0) {
				/* (n/100) == 0 �� �Ǹ� n�� �� �ڸ����� �ȴ�.
				 * ������ �� �ڸ����� ������������ ����� ���Ͽ� �Ǵ��Ϸ���  �ּ� 3�ڸ����� �Ǿ�� �ϹǷ� 
				 * �� �̻� ������ ������ �� �����Ƿ� while���� �����Ѵ�.
				 */
				int result1 = (n/10)%10 - (n%10);	
				// n�� �� �� ���ڸ��� ���� ���Ѵ�.
				n = (n/10);
				int result2 = (n/10)%10 - (n%10);
				// n�� �ڿ��� 2,3��° �ڸ��� ���� ���Ѵ�.
				if((result1 != result2)) return false;
				// ���� result1 �� result�� �ٸ��� ���������� �ƴϹǷ� false�� ���ϰ����� ������.
			}
			return true;
			// while�� ������ return���� ������ ������ �� ���� ��� �ڸ����� ���������̹Ƿ� �Ѽ��̴�.
			// ���� true ���� ��ȯ�Ѵ�.
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] check = new boolean[N];
		// 1���� N������ ���ڿ� ���� �Ѽ� �Ǻ����θ� �����ϱ� ���� �迭�� �����.
		int count = 0;
		for(int i = 0 ; i < check.length ; i++) {
			check[i] = func(i+1);
			// func�� ���� �迭�� �Ѽ����� �ƴ����� ���θ� �����Ѵ�.
			// �̶� �迭�� �ڸ��� ���� ���ڴ� 0���� �����ϹǷ� ���ϱ� 1�� ���� �ڿ� �Լ��� �����Ѵ�.
			if(check[i]) count++;
			// ���� �迭�� i��° ���� �Ѽ���� �Ѽ��� ����(count)�� ������Ų��.
		}
		System.out.println(count);
		sc.close();
	}
}






















