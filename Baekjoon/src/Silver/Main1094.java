package Silver;

import java.util.Scanner;

public class Main1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while(N > 0) {
			// ������� ���̸� 2�� �������� �� �������� �����Ѵٸ� �ᱹ �ڸ��� ���� �� �������� �������� ���� ������ 1���� ����Ⱑ �� �ʿ��ϹǷ�
			// �������� 1�� ���� count�� ������Ų��.
			if(N%2 == 1) {
				count++;
			} 
			N = N/2;
		}
		System.out.println(count);
	}

}
