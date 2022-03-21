package Silver;

import java.util.Scanner;

public class Main1074 {

   public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      int n = sc.nextInt();
      int r = sc.nextInt();
      int c = sc.nextInt();
      System.out.println(Z(n,r,c));
   }
   // r�� c���� �� ��°�� �湮�ߴ��� ����ϴ� �Լ�
   public static int Z(int n, int r, int c) {
      // ���� n�� 1�̸� 2X2 ����̹Ƿ� �� ��� ������ ���°�� �湮�ϴ�����
      // 2*r + c�� ���� �� �ִ�.
      if(n == 1) {
         return 2*r+c;
      }
      //  Math.pow(2, n) * Math.pow(2, n) ����� ������ ��, ����� 4���� ���簢������ �ٽ� ����
      // ������ �����ϴ� ����Լ� ���·� ����Ǯ�̸� �����Ͽ���.
      if(r < Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
         return Z(n-1, (int) (r%(Math.pow(2, n-1))), (int) (c%(Math.pow(2, n-1))));
      } else if(r < Math.pow(2, n-1) && c < 2*Math.pow(2, n-1)) {
         return (int) (Math.pow(4, n-1))+ Z(n-1, (int) (r%(Math.pow(2, n-1))), (int) (c%(Math.pow(2, n-1))));
      } else if(r < 2*Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
         return (int) (2*Math.pow(4, n-1)) + Z(n-1, (int) (r%(Math.pow(2, n-1))), (int) (c%(Math.pow(2, n-1))));
      } else {
         return (int) (3*Math.pow(4, n-1)) + Z(n-1, (int) (r%(Math.pow(2, n-1))), (int) (c%(Math.pow(2, n-1))));
      }
   }
}