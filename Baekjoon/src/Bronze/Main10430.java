package Bronze;

import java.util.Scanner;

public class Main10430 {

	public static void main(String[] args) {	
//		(A+B)%C�� ((A%C) + (B%C))%C �� ������?
//		(A��B)%C�� ((A%C) �� (B%C))%C �� ������?
//		�� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
		sc.close();
	}

}
