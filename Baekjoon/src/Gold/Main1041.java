package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1041 {
   // 주사위의 면은 6개이다.
   public static int[] plane = new int[6];
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      long N = sc.nextLong();
      for(int i = 0 ; i < 6 ; i++) {
         plane[i] = sc.nextInt();
      }
      long result = 0;
      // 만약 주사위의 개수가 1개인 경우 배열을 정렬한 뒤, 맨 마지막 숫자를 뺀 나머지를 다 더한다.
      if(N == 1) {
         Arrays.sort(plane);
         for(int i = 0 ; i < 5 ; i++) {
            result += plane[i];
         }
      }
      else {
         // 그림에 의해 면 3개가 보이는 주사위의 개수는 4개, 면 2개가 보이는 주사위의 개수는 8(N-2)+4
         // 면 1개가 보이는 주사위의 개수는 5(N-2)(N-2)+4(N-2)이다.
         result = min_3(plane)*4 + min_2(plane)*(8*(N-2)+4)+min_1(plane)*(5*(N-2)*(N-2)+4*(N-2));
      }
      System.out.println(String.valueOf(result));
      sc.close();
      
   }
   // 3면이 보이는 경우, 3면 숫자의 합의 가장 최소값을 구하는 함수
   public static int min_3(int[] arr) {
      int sum = 0;
      // 전개도에 의해서 (A,F), (B,F), (C,D) 면이 서로 짝을 이루면서 마주보게 되는데,
      // 주사위가 3면이 보이는 경우 각각의 쌍에서 하나의 면만 보인다.
      // 따라서 각각의 쌍에서 작은 값들을 구해 더해준다.
      for(int i = 0 ; i < 3 ; i ++) {
         sum += Math.min(arr[i], arr[5-i]);
      }
      return sum;
   }
   // 2면이 보이는 경우, 2면 숫자의 합의 가장 최소값을 구하는 함수
   public static int min_2(int[] arr) {
      int sum = 0;
      int[] arr_2 = new int[3];
      // 마찬가지로, 이 경우도 전개도에 의해서 (A,F), (B,F), (C,D)
      // 면이 서로 짝을 이루면서 마주보게 되는데, 주사위가 2면이 보이는 경우
      // 3개의 쌍에서 2개의 면이 보이게 된다.
      // 따라서 각각의 쌍에서 작은 값들을 구한 뒤에 가장 큰 값을 빼고 더해주면 최소값이 나오게된다.
      for(int i = 0 ; i < 3 ; i++) {
         arr_2[i] = Math.min(arr[i], arr[5-i]);
      }
      Arrays.sort(arr_2);
      for(int i = 0 ; i < 2 ; i++) {
         sum += arr_2[i];
      }
      return sum;
   }
   // 1면이 보이는 경우, 1면 숫자의 합의 가장 최소값을 구하는 함수
   public static int min_1(int[] arr) {
      // 정렬한 후 배열의 제일 앞값을 추출한다.
      Arrays.sort(arr);
      return arr[0];
   }
}