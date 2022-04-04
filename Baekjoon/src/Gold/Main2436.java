package Gold;

import java.util.Scanner;

public class Main2436 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int A = sc.nextInt();
      int B = sc.nextInt();
      // �Է¹޴� �� ���ڰ� 100,000,000���϶� �Է¹��� �� int Ÿ���� ����������
      // �� ���� ���� int�� ������ ��� �� �����Ƿ� long Ÿ������ �����Ѵ�. 
      long multi = (long) A*B;
      // ������� ���� ������ �����Ѵ�.
      int a = 0;
      int b = 0;
      // multi�� Math.sqrt(multi)���� ���� ���ڿ� �װͺ��� ū �� ����
      // ������ �̷���� �� �����Ƿ� Math.sqrt(multi)������ ������ �����ϰ�
      // i�� a�� ������ ��, �׿� ���� ������ a�� ������ ��, multi�� �� �� �ִ� ���� b�� �����Ѵ�.
      for(int i = A ; i <= Math.sqrt(multi) ; i += A) {
    	  // i�� multi/i�� �ִ������� A�� ��쿡 a�� b �� ������ �����Ѵ�
    	  // ���� �ִ������� A�� �ƴ� ��� �Է°��� ���ϱ� �����̴�.
         if(multi % i == 0 && euclidean(i, multi/i) == A) {
            a = i;
            b = (int) (multi / i);
         }
      }
      System.out.println(a + " " + b);
   }
   // ��Ŭ���� ȣ������ ���� �޼���
   // a�� b�� �ִ������� a%b�� b�� �ִ������� ���ٴ� ������ �̿��Ѵ�.
   public static long euclidean(long a, long b) {
      long r = a%b;
      if(r == 0) return b;
      return euclidean(b,r);
   }
}