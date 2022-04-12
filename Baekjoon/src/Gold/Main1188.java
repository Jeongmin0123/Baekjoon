package Gold;

import java.util.Scanner;

public class Main1188 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      // N���� �ҽ����� M������ ������ �شٰ� �������� ��,
      // N���� �ҽ����� ���̰� N�� �ϳ��� �ҽ������ �����ϸ�
      // M���� �ҽ����� �����ֱ� ���ؼ� M - 1 ���� Į���� ���ؼ� M��� �ؾ��Ѵ�.
      // �� ��, �ҽ����� ����θ� �ڸ��� ��찡 ����� �Ǵµ� �� ���� Į�� Ƚ������ �����Ѵ�.
      // �ҽ����� ����θ� �ڸ��� Ƚ���� gcd(N,M) - 1 �̹Ƿ� �ᱹ �����ִ� �ּ� Į����
      // M-gcd(N,M)�� �ȴ�
      System.out.println(M-gcd(N,M));
   }
   // ��Ŭ���� ȣ������ �̿��Ͽ� gcd(�ִ�����)�� ���ϴ� �޼���
   public static int gcd(int a, int b) {
      if(b == 0) return a;
      return gcd(b, a % b);
   }

}