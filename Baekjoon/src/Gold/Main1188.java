package Gold;

import java.util.Scanner;

public class Main1188 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      // N개의 소시지를 M명한테 나누어 준다고 가정했을 때,
      // N개의 소시지를 길이가 N인 하나의 소시지라고 생각하면
      // M명에게 소시지를 나눠주기 위해서 M - 1 번의 칼질을 통해서 M등분 해야한다.
      // 이 때, 소시지의 연결부를 자르는 경우가 생기게 되는데 이 경우는 칼질 횟수에서 빼야한다.
      // 소시지의 연결부를 자르는 횟수는 gcd(N,M) - 1 이므로 결국 나눠주는 최소 칼질은
      // M-gcd(N,M)이 된다
      System.out.println(M-gcd(N,M));
   }
   // 유클리드 호제법을 이용하여 gcd(최대공약수)를 구하는 메서드
   public static int gcd(int a, int b) {
      if(b == 0) return a;
      return gcd(b, a % b);
   }

}