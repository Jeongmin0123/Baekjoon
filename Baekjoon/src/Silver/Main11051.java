package Silver;

import java.util.Scanner;

public class Main11051 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // N과 K가 1000보다 작거나 같으므로 배열의 크기를 아래와 같이 지정한다.
      int[][] combination = new int[1001][1001];
      int N = sc.nextInt();
      int K = sc.nextInt();
      for(int i = 0 ; i <= N ; i++) {
         for(int j = 0 ; j <= i ; j++) {
        	// 조합의 정의에 의해 i == j 거나 j == 0 인 경우 조합의 값은 1이다.
            if(i == j || j == 0) {
               combination[i][j] = 1;
            } else {
               // 파스칼 삼각형에 의해 아래와 같은 식을 얻을 수 있다.
               combination[i][j] = (combination[i-1][j-1] + combination[i-1][j])%10007;
            }
         }
      }
      System.out.println(combination[N][K]);
      sc.close();
   }
}