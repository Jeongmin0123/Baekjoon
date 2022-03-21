package Silver;

import java.util.Scanner;

public class Main1003 {
   // N�� 40���� ���ų� ���� �ڿ��� �Ǵ� 0�̹Ƿ� 41���� ���ڰ� �����ϹǷ� �迭�� ũ�⸦ 41�� �Ѵ�.
   static Integer[][] depth = new Integer[41][2];
   public static void main(String[] args) {
      depth[0][0] = 1;   // N�� 0�϶� 0�� �θ��� Ƚ��
      depth[0][1] = 0;   // N�� 0�϶� 1�� �θ��� Ƚ��
      depth[1][0] = 0;   // N�� 1�϶� 0�� �θ��� Ƚ��
      depth[1][1] = 1;   // N�� 1�϶� 1�� �θ��� Ƚ��
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      StringBuilder sb = new StringBuilder();
      while(T-- > 0) {
         int N = sc.nextInt();
         fib(N);
         sb.append(depth[N][0] + " " + depth[N][1]).append('\n');
      }
      System.out.print(sb);
   }
   // 0�� 1�� ������ ���ϱ� ���� �Լ�
   static Integer[] fib(int N) {
      // N�� ���� ������� ���� ��쿡�� ����� �����Ѵ�.
      if(depth[N][0] == null && depth[N][1] == null) {
         // �Ǻ���ġ ������ An = An-1 + An-2 �̹Ƿ� ������
         // N��° ���ڿ��� 0�� ȣ���ϴ� Ƚ���� 1�� ȣ���ϴ� Ƚ����
         // �� �� �� ���ڿ��� 0�� 1�� ȣ���ϴ� Ƚ���� �հ� ����. 
         depth[N][0] = fib(N-1)[0] + fib(N-2)[0];
         depth[N][1] = fib(N-1)[1] + fib(N-2)[1];
      }
      // 0�� 1�� ȣ��Ƚ���� ������ �ִ� �迭�� ��ȯ�Ѵ�.
      return depth[N];
   }

}
