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
   // r행 c열을 몇 번째로 방문했는지 출력하는 함수
   public static int Z(int n, int r, int c) {
      // 만약 n이 1이면 2X2 행렬이므로 그 행렬 내에서 몇번째로 방문하는지는
      // 2*r + c로 구할 수 있다.
      if(n == 1) {
         return 2*r+c;
      }
      //  Math.pow(2, n) * Math.pow(2, n) 행렬이 존재할 때, 행렬을 4개의 정사각형으로 다시 나눠
      // 연산을 진행하는 재귀함수 형태로 문제풀이를 진행하였다.
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