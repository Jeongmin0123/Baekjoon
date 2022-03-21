package Silver;

import java.util.Scanner;

public class Main1004 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      int[] result = new int[T];
      for(int i = 0 ; i < T ; i++) {
         int x1 = sc.nextInt();
         int y1 = sc.nextInt();
         int x2 = sc.nextInt();
         int y2 = sc.nextInt();
         int N = sc.nextInt();
         int sum = 0;
         for(int j = 0 ; j < N ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = sc.nextInt();
            // �ּ� ��ŻȽ���� sum���� �д�.
            sum += check(x1, y1, x2, y2, a, b, r);
         }
         result[i] = sum;
      }
      for(int i = 0 ; i < T ; i++) {
         System.out.println(result[i]);
      }
   }
   // x1, y1�� �����, x2, y2�� ������������ ���� a,b�� ���� �߽��� ��ǥ, r�� ���� ���������� �ΰ� Ǯ�̸� �����Ѵ�.
   public static int check(int x1, int y1, int x2, int y2, int a ,int b, int r) {
      // �༺�� ���� �̵��� �ᱹ �� �� �߿� ������ �༺�� �ܺ�, ������ �� ���� �༺�� ���ο� �����ϴ� ��� �Ͼ�Ƿ�
      // �� ������ ��쿡�� �༺���� �̵�Ƚ���� 1�����ϹǷ� 1�� ��ȯ�ϰ� �̿��� ��쿡�� 0�� ��ȯ�Ѵ�.
      // �� ���� �� ����, �� ���� �� ���ο� �����ϱ� ���ؼ��� ���� �߽ɰ� ��ǥ ������ �Ÿ���
      // �ϳ��� ���������� Ŀ���ϰ� �ϳ��� �۾ƾ� �Ѵ�.
      if(Math.sqrt(Math.pow(a-x1, 2)+Math.pow(b-y1, 2)) > r && Math.sqrt(Math.pow(a-x2, 2)+Math.pow(b-y2, 2)) < r) {
         return 1;
      } else if(Math.sqrt(Math.pow(a-x2, 2)+Math.pow(b-y2, 2)) > r && Math.sqrt(Math.pow(a-x1, 2)+Math.pow(b-y1, 2)) < r) {
         return 1;
      } else {
         return 0;
      }
   }

}