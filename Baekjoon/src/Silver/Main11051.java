package Silver;

import java.util.Scanner;

public class Main11051 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int[][] combination = new int[1001][1001];
      int N = sc.nextInt();
      int K = sc.nextInt();
      for(int i = 0 ; i <= N ; i++) {
         for(int j = 0 ; j <= i ; j++) {
            if(i == j || j == 0) {
               combination[i][j] = 1;
            } else {
               // �Ľ�Į �ﰢ���� ���� �Ʒ��� ���� ���� ���� �� �ִ�.
               combination[i][j] = (combination[i-1][j-1] + combination[i-1][j])%10007;
            }
         }
      }
      System.out.println(combination[N][K]);
      sc.close();
   }
}