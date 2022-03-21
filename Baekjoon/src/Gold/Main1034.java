package Gold;

import java.util.Scanner;

public class Main1034 {
   public static int[][] lamp;
   public static int M;
   public static int N;
   public static int K;
   public static String[] temp;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();
      lamp = new int[N][M];
      temp = new String[N];
      for(int i = 0 ; i < N ; i++) {
         temp[i] = sc.next();
         for(int j = 0 ; j < M ; j++) {
            // lamp[i][j] = temp[i].charAt(j); �� ������� �ʴ� ������
            // charAt �Լ��� char���� ��ȯ�ϴ� �Լ��̱� ������ lamp[i][j]��
            // 0�̳� 1�� �ƴ� 0�� �ƽ�Ű�ڵ� ���� 48�� 1�� �ƽ�Ű�ڵ� ���� 49��
            // �����ϱ� ������ ���� ��꿡 ������ �ֱ� ������ ���� ������� �����Ѵ�.
            lamp[i][j] = Integer.parseInt(temp[i].charAt(j)+"");
         }
      }
      K = sc.nextInt();
      System.out.println(max());
   }
   // �����ִ� ���� �ִ��� ���ϴ� �Լ�
   public static int max() {
      // �� �࿡ ���Ͽ� �� ���� �� ų�� �ִ��� �������� ���� ���θ� �����ϴ� booleanŸ�� �迭
      boolean[] check = new boolean[N];
      int max = 0;
      for(int i = 0 ; i < N ; i++) {
         // ��� �࿡ ���Ͽ� ��� ������ �� �Ӽ� �ִ����� ���� �����̴�.
         int count1 = 0;
         for(int j = 0 ; j < M ; j++) {
            // ���� ��� ���� ���° ���� 0�̶�� �� ���� �����־� ���ڸ� �ٲ���� �ϹǷ�
            // count1�� 1�����ش�.
            if(lamp[i][j] == 0) {
               count1++;
            }
         }
         // ��� ����ġ�� 2�� ������ �����·� ���ư��Ƿ� ��� ��� K�� ���Ͽ� 2�� �������� ��
         // �������� ���� count1�� K���� �۰ų� ������ �� ���� �� �� �ֱ� ������ check[i]
         // ���� true������ �����Ѵ�.
         if(count1 % 2 == K % 2 && count1 <= K) {
            check[i] = true;
         }
      }
      for(int i = 0 ; i < N ; i++) {
         // �� ���� �� ų�� �ִ� ��쿡�� ������ �����Ѵ�.
         if(check[i]) {
            // ų�� �ִ� �࿡ ���ؼ��� �� ��� ���� ������ ����� ���ڸ� ��ȯ�Ѵ�.
            int count2 = 0;
            for(int j = 0 ; j < N ; j++) {
               if(temp[i].equals(temp[j])) {
                  count2++;
               }
            }
            if(count2 > max) {
               max = count2;
            }
         }         
      }
   return max;
   }
}