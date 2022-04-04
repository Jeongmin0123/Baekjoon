package Gold;

import java.util.Scanner;

public class Main2436 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int A = sc.nextInt();
      int B = sc.nextInt();
      // 입력받는 두 숫자가 100,000,000이하라 입력받을 땐 int 타입이 가능하지만
      // 두 수의 곱은 int의 범위를 벗어날 수 있으므로 long 타입으로 선언한다. 
      long multi = (long) A*B;
      // 결과값을 받을 변수를 선언한다.
      int a = 0;
      int b = 0;
      // multi는 Math.sqrt(multi)보다 작은 숫자와 그것보다 큰 두 수의
      // 곱으로 이루어질 수 있으므로 Math.sqrt(multi)까지만 연산을 진행하고
      // i를 a로 지정한 후, 그에 따라 구해진 a와 곱했을 때, multi가 될 수 있는 수를 b로 지정한다.
      for(int i = A ; i <= Math.sqrt(multi) ; i += A) {
    	  // i와 multi/i의 최대공약수가 A인 경우에 a와 b 에 각각을 대입한다
    	  // 만약 최대공약수가 A가 아닌 경우 입력값에 반하기 때문이다.
         if(multi % i == 0 && euclidean(i, multi/i) == A) {
            a = i;
            b = (int) (multi / i);
         }
      }
      System.out.println(a + " " + b);
   }
   // 유클리드 호제법에 대한 메서드
   // a와 b의 최대공약수는 a%b와 b의 최대공약수와 같다는 원리를 이용한다.
   public static long euclidean(long a, long b) {
      long r = a%b;
      if(r == 0) return b;
      return euclidean(b,r);
   }
}