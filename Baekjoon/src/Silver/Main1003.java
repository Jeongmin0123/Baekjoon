package Silver;

import java.util.Scanner;

public class Main1003 {
   // N이 40보다 적거나 같은 자연수 또는 0이므로 41개의 숫자가 가능하므로 배열의 크기를 41로 한다.
   static Integer[][] depth = new Integer[41][2];
   public static void main(String[] args) {
      depth[0][0] = 1;   // N이 0일때 0을 부르는 횟수
      depth[0][1] = 0;   // N이 0일때 1을 부르는 횟수
      depth[1][0] = 0;   // N이 1일때 0을 부르는 횟수
      depth[1][1] = 1;   // N이 1일때 1을 부르는 횟수
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
   // 0과 1의 갯수를 구하기 위한 함수
   static Integer[] fib(int N) {
      // N에 대한 계산결과가 없을 경우에만 계산을 진행한다.
      if(depth[N][0] == null && depth[N][1] == null) {
         // 피보나치 수열은 An = An-1 + An-2 이므로 각각의
         // N번째 숫자에서 0을 호출하는 횟수와 1을 호출하는 횟수는
         // 그 전 두 숫자에서 0과 1을 호출하는 횟수의 합과 같다. 
         depth[N][0] = fib(N-1)[0] + fib(N-2)[0];
         depth[N][1] = fib(N-1)[1] + fib(N-2)[1];
      }
      // 0과 1의 호출횟수를 가지고 있는 배열을 반환한다.
      return depth[N];
   }

}
