package Bronze;

import java.util.Scanner;

public class Main1330 {

	public static void main(String[] args) {
// 		�� ���� A�� B�� �־����� ��, A�� B�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//		A�� B���� ū ��쿡�� '>'�� ����Ѵ�.
//		A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.
//		A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A > B) System.out.println(">");
		else if (A < B) System.out.println("<");
		else System.out.println("==");
		sc.close();
	}

}
