package Bronze;

import java.util.Scanner;

public class Main2739 {

	public static void main(String[] args) {
//		N�� �Է¹��� ��, ������ N���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��� ���Ŀ� ���缭 ����ϸ� �ȴ�.
//		������İ� ���� N*1���� N*9���� ����Ѵ�
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i < 10; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
		}
		sc.close();
	}

}
